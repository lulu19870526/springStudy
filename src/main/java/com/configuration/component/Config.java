package com.configuration.component;

import com.configuration.Car;
import com.configuration.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * 虽然Component注解也会当做配置类，但是并不会为其生成CGLIB代理Class，
 * 所以在生成Driver对象时和生成Car对象时调用car()方法执行了两次new操作，所以是不同的对象。
 *
 * 当是Configuration注解时，生成当前对象的子类Class，并对方法拦截，
 * 第二次调用car()方法时直接从BeanFactory之中获取对象，所以得到的是同一个对象。
 */
@Component
public class Config {

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
