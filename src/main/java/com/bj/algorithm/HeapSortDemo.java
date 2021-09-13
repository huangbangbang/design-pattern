package com.bj.algorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSortDemo {
    public static void main(String[] args) {

        int[] arr = {22,20,21,18,19,8,11,2,1,4,3,5,7,6,9};
        /*int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000000);
        }*/
        //System.out.println("排序前数组:");
        //System.out.println(Arrays.toString(arr));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println("排序前时间:" + dateStr1);

        int[] temp = new int[arr.length];
        heapSort(arr);

        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后时间:" + dateStr2);
        System.out.println("排序后数组:");
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {

        int temp;
        for (int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        for (int j=arr.length-1;j>0;j--){
            temp=arr[0];
            arr[0]=arr[j];
            arr[j]=temp;
            adjustHeap(arr,0,j);
        }

    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k =i*2+1;k<length;k=k*2+1){
            if (k + 1 < length && arr[k]<arr[k+1]){
                k++;
            }
            if (temp<arr[k]){
                arr[i]=arr[k];
                i=k;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }
}

