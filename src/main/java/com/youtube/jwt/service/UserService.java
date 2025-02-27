package com.youtube.jwt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.RoleDao;
import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.entity.Role;
import com.youtube.jwt.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public User registerNewUser(User user) {
        return userDao.save(user);
    }

    // just to make some default roles
    public void initRolesAndUser() {
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Description of the Admin");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Description of default User");
        roleDao.save(userRole);
        
        User adminUser = new User(); 
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin1234");
        adminUser.setUserPassword("admin@password");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        //that we have an association 
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User(); 
        user.setUserFirstName("jonathan");
        user.setUserLastName("schopfer");
        user.setUserName("schopfej1234");
        user.setUserPassword("schopfej@password");
        
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        //again that we have this info in the DB
        user.setRole(userRoles);
        userDao.save(user);

    }
}
