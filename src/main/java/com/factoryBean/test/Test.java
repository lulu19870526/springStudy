package com.factoryBean.test;

import noScan.service.FactoryBeanService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        //从spring容器获得
        //1 获得容器
        String xmlPath = "/config/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //2获得内容 --不需要自己new，都是从spring容器获得

        /**
         * 分析总结起来是：我们调用getBean(Class requiredType)方法根据类型来获取容器中的bean的时候，
         * 对应我们的例子就是：根据类型com.zkn.spring.learn.service.FactoryBeanService来
         * 从Spring容器中获取Bean(首先明确的一点是在Spring容器中没有FactoryBeanService类
         * 型的BeanDefinition。但是却有一个Bean和FactoryBeanService这个类型有一些关系)。
         * Spring在根据type去获取Bean的时候，会先获取到beanName。获取beanName的过程是：
         * 先循环Spring容器中的所有的beanName，然后根据beanName获取对应的BeanDefinition，
         * 如果当前bean是FactoryBean的类型，则会从Spring容器中根据beanName获取对应的Bean实例，
         * 接着调用获取到的Bean实例的getObjectType方法获取到Class类型，判断此Class类型和我们传入
         * 的Class是否是同一类型。如果是则返回测beanName，对应到我们这里就是：根据factoryBeanLearn
         * 获取到FactoryBeanLearn实例，调用FactoryBeanLearn的getObjectType方法获取到返回
         * 值FactoryBeanService.class。和我们传入的类型一致，所以这里获取的beanName为
         * factoryBeanLearn。换句话说这里我们把factoryBeanLearn这个beanName映射为了：
         * FactoryBeanService类型。即FactoryBeanService类型对应的beanName为factoryBeanLearn这是
         * 很重要的一点。在这里我们也看到了FactoryBean中三个方法中的一个所发挥作用的地方
         */
        FactoryBeanService factoryBeanService = applicationContext.getBean(FactoryBeanService.class);
        factoryBeanService.testFactoryBean();
    }
}
