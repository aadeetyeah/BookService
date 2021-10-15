package com.procrastinator.BookService.controllers;

import com.procrastinator.BookService.models.User;
import com.procrastinator.BookService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

}
