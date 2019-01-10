package com.beanWireQIYi.service.impl;

import com.beanWireQIYi.service.Traffic;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * spring自动装配bean时,有可能会遇到这样的情况,有多个bean符合条件,那么spring就会抛出异常
 *
 * spring提供的第一种解决方案就是首选bean,在声明bean的时候,可以将其中一个bean设置为首选(primary),
 * 当spring遇到歧义性的时候,会使用首选bean,但是我们要注意,如果申明了多个首选bean,
 * 那么spring还是无法从多个首选bean中做出选择,所以也会抛出异常.
 * 在Java配置中,我们可以使用注解@Primary来声明该bean为首选bean
 *
 * spring还提供了一种限定符的方案,限定符主要是使用注解@Qualifier来完成
 */
@Component
//@Primary
public class Car implements Traffic {

    public void drive(){
        System.out.println("小汽车在行驶");
    }
}
