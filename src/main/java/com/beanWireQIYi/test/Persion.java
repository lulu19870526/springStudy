package com.beanWireQIYi.test;

import com.beanWireQIYi.service.Traffic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Persion {

    @Autowired
    @Qualifier("bus")
    private  Traffic traffic;

    public  void run(){
        try {
            traffic.drive();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
