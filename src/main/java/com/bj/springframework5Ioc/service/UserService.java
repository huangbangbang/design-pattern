package com.bj.springframework5Ioc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Value("abc")
    private String string;
    public  void add(){
        System.out.println(string);
    }
    /*@Autowired
    @Qualifier(value = "userDaoImpl")*//*
    @Resource(name = "userDaoImpl")
    private UserDao userDao;*/

    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
*/
    /*public void add(){
        System.out.println("service add");

        *//*UserDao userDao = new UserDaoImpl();
        userDao.update();*//*
        userDao.update();
    }*/
}
