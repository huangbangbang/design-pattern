package com.bj.Test;

import java.util.ArrayList;


public class Test11 {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        /*Random random = new Random();
        System.out.println(10+random.nextInt(40));
        System.out.println((char) ('a'+(Math.random()*('z'-'a'))));*/
        int[] arr = {2,2,3,4};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            arrayList.add(arr[i]);
        }

        find(arrayList,7,0);

    }

    private static void find(ArrayList<Integer> arrayList, int num,int index) {
        if (num == 0) {
            printf();
            return;
        }
        for (int i=index;i<arrayList.size();i++){
            if (num < arrayList.get(index)) {
                return;
            }
            int a = arrayList.get(i);
            list.add(Integer.valueOf(a));
            //arrayList.remove(arrayList.get(0));
            find(arrayList, num - a,i);
            list.remove(list.size()-1);
        }




    }
    private static void printf() {
        System.out.println(list);
    }
}
