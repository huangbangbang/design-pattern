package com.bj.Test;

import java.util.Random;

public class OuterClass {

    public int a;
    public  void add1(){};
    public static long OUTER_DATE = System.currentTimeMillis();
    public OuterClass() {
        timeElapsed();
        System.out.println("外部类构造方法时间：" + System.currentTimeMillis());
        for (int i = 0; i < 10000000; i++) {
            int a = new Random(100).nextInt(), b = new Random(100).nextInt();
            a = a + b;
        }
    }

    {
        for (int i = 0; i < 10000000; i++) {
            int a = new Random(100).nextInt(), b = new Random(100).nextInt();
            a = a + b;
        }
        System.out.println("外部类 代码块加载时间：" + System.currentTimeMillis());
        for (int i = 0; i < 10000000; i++) {
            int a = new Random(100).nextInt(), b = new Random(100).nextInt();
            a = a + b;
        }
    }

    static {
        for (int i = 0; i < 10000000; i++) {
            int a = new Random(100).nextInt(), b = new Random(100).nextInt();
            a = a + b;
        }
        System.out.println("外部类 静态代码块加载时间：" + System.currentTimeMillis());
        for (int i = 0; i < 10000000; i++) {
            int a = new Random(100).nextInt(), b = new Random(100).nextInt();
            a = a + b;
        }
    }
    public static void staticMethod(){
        System.out.println("外部类静态方法加载时间：" + System.currentTimeMillis());
        System.out.println("外部类静态变量加载时间：" + OUTER_DATE);
    }

    static class InnerStaticClass {
        public static long INNER_STATIC_DATE = System.currentTimeMillis();
        public static void staticInnerClassMethod(){
            System.out.println("静态内部类 静态方法加载时间：" + System.currentTimeMillis());
            System.out.println("静态内部类 静态变量加载时间：" + INNER_STATIC_DATE);
        }
        public InnerStaticClass(){
            for (int i = 0; i < 10000000; i++) {
                int a = new Random(100).nextInt(), b = new Random(100).nextInt();
                a = a + b;
            }
            System.out.println("静态内部类构造方法时间：" + System.currentTimeMillis());
            for (int i = 0; i < 10000000; i++) {
                int a = new Random(100).nextInt(), b = new Random(100).nextInt();
                a = a + b;
            }
        }

        static {
            for (int i = 0; i < 10000000; i++) {
            int a = new Random(100).nextInt(), b = new Random(100).nextInt();
            a = a + b;
            }
            System.out.println("静态内部类 静态代码块加载时间：" + System.currentTimeMillis());
            for (int i = 0; i < 10000000; i++) {
                int a = new Random(100).nextInt(), b = new Random(100).nextInt();
                a = a + b;
            }
        }


        {
            for (int i = 0; i < 10000000; i++) {
                int a = new Random(100).nextInt(), b = new Random(100).nextInt();
                a = a + b;
            }
            System.out.println("静态内部类 代码块加载时间：" + System.currentTimeMillis());
            for (int i = 0; i < 10000000; i++) {
            int a = new Random(100).nextInt(), b = new Random(100).nextInt();
            a = a + b;
        }
        }
    }

    class InnerClass {

        public  void add(){
            add1();
        }

        public InnerClass() {
            for (int i = 0; i < 10000000; i++) {
                int a = new Random(100).nextInt(), b = new Random(100).nextInt();
                a = a + b;
            }
            System.out.println("非静态内部类 构造方法时间：" + System.currentTimeMillis());
            for (int i = 0; i < 10000000; i++) {
                int a = new Random(100).nextInt(), b = new Random(100).nextInt();
                a = a + b;
            }
            timeElapsed();
        }
        {
            for (int i = 0; i < 10000000; i++) {
                int a = new Random(100).nextInt(), b = new Random(100).nextInt();
                a = a + b;
            }
            System.out.println("非静态内部类 代码块加载时间：" + System.currentTimeMillis());
            for (int i = 0; i < 10000000; i++) {
                int a = new Random(100).nextInt(), b = new Random(100).nextInt();
                a = a + b;
            }
        }
        public  long INNER_DATE =System.currentTimeMillis();
    }

    public static void main(String[] args) {
        //staticMethod();
        System.out.println();
        //OuterClass outer = new OuterClass();
        //InnerStaticClass innerStaticClass = new InnerStaticClass();
        //System.out.println("静态内部类 静态变量加载时间：" + InnerStaticClass.INNER_STATIC_DATE);
        //System.out.println("外部类 静态变量加载时间：" + OUTER_DATE);
        //System.out.println("外部类 静态方法加载时间：" + outer);
        //System.out.println("静态内部类 静态变量加载时间：" + InnerStaticClass.INNER_STATIC_DATE);
        //OuterClass.InnerStaticClass.staticInnerClassMethod();
        //System.out.println("外部类 静态变量加载时间：" + OUTER_DATE);
        //System.out.println("外部类 静态变量加载时间：" + OUTER_DATE);
        System.out.println("非静态内部类 变量加载时间：" + new OuterClass().new InnerClass().INNER_DATE);
        //System.out.println("外部类 静态变量加载时间：" + OUTER_DATE);
    }

    //单纯的为了耗时，来扩大时间差异
    private void timeElapsed() {
        for (int i = 0; i < 10000000; i++) {
            int a = new Random(100).nextInt(), b = new Random(100).nextInt();
            a = a + b;
        }
    }
}

