package com.example.patientsmanagement.security.service;

import com.example.patientsmanagement.security.entities.AppRole;
import com.example.patientsmanagement.security.entities.AppUser;
import com.example.patientsmanagement.security.repositories.AppRoleRepository;
import com.example.patientsmanagement.security.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser addUser(String username, String password, String confirmPassword, String email) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser != null) throw new RuntimeException("user already exist");
        if (!password.equals(confirmPassword))  throw new RuntimeException("password not match");
        appUser = AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addRole(String role) {
        AppRole appRole = appRoleRepository.findById(role).orElse(null);
        if (appRole != null) throw new RuntimeException("role already exist");
        appRole = AppRole.builder().role(role).build();
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser user = appUserRepository.findByUsername(username);
        if (user == null) throw new RuntimeException("user not exist");
        AppRole appRole = appRoleRepository.findById(role).orElse(null);
        if (appRole == null) throw new RuntimeException("role not exist");
        user.getRoles().add(appRole);

    }


    @Override
    public void removeRoleFromUser(String username, String role) {
        AppUser user = appUserRepository.findByUsername(username);
        if (user == null) throw new RuntimeException("user not exist");
        AppRole appRole = appRoleRepository.findById(role).orElse(null);
        if (appRole == null) throw new RuntimeException("role not exist");
        user.getRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
