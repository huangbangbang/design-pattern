package com.bj.springframework5Ioc;

public class Course {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "course[" +
                "name='" + name + '\'' +
                ']';
    }
}
