package com.bj.algorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        //int[] array = {3,9,-1,10,20};
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        //System.out.println("排序前数组:");
        //System.out.println(Arrays.toString(arr));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println("排序前时间:" + dateStr1);

        insertSort(arr);

        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后时间:" + dateStr2);
        System.out.println("排序后数组:");
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        int temp;
        for (int gap = arr.length/2;gap>0;gap/=2){
            for (int i=gap;i<arr.length;i++){
                for (int j = i-gap;j>0;j-=gap){
                    if (arr[j]<arr[j+gap]){
                            temp = arr[j+gap];
                            arr[j+gap]=arr[j];
                            arr[j]=temp;
                    }
                }
            }
        }
    }
}

