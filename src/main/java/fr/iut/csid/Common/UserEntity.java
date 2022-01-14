package fr.iut.csid.Common;

import fr.iut.csid.Authentication.infrastructure.AuthorityEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "id_user")
    private UUID id_user;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "authorityId.uuid", cascade = {CascadeType.ALL})
    private List<AuthorityEntity> authorities;

    public UserEntity(){

    }
    public UUID getId_user() {
        return id_user;
    }

    public void setId_user(UUID id_user) {
        this.id_user = id_user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<AuthorityEntity> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthorityEntity> authorities) {
        this.authorities = authorities;
    }
}