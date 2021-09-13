package com.bj.Test;

import java.lang.reflect.Array;

public class Test18 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,10};
        /*int b = 0;
        System.out.println(a.getClass());
        System.out.println(Integer.class);*/
        Object o = Array.newInstance(int[].class.getComponentType(), 100);
        Object o1 = Array.newInstance(int[].class.getComponentType(), 1, 2);
        System.arraycopy(a,0,o,0,10);
        System.arraycopy(a,0,o1,0,2);
        for (int b:(int[]) o){
            System.out.print(b+" ");
        }
        System.out.println("----------------------------------");
        for (int b:(int[]) o1){
            System.out.print(b+" ");
        }
    }
}
