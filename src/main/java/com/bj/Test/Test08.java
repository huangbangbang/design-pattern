package com.bj.Test;

public class Test08 {
    public static void main(String[] args) {

        Inner inner=new Inner(){
            void test () {
                System.out.println("这是匿名内部类，运行看会发生什么");
            }
            void haha(){   //如果父类中没有定义该方法，就不能通过父类对象来访问子类特有的方法
                System.out.println("hahahahahahahhahahahahah~");
            }
        };
        inner.test();
    }
    static class Inner{  //mian方法是static的，这里不加static会出错
        String name="黄岚岚";
        void test(){
            System.out.println("这是静态内部类");
        }
//        void haha(){
//            System.out.println("hahahahahahahhahahahahah~");
//        }
    }
}
