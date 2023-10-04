package com.example.demojpa.services;

import com.example.demojpa.entities.Role;
import com.example.demojpa.entities.User;
import com.example.demojpa.repositories.RoleRepository;
import com.example.demojpa.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public User addUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {

        return userRepository.findUserByUserName(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
       User user = findUserByUserName(userName);
       Role role = findRoleByRoleName(roleName);
       user.getRoles().add(role);
       role.getUsers().add(user);
    }

    @Override
    public User Auth(String username, String password) {
        User user = userRepository.findUserByUserName(username);
        if (user == null) throw new RuntimeException("false credentials");

        if (password.equals(user.getPassword())) {
            return user;
        }
        throw new RuntimeException("false credentials");
    }
}
