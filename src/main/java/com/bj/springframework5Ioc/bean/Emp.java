package com.bj.springframework5Ioc.bean;

public class Emp {
    private String name;
    private int age;

    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dept getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dept=" + dept +
                ']';
    }
}
