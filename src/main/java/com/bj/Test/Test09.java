package com.bj.Test;

public class Test09 {
    public static void main(String[] args) {
        (
                new Inner(){  //匿名内部类开始
                    public void test(){  //不用public修饰不通过，修饰范围>=接口才能覆盖
                        System.out.println("这是外部类接口中Test方法的实现类~"+name);
                    }
                }
        ).test(); //匿名内部类结束
    }
    interface Inner{
        String name="黄岚岚";
        void test();
    }
}
