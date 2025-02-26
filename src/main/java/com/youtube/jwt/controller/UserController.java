package com.youtube.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.User;
import com.youtube.jwt.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registerNewUser")

    public User registerNewUser(@RequestBody User user) {
            return userService.registerNewUser(user);

    }

}
