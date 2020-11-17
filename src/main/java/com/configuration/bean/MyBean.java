package com.configuration.bean;

public class MyBean {

    public MyBean(){
        System.out.println("MyBean Initializing");
    }

    public void init(){
        System.out.println("Bean 初始化方法被调用");
    }

    public void destroy(){
        System.out.println("Bean 销毁方法被调用");
    }
}
