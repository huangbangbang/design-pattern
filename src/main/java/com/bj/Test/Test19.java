package com.bj.Test;

public class Test19 {
    public static void main(String[] args) {
        Month month1 = Month.MAY;
        Month month2 = Month.OCTOBER;
        System.out.println(month1.s);
    }


}

enum  Month{
MAY(5,"五月"),OCTOBER(10,"十月"),JANUARY(1,"一月");

int i;
String s;

    Month(int i,String s) {
        this.i=i;
        this.s=s;
    }
}
