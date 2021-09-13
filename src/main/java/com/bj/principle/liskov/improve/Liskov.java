package com.bj.principle.liskov.improve;
//里氏替换原则
public class Liskov {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.function1(11,3));
        B b = new B();
        System.out.println(b.function1(11,3));//失误（无意识）重写了父类方法
        System.out.println(b.function2(11,3));
        System.out.println(b.function3(11,3));
    }
}

class Base{

}

class A extends Base {
    public int function1(int num1,int num2){
        return num1-num2;
    }
}

class B extends Base {

    private A a = new A();//组合关系
    public int function1(int num1,int num2){
        return num1+num2;
    }

    public int function2(int num1,int num2){
        return num1+num2+9;
    }

    public int function3(int num1,int num2){
        return this.a.function1(num1,num2);
    }
}