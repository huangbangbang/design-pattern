package com.bj.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Test30 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println();
        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<Object> list2 = new ArrayList<>();
        System.out.println(list1==list2);


    }
}
