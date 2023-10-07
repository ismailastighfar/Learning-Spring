package com.example.patientsmanagement;

import com.example.patientsmanagement.entities.Patient;
import com.example.patientsmanagement.repositories.PatientRepository;
import com.example.patientsmanagement.security.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsManagementApplication.class, args);


    }

    //@Bean
    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager){
        PasswordEncoder passwordEncoder = passwordEncoder();
        return args -> {
            UserDetails u1 = jdbcUserDetailsManager.loadUserByUsername("ismail");
            if (u1 == null) {
                jdbcUserDetailsManager.createUser(
                        User.withUsername("ismail")
                                .password(passwordEncoder.encode("1234"))
                                .roles("USER").build());
            }
            UserDetails u2 = jdbcUserDetailsManager.loadUserByUsername("oumnia");
            if (u2 == null) {
                jdbcUserDetailsManager.createUser(
                        User.withUsername("oumnia")
                                .password(passwordEncoder.encode("1234"))
                                .roles("USER").build());
            }
            UserDetails admin = jdbcUserDetailsManager.loadUserByUsername("admin");
            if (admin == null) {
                jdbcUserDetailsManager.createUser(
                        User.withUsername("admin")
                                .password(passwordEncoder.encode("1234"))
                                .roles("USER","ADMIN").build());
            }

        };
    }

    //@Bean
    CommandLineRunner commandLineRunnerUserDetails(AccountService accountService){
      return args -> {
          accountService.addRole("USER");
          accountService.addRole("ADMIN");
          accountService.addUser("user1","1234","1234","user1@gmail.com");
          accountService.addUser("user2","1234","1234","user2@gmail.com");
          accountService.addUser("admin","1234","1234","admin@gmail.com");
          accountService.addRoleToUser("user1","USER");
          accountService.addRoleToUser("user2","USER");
          accountService.addRoleToUser("admin","USER");
          accountService.addRoleToUser("admin","ADMIN");
      };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }







}
