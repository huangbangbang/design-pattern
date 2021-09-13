package com.bj.algorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
        //int[] arr = {9,78,0,1000,567,70,10};
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
        radixSort(arr);

        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后时间:" + dateStr2);
        System.out.println("排序后数组:");
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i=0;i<arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        int maxLength=(max+"").length();
        int[][] bucket = new int[10][arr.length];
        int[] count = new int[10];
        for (int i=0, n=1;i<maxLength;i++,n*=10){
            for (int j=0;j<arr.length;j++){
                int digit =arr[j]/n%10;
                bucket[digit][count[digit]]=arr[j];
                count[digit]++;
            }
            int index =0;
            for (int k=0;k<count.length;k++){
                if (count[k]!=0){
                    for (int l=0;l<count[k];l++){
                        arr[index++]=bucket[k][l];
                    }
                }
                count[k]=0;
            }
        }
    }
}
