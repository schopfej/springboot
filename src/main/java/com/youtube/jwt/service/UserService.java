package com.youtube.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    public User registerNewUser(User user) {
        return userDao.save(user);
    }
}
