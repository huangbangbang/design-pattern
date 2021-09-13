package com.bj.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Poker {
    public static void main(String[] args) {
        String[] poker = {"3","4","5","6","7","8","9","10","J","Q","K","A","2","king","KING"};
        //新扑克
        Integer[] integers = {0,0,0,0,1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,
                9,9,9,9,10,10,10,10,11,11,11,11,12,12,12,12,13,14};
        //洗牌
        for (int i=integers.length-1;i>=0;i--){
            int random = (int) (Math.random()*i);
            if (random!=i){
                int temp = integers[i];
                integers[i]=integers[random];
                integers[random]= temp;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer i:integers
             ) {
            arrayList.add(i);
        }
        List[] a=new ArrayList[4];
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();
        a[0]=list1;
        a[1]=list2;
        a[2]=list3;
        a[3]=list4;
        while (arrayList.size()>0){
            for (int i=0;i<a.length;i++){
                if (arrayList.size()==0){
                    break;
                }
                a[i].add(arrayList.get(0));
                arrayList.remove(arrayList.get(0));
            }
        }
        for (int i=0;i<a.length;i++){
            Collections.sort(a[i]);
            int count = a[i].size();
            System.out.print("第"+(i+1)+"个人的牌:");
            for (int j=0;j<count;j++){
                System.out.print(poker[(int) a[i].get(0)]+" ");
                a[i].remove(a[i].get(0));
            }
            System.out.println();
        }
    }
}
