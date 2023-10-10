package com.example.patientsmanagement.security;


import com.example.patientsmanagement.security.service.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class SecurityConfig {


    private PasswordEncoder passwordEncoder;
    private UserDetailsImpl userDetailsImpl;

    //@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return  new InMemoryUserDetailsManager(
                User.withUsername("user1").password(passwordEncoder.encode("12345")).roles("USER").build(),
                User.withUsername("user2").password(passwordEncoder.encode("12345")).roles("USER").build(),
                User.withUsername("admin").password(passwordEncoder.encode("12345")).roles("USER","ADMIN").build()
        );
    }

    //@Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity,RememberMeServices rememberMeServices)
            throws Exception {


        httpSecurity.authorizeHttpRequests(web -> web
                .requestMatchers("/webjars/**").permitAll()
        );

        httpSecurity.formLogin(login->login.loginPage("/login").defaultSuccessUrl("/").permitAll());



       /* httpSecurity.authorizeHttpRequests(auth -> auth
                .requestMatchers("/user/**").hasRole("USER"));*/

       /* httpSecurity.authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin/**").hasRole("ADMIN")
        );*/


        httpSecurity.exceptionHandling(exp->exp.accessDeniedPage("/notAuthorized"));

        httpSecurity
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated()
                )
                .rememberMe((remember) -> remember
                        .rememberMeServices(rememberMeServices)
                );

        httpSecurity.userDetailsService(userDetailsImpl);

        return httpSecurity.build();

    }

    @Bean
    RememberMeServices rememberMeServices(UserDetailsImpl userDetailsImpl) {
        TokenBasedRememberMeServices.RememberMeTokenAlgorithm encodingAlgorithm = TokenBasedRememberMeServices.RememberMeTokenAlgorithm.SHA256;
        TokenBasedRememberMeServices rememberMe = new TokenBasedRememberMeServices("test", userDetailsImpl, encodingAlgorithm);
        rememberMe.setMatchingAlgorithm(TokenBasedRememberMeServices.RememberMeTokenAlgorithm.MD5);
        return rememberMe;
    }





}
