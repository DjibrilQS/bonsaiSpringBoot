package fr.iut.csid.Authentication.domain.service;

import fr.iut.csid.Authentication.Mapper;
import fr.iut.csid.Authentication.domain.model.AppUser;
import fr.iut.csid.Authentication.domain.model.UserModel;
import fr.iut.csid.Authentication.infrastructure.AuthorityEntity;
import fr.iut.csid.Authentication.infrastructure.AuthorityId;
import fr.iut.csid.Authentication.infrastructure.UserCreationRequest;
import fr.iut.csid.Authentication.infrastructure.UserCredentials;
import fr.iut.csid.Common.UserDao;
import fr.iut.csid.Common.UserEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void create(UserCreationRequest userCreationRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userCreationRequest.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userCreationRequest.getPassword()));
        UserEntity savedUser = userDao.save(userEntity);

        List<AuthorityEntity> authorities = new ArrayList<>();
        authorities.add(new AuthorityEntity(AuthorityId.getDefaultAuthority(savedUser.getId_user())));
        savedUser.setAuthorities(authorities);
        userDao.save(savedUser);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = userDao.findByUsername(s);
        List<String> authoritiesList = userDao.findAuthorityByUserId(user.getId_user());
        String authorities = String.join(",", authoritiesList);
        return new AppUser(user.getId_user(), user.getUsername(), user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
    }

    public void updatePassword(String username, String nwPassword) {
        UserEntity user = userDao.findByUsername(username);
        user.setPassword(nwPassword);
        userDao.save(user);
    }

    public List<UserModel> getAllUsers() {
        return userDao.findAll().stream().map(Mapper::mapFromEntity).collect(Collectors.toList());
    }

    public Optional<UserModel> getMe() {
        AppUser credentials = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDao.findById(credentials.getId()).map(Mapper::mapFromEntity);
    }
}
