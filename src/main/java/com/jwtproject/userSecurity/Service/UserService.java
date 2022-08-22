package com.jwtproject.userSecurity.Service;

import com.jwtproject.userSecurity.Entity.Role;
import com.jwtproject.userSecurity.Entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();
    boolean existsByUsername(String username);

}
