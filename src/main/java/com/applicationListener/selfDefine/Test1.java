package com.applicationListener.selfDefine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        String xmlPath = "/config/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        //创建一个ApplicationEvent对象
        EmailEvent event = new EmailEvent("hello","abc@163.com","This is a test");
        //主动触发该事件
        applicationContext.publishEvent(event);
    }
}
