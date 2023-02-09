package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Data
@Table(name = "meals")
public class Meal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "meal_id")
    private Long mealId;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "origin")
    private String origin;

    @Column(name = "image")
    private String image;

    @Column(name = "url")
    private String url;

}