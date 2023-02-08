package com.example.demo.web;

import com.example.demo.svc.UserSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/meals")
@Slf4j
public class MealsRs {


    @Autowired
    UserSvc userSvc;

    @GetMapping("/")
    public String meals(Principal principal){
        return userSvc.findUserByUsername(principal.getName());
    }


}
