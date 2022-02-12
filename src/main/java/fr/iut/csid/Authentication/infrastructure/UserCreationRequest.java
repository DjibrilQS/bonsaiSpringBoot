package fr.iut.csid.Authentication.infrastructure;

import java.util.UUID;

public class UserCreationRequest {

    private UserCredentials userCredentials;

    public UserCreationRequest(UserCredentials userCredentials){
       this.userCredentials = userCredentials;
    }

    public String getUsername() {
        return userCredentials.getUsername();
    }


    public String getPassword() {
        return userCredentials.getPassword();
    }

}
