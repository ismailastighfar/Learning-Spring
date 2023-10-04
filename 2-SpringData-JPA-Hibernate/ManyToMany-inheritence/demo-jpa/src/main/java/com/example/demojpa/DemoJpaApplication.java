package com.example.demojpa;

import com.example.demojpa.entities.Role;
import com.example.demojpa.entities.User;
import com.example.demojpa.services.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner start(IUserService userService){
		return args -> {

			User user = new User();
			user.setUserName("ismail");
			user.setPassword("123456789");
			userService.addUser(user);

			User user1 = new User();
			user1.setUserName("oumnia");
			user1.setPassword("123456789");
			userService.addUser(user1);

			User user2 = new User();
			user2.setUserName("admin");
			user2.setPassword("123456789");
			userService.addUser(user2);

			Stream.of("STUDENT","ADMIN","USER").forEach(r->{
				Role role = new Role();
				role.setRoleName(r);
				userService.addRole(role);
			});

			userService.addRoleToUser("ismail","STUDENT");
			userService.addRoleToUser("admin","ADMIN");
			userService.addRoleToUser("ismail","USER");
			userService.addRoleToUser("admin","USER");
			userService.addRoleToUser("oumnia","USER");

            try {
				User user3 = userService.Auth("ismail","123456789");
				System.out.println(user3.getUserName());
				System.out.println("Roles --> ");
				user3.getRoles().forEach(r->{
					System.out.println("Role --> "+r);
				});
			}
			catch (Exception e){
				e.printStackTrace();
			}


        };
	}
}
