package com.example.demojpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "USERS")
@Data
@AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    private String userId;
   @Column(unique = true , length = 15)
    private String userName;
    private String password;
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    //@JoinTable(name = "Users-Roles")
    private List<Role> roles = new ArrayList<>();
}
