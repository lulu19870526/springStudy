package com.beanWireQIYi.service.impl;

import com.beanWireQIYi.service.Traffic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bus")
public class Bus implements Traffic {

    public void drive(){
        System.out.println("公共汽车在行驶");
    }
}
