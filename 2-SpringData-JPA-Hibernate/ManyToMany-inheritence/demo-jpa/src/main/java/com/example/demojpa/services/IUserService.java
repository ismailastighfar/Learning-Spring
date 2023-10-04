package com.example.demojpa.services;

import com.example.demojpa.entities.Role;
import com.example.demojpa.entities.User;

public interface IUserService {
    User addUser(User user);
    Role addRole(Role role);
    User findUserByUserName(String username);
    Role findRoleByRoleName(String rolename);
    void addRoleToUser(String username,String rolename);
    User Auth(String username,String password);
}
