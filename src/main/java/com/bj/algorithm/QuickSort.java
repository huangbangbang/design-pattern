package com.bj.algorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    static int num;
    public static void main(String[] args) {
        //int[] arr = {9,78,0,-1000,-567,70,10};
        int[] arr = new int[8000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000000);
        }

        //System.out.println("排序前数组:");
        //System.out.println(Arrays.toString(arr));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println("排序前时间:" + dateStr1);

        quickSort(arr,0,arr.length-1);

        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后时间:" + dateStr2);
        System.out.println("排序后数组:");
        System.out.println(Arrays.toString(arr));
        System.out.println(num);
    }

    private static void quickSort(int[] arr, int left, int right) {
        num++;
        int temp;
        int l=left;
        int r=right;
        int pivot=arr[(left+right)/2];
        while (l<r){
            while (arr[l]<pivot){
                l++;
            }
            while (arr[r]>pivot){
                r--;
            }
            if (l>=r){
                break;
            }
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            if (arr[l]==pivot){
                r--;
            }
            if (arr[r]==pivot){
                l++;
            }
            if (l==r){
                l++;
                r--;
            }
            if (left<r){
                quickSort(arr,left,r);
            }
            if (l<right){
                quickSort(arr,l,right);
            }
        }
    }


}
