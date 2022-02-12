package fr.iut.csid.Authentication.exposition;
import fr.iut.csid.Authentication.Mapper;
import fr.iut.csid.Authentication.domain.model.AppUser;
import fr.iut.csid.Authentication.domain.service.UserService;
import fr.iut.csid.Authentication.infrastructure.UserCreationRequest;
import fr.iut.csid.Authentication.infrastructure.UserCredentials;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService uService) {
        this.userService = uService;
    }

    @PostMapping
    public void createUser(@RequestBody UserCredentials user) {
        this.userService.create(new UserCreationRequest(user));
    }



    @PutMapping("/me/password")
    public ResponseEntity changePassword(@RequestParam String oldPassw, @RequestParam String newPassw, @RequestParam String confirmPassw) {
        AppUser credentials = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.encode(oldPassw).equals(encoder.encode(credentials.getPassword()))) {
            if(newPassw.equals(confirmPassw)) {
                this.userService.updatePassword(credentials.getUsername(), newPassw);
                return ResponseEntity.ok().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }


    @GetMapping
    @PreAuthorize("hasAuthority('STAFF')")
    public List<UserDTO> getUsers(){
        return userService.getAllUsers().stream().map(Mapper::mapFromModel).collect(Collectors.toList());
    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> getMe(){
        return userService.getMe().map(Mapper::mapFromModel).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


}