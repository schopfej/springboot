package com.youtube.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.User;
import com.youtube.jwt.service.UserService;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController

public class UserController {
    @Autowired
    private UserService userService;


    //we want to add this method when app is constructed
    @PostConstruct
    public void initRolesAndUser() {
        userService.initRolesAndUser();
    }

    @PostMapping("/registerNewUser")

    public User registerNewUser(@RequestBody User user) {
            return userService.registerNewUser(user);

    }

    //Add two new EndPoints
    @GetMapping("/forAdmin")
    public String forAdmin() {
        return "This URL is only accessible to admin";
    }
    @GetMapping("/forUser")
    public String forUser() {
        return "This URL is only accessible to the user";
    }

}
