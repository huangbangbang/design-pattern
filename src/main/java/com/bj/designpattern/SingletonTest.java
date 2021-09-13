package com.bj.designpattern;

import java.util.HashMap;

public class SingletonTest {
    public static void main(String[] args) {
        /*Singleton1 instance = Singleton1.getInstance();
        Singleton1 instance1 = Singleton1.getInstance();
        System.out.println(instance==instance1);
        System.out.println(instance.equals(instance1));*/

        /*Singleton2 instance = Singleton2.getInstance();
        Singleton2 instance1 = Singleton2.getInstance();
        System.out.println(instance==instance1);
        System.out.println(instance.equals(instance1));*/

        /*Singleton3 instance = Singleton3.getInstance();
        Singleton3 instance1 = Singleton3.getInstance();
        System.out.println(instance==instance1);
        System.out.println(instance.equals(instance1));*/

        /*Singleton4 instance = Singleton4.getInstance();
        Singleton4 instance1 = Singleton4.getInstance();
        System.out.println(instance==instance1);
        System.out.println(instance.equals(instance1));*/

        /*Singleton5 instance = Singleton5.getInstance();
        Singleton5 instance1 = Singleton5.getInstance();
        System.out.println(instance==instance1);
        System.out.println(instance.equals(instance1));*/

        /*Singleton6 instance = Singleton6.getInstance();
        Singleton6 instance1 = Singleton6.getInstance();
        System.out.println(instance==instance1);
        System.out.println(instance.equals(instance1));*/

        /*Singleton7 singleton = Singleton7.SINGLETON7;
        Singleton7 singleton1 = Singleton7.SINGLETON7;
        System.out.println(singleton==singleton1);
        System.out.println(singleton.equals(singleton1));*/

        /*Singleton6 singleton6 = Singleton7.SINGLETON7.get();
        Singleton6 singleton61 = Singleton7.SINGLETON7.get();
        System.out.println(singleton6==singleton61);
        System.out.println(singleton6.equals(singleton61));*/

        Singleton8.putSingleton("Singleton1", Singleton1.getInstance());
        Singleton8.putSingleton("Singleton2", Singleton2.getInstance());
        Singleton8.putSingleton("Singleton3", Singleton3.getInstance());
        Singleton8.putSingleton("Singleton4", Singleton4.getInstance());
        Singleton8.putSingleton("Singleton5", Singleton5.getInstance());
        Singleton8.putSingleton("Singleton6", Singleton6.getInstance());
        Singleton8.putSingleton("Singleton7", Singleton7.SINGLETON7);

        Singleton3 singleton3 = (Singleton3) Singleton8.getInstance("Singleton3");
        Singleton3 singleton31 = (Singleton3) Singleton8.getInstance("Singleton3");
        System.out.println(singleton3==singleton31);
        System.out.println(singleton3.equals(singleton31));


    }
}

class Singleton1{
    private static Singleton1 singleton1 = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance(){
        return singleton1;
    }
}

class Singleton2{
    private static Singleton2 singleton2 ;

    static {
        singleton2=new Singleton2();
    }
    private Singleton2() {
    }

    public static Singleton2 getInstance(){
        return singleton2;
    }
}

class Singleton3{
    private static Singleton3 singleton3 ;


    private Singleton3() {
    }

    public static Singleton3 getInstance(){
        if (singleton3==null){
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}

class Singleton4{
    private static Singleton4 singleton4 ;


    private Singleton4() {
    }

    public synchronized static Singleton4 getInstance(){
        if (singleton4==null){
            singleton4 = new Singleton4();
        }
        return singleton4;
    }
}

class Singleton5{
    private static volatile Singleton5 singleton5;


    private Singleton5() {
    }

    public  static Singleton5 getInstance(){
        if (singleton5==null){
            synchronized (Singleton5.class){
                if (singleton5==null){
                    singleton5 = new Singleton5();
                }
            }

        }
        return singleton5;
    }
}

class Singleton6{
    private static class InnerClass{
        private static Singleton6 singleton6= new Singleton6();
    }

    private Singleton6() {
    }

    public  static Singleton6 getInstance(){
        return InnerClass.singleton6;
    }
}

enum Singleton7{
    SINGLETON7;

    public Singleton6 get(){
       return Singleton6.getInstance();
    }
}

class Singleton8{
    private static HashMap<String,Object> hashMap = new HashMap<String,Object>();

    private Singleton8() {
    }

    public static void putSingleton(String key,Object instance){
        if (key.length()>0&&instance!=null){
            if (!hashMap.containsKey(key)){
                hashMap.put(key,instance);
            }
        }
    }

    public  static  Object getInstance(String key){
        return hashMap.get(key);
    }
}
