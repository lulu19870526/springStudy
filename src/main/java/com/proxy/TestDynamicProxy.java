package com.proxy;

import com.service.WelcomeService;
import com.service.impl.WelcomeServiceImpl;

public class TestDynamicProxy {

    public static void main(String[] args){
        WelcomeService welcomeService = (WelcomeService)new LogProxy().getProxyObject(new WelcomeServiceImpl());
        welcomeService.welcome();
    }
}
