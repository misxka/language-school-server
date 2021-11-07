package org.verigo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.verigo.data_access.UsersRepository;
import org.verigo.models.User;

import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping(path = "/")
    public @ResponseBody
    ResponseEntity<List<User>> getAll() {
        List<User> users = usersRepository.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
