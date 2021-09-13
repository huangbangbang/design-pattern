package com.bj.Test;

public class Test06 {
    public static void main(String[] args) {
        Test06 test06 = new Test06();
        test06.print();
    }

    public void print() {
        int x = 8;
        class Inner {
            int y = 4;

            void print() {
                int x = 2;
                System.out.println(x);
                //System.out.println(this.x);
                //System.out.println(Test04.this.x);
                System.out.println(y);
            }
        }
        Inner inner = new Inner();
        inner.print();
    }
}
