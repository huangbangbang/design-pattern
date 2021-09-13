package com.bj.springframework5Ioc;

public class User {

    private String name;

    /*public User(String name) {
        this.name = name;
    }*/

    public void setName(String name) {
        this.name = name;
    }

    public void add(){
        System.out.println("-----------------");
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ']';
    }
}
