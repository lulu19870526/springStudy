package com.test.xmlBeanFactory;

import com.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class TestUser {

    public static void main(String[] args) {
        //从spring容器获得
        //1 获得容器
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:/config/applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(res);
        //2获得内容 --不需要自己new，都是从spring容器获得
        UserService userService = (UserService) factory.getBean("userService");
        userService.addUser();
    }
}
