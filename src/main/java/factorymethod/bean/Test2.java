package factorymethod.bean;

import factorymethod.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    public static void main(String[] args) {
        //从spring容器获得
        //1 获得容器
        String xmlPath = "/config/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //2获得内容 --不需要自己new，都是从spring容器获得
        Car car1 = (Car) applicationContext.getBean("car4");
        System.out.println("car1:" + car1.toString());

        Car car2 = (Car) applicationContext.getBean("car6");
        System.out.println("car2:" + car2.toString());
    }
}
