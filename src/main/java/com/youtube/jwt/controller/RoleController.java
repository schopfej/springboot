package com.youtube.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.Role;
import com.youtube.jwt.service.RoleService;

/*
 * This class is an Endpoint for creating new Roles
 * it takes the Role class of our other created Role (class) 
 * I
 */


@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping({"/createNewRole"})
    
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }
}