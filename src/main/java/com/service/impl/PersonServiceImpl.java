package com.service.impl;

import com.service.PersonService;
import com.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 对于Bean的创建spring容器提供了以下四个注解的支持：
 * 1、@Component
 * 2、@Repository　　dao层实现类的注解
 * 3、@Service　　　　service层实现类的注解
 * 4、@Controller　　  controller层实现类的注解
 *   以上四个注解在普通使用中是等效的，但在web项目中为了区分三层架构中不同层之间Bean的创建，
 *   为了避免注解使用的混乱，使用后三个注解进行区分
 */

//@Service　　　　service层实现类的注解
@Service(value="personServiceImpl")
public class PersonServiceImpl implements PersonService {

    /**
     * @Autowired---自动装配，此注解实现的自动装配是按照类实现注入，
     * 如果出现同名的类，那么此注解方式就不能识别是哪个类实现注入，
     * 此时会出现异常；如果为了避免出现异常，可以采用@Qualifier(value="es")(熟悉)实现辅助，
     * 即Qualifier可以指明对象id
     */
    @Autowired
    private PersonDao personDao;


    public void addPerson(){
        personDao.addPerson();
    }
}
