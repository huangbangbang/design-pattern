package com.bj.springframework5Transaction.entity;

public class Account {
    private int no;
    private String name;
    private int money;

    public Account(int no, String name, int money) {
        this.no = no;
        this.name = name;
        this.money = money;
    }

    public Account() {
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", money=" + money +
                ']';
    }
}
