package com.bj.principle.ocp;

public class Student implements Cloneable{
    private Integer id;
    private String name;
    private Integer age;

    public Student() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ']';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
