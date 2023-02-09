package com.example.demo.svc;


import com.example.demo.model.Meal;

import java.util.List;

public interface MealSvc {
    List<Meal> findMealByUsername(String username,int page,int size);
}
