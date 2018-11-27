package service.impl;

import dao.UserDao;
import service.UserService;

public class UserServiceImpl1 implements UserService {

    private UserDao userDao;

    public UserServiceImpl1(UserDao userDao){
        System.out.println("UserServiceImpl1执行构造方法");
        this.userDao = userDao;
    }

    public void addUser(){
        System.out.println("UserServiceImpl1 addUser将要执行添加用户操作");
        userDao.addUser();
    }

}
