package com.bj.springframework5Ioc.bean;

public class Orders {
    private String name;

    public Orders() {
        System.out.println("first no argument constructor");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("second set method");
    }

    public void init(){
        System.out.println("third init method");
    }

    public void destroy(){
        System.out.println("fifth destroy method");
    }
}
