package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "meal_status")
    private String mealStatus;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<Role> roles;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Meal> meals;

}
