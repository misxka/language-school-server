package org.verigo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import org.verigo.data_access.UsersRepository;
import org.verigo.models.User;

import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping(path = "")
    public @ResponseBody
    ResponseEntity<List<User>> getAll() {
        List<User> users = usersRepository.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(path = "")
    public @ResponseBody
    ResponseEntity<User> addUser(@RequestBody User user) {

        //TODO Add validation of login and password



        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
        try {
            User createdUser = usersRepository.save(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
         } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
