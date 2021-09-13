package com.bj.Test;

public class Test04 {
    public int age=35;
    public static void main(String[] args) {
        Test04 test04 = new Test04();
        Inner inner = new Inner();
        System.out.println(test04.age);
    }
    static class Inner{
        public int no;
        public  String name;

        public Inner() {
        }

        public Inner(int no, String name) {
            this.no = no;
            this.name = name;
        }
    }
}
