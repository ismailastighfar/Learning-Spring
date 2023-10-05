package com.example.patientsmanagement;

import com.example.patientsmanagement.entities.Patient;
import com.example.patientsmanagement.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsManagementApplication.class, args);
    }




}
