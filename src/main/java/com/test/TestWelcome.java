package com.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.service.WelcomeService;

public class TestWelcome {

    /**
     * 获得WelcomeService实现类的实例
     * 之前开发中，直接new一个对象即可。
     * 学习spring之后，将由Spring创建对象实例–> IoC 控制反转（Inverse of Control）
     * 之后需要实例对象时，从spring工厂（容器）中获得，需要将实现类的全限定名称配置到xml文件中
     * @param args
     */
   public static void main(String[] args){
       //从spring容器获得
       //1 获得容器
       String xmlPath = "/config/applicationContext.xml";
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
       //2获得内容 --不需要自己new，都是从spring容器获得
       WelcomeService welcomeService = (WelcomeService) applicationContext.getBean("welcomeService");
       welcomeService.welcome();

   }
}
