package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class TestUser {

    public static void main(String[] args) {
        //从spring容器获得
        //1 获得容器
        String xmlPath = "/config/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //2获得内容 --不需要自己new，都是从spring容器获得
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.addUser();
    }
}
