package com.me.secureservice.security.services;

import com.me.secureservice.security.entities.AppRole;
import com.me.secureservice.security.entities.AppUser;
import com.me.secureservice.security.repositories.AppRoleRepository;
import com.me.secureservice.security.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public AppUser addUser(AppUser user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return appUserRepository.save(user);
    }

    @Override
    public AppRole addRole(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = appUserRepository.findByUsername(username);
        AppRole role = appRoleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }
}
