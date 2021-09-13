package com.bj.algorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    static int num;
    static int num1;
    public static void main(String[] args) {
        //int[] arr = {9,78,0,-1000,-567,70,10};
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000000);
        }

        //System.out.println("排序前数组:");
        //System.out.println(Arrays.toString(arr));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println("排序前时间:" + dateStr1);

        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);

        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后时间:" + dateStr2);
        System.out.println("排序后数组:");
        System.out.println(Arrays.toString(arr));
        System.out.println(num);
        System.out.println(num1);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        num1++;
        if (left<right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }

    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        num++;
        int t = 0;
        int i = left;
        int j = mid + 1;
        while (j <= right && i <= mid) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
            } else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }

    }
}
