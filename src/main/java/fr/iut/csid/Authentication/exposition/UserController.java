package fr.iut.csid.Authentication.exposition;
import fr.iut.csid.Authentication.domain.model.AppUser;
import fr.iut.csid.Authentication.domain.service.UserService;
import fr.iut.csid.Authentication.infrastructure.UserCreationRequest;
import fr.iut.csid.Authentication.infrastructure.UserCredentials;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService uService) {
        this.userService = uService;
    }

    @PostMapping
    public void createUser(@RequestBody UserCredentials user) {
        this.userService.create(new UserCreationRequest(user.getUsername(), user.getPassword()));
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
//
//    @PutMapping("/{uuid}/authority")
//    public ResponseEntity changeAuthority(@PathVariable UUID uuid, String newAuthority){
//
//    }
}