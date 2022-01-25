package com.mongoDB.MongoDb.controller;

import com.mongoDB.MongoDb.models.User;
import com.mongoDB.MongoDb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// Restfull controller
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public  UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return  userRepository.findAll();
    }
}
