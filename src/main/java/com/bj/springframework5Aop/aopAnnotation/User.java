package com.bj.springframework5Aop.aopAnnotation;

import org.springframework.stereotype.Component;

@Component
public class User {
    public void add(){
        System.out.println("add method");
    }
}
