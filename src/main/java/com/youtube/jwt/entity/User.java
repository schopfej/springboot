package com.youtube.jwt.entity;

import java.util.Set;


import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

/**
 * Represents a User entity in the system.
 * This class stores basic user information such as username and first name.
 * It can be used for authentication, user management, and profile handling.
 * 
 */

@Entity
public class User {
    @Id
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;

    // we have to create an association between Columns UserRole And User in the DB

    // because m .... n (association) --> a user can have many roles
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE", 
    joinColumns = {
        @JoinColumn(name = "USER_ID")
    },
    inverseJoinColumns = {
        @JoinColumn(name = "ROLE_ID")
    }
    )
    private Set<Role> role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

}
