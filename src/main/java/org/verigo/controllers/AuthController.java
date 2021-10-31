package org.verigo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.verigo.data_access.UserRepository;
import org.verigo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/")
    public @ResponseBody
    ResponseEntity<Response> authUser(@RequestBody AuthRequest req) {
        User user = userRepository.findByLogin(req.getLogin());

        if(user == null || !BCrypt.checkpw(req.getPassword(), user.getPassword())) {
            return new ResponseEntity<>(new Response("Failed"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new Response("Success"), HttpStatus.OK);
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

class Response {
    private String message;

    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}