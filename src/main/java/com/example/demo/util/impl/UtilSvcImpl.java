package com.example.demo.util.impl;

import com.example.demo.dao.MealDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Meal;
import com.example.demo.model.User;
import com.example.demo.util.RestClient;
import com.example.demo.util.UtilSvc;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class UtilSvcImpl implements UtilSvc {

    private final int MAX_MEALS = 30;
    private final int MAX_ATTEMPTS = 5;

    private final String STATUS_END = "END";

    private final String STATUS_ERR = "ERR";

    @Autowired
    private UserDao userDao;

    @Autowired
    private MealDao mealDao;

    @Autowired
    private RestClient restClient;

    @Async
    @Override
    public void fillMeals(User user) {
        try {
            int attempts = 1;
            Set<Meal> meals = new HashSet<>();
            ResponseEntity<String> response;
            while (meals.size() < MAX_MEALS) {
                response = restClient.get("https://www.themealdb.com/api/json/v1/1/random.php");
                if (response.getStatusCode().equals(HttpStatusCode.valueOf(200))) {
                    Meal meal = jsonToMeal(response.getBody());
                    mealDao.save(meal);
                    meals.add(meal);
                    user.setUserMeals(meals);
                    userDao.save(user);
                } else {
                    log.error(response.getStatusCode().toString(), response.getBody());
                    user.setMealStatus(STATUS_ERR);
                    userDao.save(user);
                    if (attempts == MAX_ATTEMPTS) {
                        break;
                    }
                    attempts++;
                }
            }
            user.setMealStatus(user.getMealStatus()==STATUS_ERR?STATUS_ERR:STATUS_END);
            userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            user.setMealStatus(STATUS_ERR);
            userDao.save(user);
        }
    }

    @Override
    public Meal jsonToMeal(String json){
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
        Meal meal = new Meal();
        meal.setMealId(
                Long.valueOf(
                        jsonObject.getAsJsonArray("meals").get(0).getAsJsonObject().getAsJsonPrimitive("idMeal").toString().replace("\"","")
                ));
        meal.setName(jsonObject.getAsJsonArray("meals").get(0).getAsJsonObject().getAsJsonPrimitive("strMeal").toString());
        meal.setUrl(jsonObject.getAsJsonArray("meals").get(0).getAsJsonObject().getAsJsonPrimitive("strYoutube").toString());
        meal.setImage(jsonObject.getAsJsonArray("meals").get(0).getAsJsonObject().getAsJsonPrimitive("strMealThumb").toString());
        meal.setCategory(jsonObject.getAsJsonArray("meals").get(0).getAsJsonObject().getAsJsonPrimitive("strCategory").toString());
        meal.setOrigin(jsonObject.getAsJsonArray("meals").get(0).getAsJsonObject().getAsJsonPrimitive("strArea").toString());
        return meal;
    }


    @Override
    public List paginateList(List<Meal> list,int page,int size) {
        if(size <= 0 || page <= 0) {
            throw new IllegalArgumentException("invalid page size: " + size);
        }

        int fromIndex = (page - 1) * size;
        if(list == null || list.size() <= fromIndex){
            return Collections.emptyList();
        }

        return list.subList(fromIndex, Math.min(fromIndex + size, list.size()));
    }
}
