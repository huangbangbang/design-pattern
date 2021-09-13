package com.bj.algorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    static int n;

    public static void main(String[] args) {

        //int[] array = {3,9,-1,10,20};
        //System.out.println(Arrays.toString(array));
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        //System.out.println("排序前数组:"+Arrays.toString(arr));
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println("排序前时间:" + dateStr1);
        bubbleSort(arr);
        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后时间:" + dateStr2);

        /*for (int date : arr) {
            System.out.print(date + " ");
        }*/
        System.out.println("排序后数组:"+Arrays.toString(arr));
        System.out.println("一共交换了" + n + "次");
    }

    private static void bubbleSort(int[] array) {
        int temp;
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    n++;
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
