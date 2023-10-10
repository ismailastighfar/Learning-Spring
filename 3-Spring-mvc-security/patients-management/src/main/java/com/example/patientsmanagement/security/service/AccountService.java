package com.example.patientsmanagement.security.service;

import com.example.patientsmanagement.security.entities.AppRole;
import com.example.patientsmanagement.security.entities.AppUser;

public interface AccountService {
    AppUser addUser(String username,String password,String confirmPassword,String email);
    AppRole addRole(String role);
    void addRoleToUser(String username,String role);
    void removeRoleFromUser(String username,String role);
    AppUser loadUserByUsername(String username);
}
