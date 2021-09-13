package com.bj.Test;

public class Test16 {
    public static void main(String[] args) {
        Season[] season = Season.values();
        for (Season s:season){
            System.out.println(s+": "+s.getMonth());
        }
    }
}

enum Season{
    Spring(1,"一月到三月"),Summer(1,"四月到六月"),
    Autumn(1,"七月到九月"),Winter(1,"十月到十二月");

    private int a;
    private String month;

    Season(int a, String month) {
        this.a = a;
        this.month = month;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
