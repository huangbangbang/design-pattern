package com.bj.Test;

public class People implements Cloneable{
    private int no;
    private String name;

    public People(int no, String name) {
        this.no = no;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ']';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
