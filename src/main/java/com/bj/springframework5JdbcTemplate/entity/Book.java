package com.bj.springframework5JdbcTemplate.entity;

public class Book {
    public Book(int no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    public Book() {
    }

    private int no;
    private String name;
    private int age;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Book[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                ']';
    }
}
