package com.example.demo.util;

import com.example.demo.model.Meal;
import com.example.demo.model.User;

public interface UtilSvc {
    void fillMeals(User user);

    Meal jsonToMeal(String json);
}
