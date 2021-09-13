package com.bj.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class Test12 {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Integer(1));
        list.add(new Integer(1));
        System.out.println(list);
        HashSet hashSet =new HashSet<ArrayList>();
        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<Object> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        hashSet.add(list1);
        hashSet.add(list2);
        System.out.println(hashSet);
        String s1 ="abc";
        String s2 = new String("abc");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(list1.equals(list2));
        System.out.println(list1.hashCode());
        System.out.println(list2.hashCode());
    }
}
