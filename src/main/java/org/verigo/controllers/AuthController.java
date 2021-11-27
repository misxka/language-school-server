package org.verigo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.verigo.data_access.UsersRepository;
import org.verigo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/auth")
public class AuthController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping(path = "")
    public @ResponseBody
    ResponseEntity<AuthResponse> authUser(@RequestBody AuthRequest req) {
        User user = usersRepository.findByLogin(req.getLogin());

        if(user == null || !BCrypt.checkpw(req.getPassword(), user.getPassword())) {
            return new ResponseEntity<>(new AuthResponse("Failed", user), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new AuthResponse("Success", user), HttpStatus.OK);
    }
}

class AuthRequest {
    private String login;
    private String password;

    public AuthRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

class AuthResponse {
    private String message;
    private User user;

    public AuthResponse(String message, User user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}