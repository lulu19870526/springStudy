package com.dao.impl;

import com.dao.PersonDao;
import org.springframework.stereotype.Repository;

//@Repository　　dao层实现类的注解
@Repository
public class PersonDaoImpl implements PersonDao {

    public void addPerson(){
        System.out.println("添加person操作");
    }
}
