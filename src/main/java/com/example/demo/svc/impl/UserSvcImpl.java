package com.example.demo.svc.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.svc.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSvcImpl implements UserSvc {

    @Autowired
    private UserDao userDao;


    public String findUserByUsername(String username){
        User user = userDao.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }else{
            return user.getMeals().toString();//return user;
        }
    }
}
