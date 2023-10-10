package com.example.patientsmanagement.security.repositories;

import com.example.patientsmanagement.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,String> {
}
