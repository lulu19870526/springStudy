package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 在获取到所有的bean defenition之后，Spring会有一些post process执行，
 * 其中一个就是ConfigurationClassPostProcessor， 在这里，Spring会遍历所有的bean definition，
 * 如果发现其中有标记了@Configuration注解的，会对这个类进行CGLIB代码，生成一个代理的类，
 * 并且把这个类设置到BeanDefenition的Class属性中。当需要拿到这个bean的实例的时候，
 * 会从这个class属性中拿到的Class对象进行反射，那么最终反射出来的是代理增强后的类。
 *
 * 代理中对方法进行了增强？在哪方面进行了增强？对于@Bean标记的方法，返回的都是一个bean，
 * 在增强的方法中，Spring会先去容器中查看一下是否有这个bean的实例了，
 * 如果有了的话，就返回已有对象，没有的话就创建一个，然后放到容器中。
 */
//@Configuration
public class MyTestConfig {

    @Bean
    public Driver driver(){
        Driver driver = new Driver();
        driver.setId(1);
        driver.setName("driver");
        driver.setCar(car());
        return driver;
    }

    @Bean
    public Car car(){
        Car car = new Car();
        car.setId(1);
        car.setName("car");
        return car;
    }
}
