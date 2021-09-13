package com.bj.Test;

import java.lang.reflect.Array;

public class Test17 {
    public static void main(String[] args) {
        /*HashMap<String, String> map = new HashMap<>();
        map.put("k1","jack");
        map.put("k2","tom");
        map.put("k3","mary");
        map.put("k4","bob");
        //map.entrySet().forEach(s-> System.out.println(s));
        for (String s:map.keySet()
             ) {
            System.out.println(s);
        }
        map.values().forEach(s -> System.out.println(s));*/
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] s ={};
        System.out.println(arr.getClass());
        Array.set(arr,1,100);
        int a =  Array.getInt(arr,6);
        System.out.println(Array.get(arr,6));
        for (int b:arr){
            System.out.print(b+" ");
        }
    }
}
