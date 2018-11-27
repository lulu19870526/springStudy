package com.service.impl;

import com.service.UserService;
import com.dao.UserDao;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public void addUser(){
        userDao.addUser();
    }
}
