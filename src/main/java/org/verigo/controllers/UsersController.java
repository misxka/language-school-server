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
import java.util.Optional;

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
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
        try {
            User createdUser = usersRepository.save(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
         } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        User foundUser = usersRepository.findById(id);
        if(foundUser == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        User updatedUser = usersRepository.save(foundUser.update(user));

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
