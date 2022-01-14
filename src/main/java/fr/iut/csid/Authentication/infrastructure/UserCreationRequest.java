package fr.iut.csid.Authentication.infrastructure;

import java.util.UUID;

public class UserCreationRequest {

    //private UUID id_user;
    private String username;
    private String password;

    public UserCreationRequest(String username, String password/*, UUID id_user*/){
        this.username = username;
        this.password = password;
       // this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
