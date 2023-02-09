package com.example.demo.svc.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Meal;
import com.example.demo.model.User;
import com.example.demo.svc.MealSvc;
import com.example.demo.util.UtilSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MealSvcImpl implements MealSvc {

    private final String STATUS_BLANK = "BLK";
    private final String STATUS_WRITING = "WRI";
    @Autowired
    private UserDao userDao;

    @Autowired
    UtilSvc utilSvc;

    @Override
    public List<Meal> findMealByUsername(String username){
        User user = userDao.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        } else if (user.getUserMeals().isEmpty() && STATUS_BLANK.equals(user.getMealStatus())) {
            user.setMealStatus(STATUS_WRITING);
            userDao.save(user);
            utilSvc.fillMeals(user);
            return Collections.EMPTY_LIST;
        } else{
            return user.getUserMeals().stream().toList();
        }
    }
}
