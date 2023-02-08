package com.example.demo.util.impl;

import com.example.demo.model.User;
import com.example.demo.util.UtilSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UtilSvcImpl implements UtilSvc {
    @Async
    public void fillMeals(User user){
        try {
            Thread.sleep(10000L);
            System.out.println("Execute method asynchronously. "
                    + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
