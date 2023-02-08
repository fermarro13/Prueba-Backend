package com.example.demo.web;

import com.example.demo.model.Meal;
import com.example.demo.svc.MealSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealsRs {


    @Autowired
    MealSvc mealSvc;

    @GetMapping("/")
    public ResponseEntity<List<Meal>> meals(Principal principal){
        return ResponseEntity.ok().body(mealSvc.findMealByUsername(principal.getName()));
    }


}
