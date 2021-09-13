package com.bj.Test;

public class Test07 {
    String name ="jack";
    void test(){
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
    }
    public static void main(String[] args) {
        /*(new Test07(){
            void setName(String n){
                name=n;
                System.out.println(name);
            }
            void test(){
                System.out.println("----------------------------");
            }
        }).test();*/

        (new Inner(){
            void setName(String n){
                name=n;
                System.out.println(name);
            }
            void test(){
                System.out.println("----------------------------");
            }
        }).setName("tom");
    }
    static class Inner{
        String name="mary";
    }
}
