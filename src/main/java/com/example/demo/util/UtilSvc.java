package com.example.demo.util;

import com.example.demo.model.Meal;
import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UtilSvc {
    void fillMeals(User user);

    Meal jsonToMeal(String json);

    List paginateList(List<Meal> list,int page,int size);
}
