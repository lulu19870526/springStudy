package com.beanWireQIYi.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args){
        //从spring容器获得
        //1 获得容器
        String xmlPath = "/config/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //2获得内容 --不需要自己new，都是从spring容器获得
        Persion persion = (Persion)applicationContext.getBean("persion");
        persion.run();

    }
}
