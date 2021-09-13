package com.bj.algorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        //int[] array = {3,9,-1,10,20};
        int[] arr = new int[80000];
        for (int i=0;i<arr.length;i++){
            arr[i]= (int) (Math.random()*8000000);
        }

        //System.out.println("排序前数组:");
        //System.out.println(Arrays.toString(arr));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println("排序前时间:"+dateStr1);

        selectSort(arr);

        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后时间:"+dateStr2);
        System.out.println("排序后数组:");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        int min;
        int index;
        for (int i=0;i<arr.length-1;i++){
            min =arr[i];
            index=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<min){
                    min=arr[j];
                    index=j;
                }
            }
            if (index!=i){
                arr[index]=arr[i];
                arr[i]=min;
            }
        }
    }

}
