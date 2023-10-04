package com.example.demojpa.repositories;

import com.example.demojpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findUserByUserName(String userName);
}
