package com.bj.Test;

public class Test10 {
    String name = "jack";
    void Aa(){
        System.out.println("aaaaaa"+name);
    }

    public static void main(String[] args) {
        (new Test10(){
            void Aa(){
                System.out.println("bbbbbb"+name);
            }
        }).Aa();

        (new Inner(){
            public void test(){
                System.out.println("cccccccccccccc"+name);
            }
        }).test();
    }

    interface Inner{
        String name = "mary";
        void test();
    }
}
