package com.bj.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FibonacciSearch {
    public static int max = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1234,1234};

        ArrayList<Integer> list = fibonacciSearch(arr, 1234);
        if (list != null) {
            Collections.sort(list);
        }
        System.out.println(list);
    }

    private static ArrayList<Integer> fibonacciSearch(int[] arr, int search) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] fib = fib();
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid = 0;
        while (high > fib[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, fib[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + fib[k - 1] - 1;
            if (temp[mid] > search) {
                high = mid - 1;
                k--;
            } else if (temp[mid] < search) {
                low = mid + 1;
                if (k>2){
                    k = k - 2;
                }else {
                    k-=1;
                }
            } else {
                if (mid <= high) {
                    int index = mid - 1;
                    int findVal = arr[mid];
                    while (true) {
                        if (index < low||arr[index] != findVal) {
                            break;
                        }
                        list.add(index--);
                    }
                    list.add(mid);
                    index = mid + 1;
                    while (true) {
                        if (index > high||arr[index] != findVal) {
                            break;
                        }
                        list.add(index++);
                    }
                    return list;
                } else {
                    int index = high - 1;
                    int findVal = arr[mid];
                    while (true) {
                        if (index < low||arr[index] != findVal) {
                            break;
                        }
                        list.add(index--);
                    }
                    list.add(high);
                    return list;
                }
            }

        }
        return null;

    }

    private static int[] fib() {
        int[] fib = new int[max];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < max; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }
}
