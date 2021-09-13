package com.bj.Test;

public class Test05 {
    public int age=35;
    public static void main(String[] args) {
        /*Test05 test05 = new Test05();
        Test05.Inner inner1 = test05.new Inner();*/
        Inner inner1 = new Test05().new Inner();
        inner1.name="jack";
        //System.out.println(test05.age);
        System.out.println(inner1.name);
    }
    class Inner{
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
