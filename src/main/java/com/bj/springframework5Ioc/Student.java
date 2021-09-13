package com.bj.springframework5Ioc;

import org.springframework.stereotype.Component;

//默认是类名称 首字母小写
@Component(value = "student")
public class Student {
    public void add(){
        System.out.println("--------------");
    }

    @Override
    public String toString() {
        return "Student[]";
    }
}
