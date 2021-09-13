package com.bj.principle.ocp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Test1 {

    public static void main(String[] args) {
        /*int[] a = new  int[20];
        for (int i =0;i<20;i++){
            a[i] =  (int)(1+Math.random()*20);
            System.out.println(a[i]);
        }

        int b=(int)(1+Math.random()*99);
        System.out.println(b);
*/
        int[] a={2,2,3,4};
        int b=7;
        System.out.println(find(a,b));
    }

    private static HashSet<ArrayList<Integer>> find(int[] a, int i) {

        HashSet<ArrayList<Integer>> str = new HashSet<>();

        if (a==null||a.length==0){
            return str;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(a);
        Integer index = 0;
        find(str,list,a,i,index);
        return  str;
    }

    private static void find(HashSet<ArrayList<Integer>> str, ArrayList<Integer> list, int[] a, int i, Integer index) {
        if (i==0){
            str.add(new ArrayList<>(list));
            return;
        }

        for (int j=index;j<a.length;j++){
            if (i<a[j]){
                return;
            }
            list.add(a[j]);
            find(str,list,a,i-a[j],j);
            list.remove(list.size()-1);

        }
    }



}
