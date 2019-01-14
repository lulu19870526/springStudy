package com.factoryBean;

import noScan.service.FactoryBeanService;
import noScan.service.impl.FactoryBeanServiceImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

//FactoryBean接口的实现类

/**
 *  Spring中有两种类型的Bean，一种是普通Bean，另一种是工厂Bean，即FactoryBean。
 *  工厂Bean跟普通Bean不同，其返回的对象不是指定类的一个实例，
 *  其返回的是该工厂Bean的getObject方法所返回的对象。
 */
@Component
public class FactoryBeanLearn implements FactoryBean {

    public Object getObject() throws Exception {
        //这个Bean是我们自己new的，这里我们就可以控制Bean的创建过程了
        return new FactoryBeanServiceImpl();
    }

    public Class<?> getObjectType() {
        return FactoryBeanService.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
