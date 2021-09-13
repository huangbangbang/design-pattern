package com.bj.algorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
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
        int insertValue;
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            insertIndex=i-1;
            while (insertIndex>=0&&insertValue < arr[insertIndex]) {
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }

            if (insertIndex+1!=i){
                arr[insertIndex+1]=insertValue;
            }



        }
    }

}
