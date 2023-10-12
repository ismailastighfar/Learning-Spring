package com.me.secureservice.security.services;

import com.me.secureservice.security.entities.AppRole;
import com.me.secureservice.security.entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addUser(AppUser user);
    AppRole addRole(AppRole role);
    void addRoleToUser(String username,String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();

}
