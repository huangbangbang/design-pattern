package com.bj.springframework5Ioc.Dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void update() {
        System.out.println("Dao Update");
    }
}
