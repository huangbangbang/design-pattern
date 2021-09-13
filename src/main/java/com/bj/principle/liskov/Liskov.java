package com.bj.principle.liskov;
//里氏替换原则
public class Liskov {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.function1(1,3));
        B b = new B();
        System.out.println(b.function1(1,4));//失误（无意识）重写了父类方法
        System.out.println(b.function2(1,4));
    }
}

class A{
    public int function1(int num1,int num2){
        return num1-num2;
    }
}

class B extends A {
    public int function1(int num1,int num2){
        return num1+num2;
    }

    public int function2(int num1,int num2){
        return num1+num2+9;
    }
}