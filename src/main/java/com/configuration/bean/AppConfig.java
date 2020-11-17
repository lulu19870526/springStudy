package com.configuration.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /**
     * initMethod: 这个可选择的方法在bean实例化的时候调用，InitializationBean接口允许bean在
     * 合适的时机通过设置注解的初始化属性从而调用初始化方法，
     * InitializationBean 接口有一个定义好的初始化方法
     * void afterPropertiesSet() throws Exception;
     * Spring不推荐使用InitializationBean 来调用其初始化方法，因为它不必要地将代码耦合到Spring。
     * Spring推荐使用@PostConstruct注解或者为POJO类指定其初始化方法这两种方式来完成初始化。
     *
     * destroyMethod: 方法的可选择名称在调用bean示例在关闭上下文的时候，例如JDBC的close()方法，
     * 或者SqlSession的close()方法。DisposableBean 接口的实现允许在bean销毁的时候进行回调调用，
     * DisposableBean 接口之后一个单个的方法
     * void destroy() throws Exception;
     * Spring不推荐使用DisposableBean 的方式来初始化其方法，因为它会将不必要的代码耦合到Spring。
     * 作为替代性的建议，Spring 推荐使用@PreDestory注解或者为@Bean注解提供 destroyMethod 属性，
     * @return
     */
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public MyBean myBean(){
        return new MyBean();
    }
}
