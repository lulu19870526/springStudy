package com.applicationListener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 * ApplicationContext事件机制是观察者设计模式的实现，通过ApplicationEvent类和ApplicationListener
 * 接口，可以实现ApplicationContext事件处理。
 *
 *  如果容器中有一个ApplicationListener Bean，每当ApplicationContext发布ApplicationEvent时，
 * ApplicationListener Bean将自动被触发。这种事件机制都必须需要程序显示的触发。
 *
 * 其中spring有一些内置的事件，当完成某种操作时会发出某些事件动作。比如监听ContextRefreshedEvent
 * 事件，当所有的bean都初始化完成并被成功装载后会触发该事件，
 * 实现ApplicationListener<ContextRefreshedEvent>接口可以收到监听动作，然后可以写自己的逻辑。
 *
 * 同样事件可以自定义、监听也可以自定义，完全根据自己的业务逻辑来处理。
 */
@Component
public class TestApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println(contextRefreshedEvent);
        System.out.println("TestApplicationListener............................");
    }

}
