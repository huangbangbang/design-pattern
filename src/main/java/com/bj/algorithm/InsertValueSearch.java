package com.bj.algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class InsertValueSearch {
    static int count;

    public static void main(String[] args) {
        //int[] arr = {1, 4, 8, 15, 20, 28, 33, 39, 45, 54, 63, 77, 88, 95, 100};
        int[] arr = new int[100];
        for (int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }
        arr[77]=77;
        arr[78]=77;
        arr[75]=77;
        arr[74]=77;
        arr[73]=77;
        ArrayList<Integer> list = insertValueSearch(arr, 0, arr.length - 1, -1);
        if (list!=null){
            Collections.sort(list);
        }
        System.out.println(list);
        System.out.println(count);
    }

    private static ArrayList<Integer> insertValueSearch(int[] arr, int left, int right, int search) {
        count++;
        int mid = left +   (right - left)*(search - arr[left]) / (arr[right] - arr[left]);
        if (left > right || search < arr[0] || search > arr[arr.length - 1]) {
            return null;
        }
        if (arr[mid] < search) {
            return insertValueSearch(arr, mid + 1, right, search);
        } else if (arr[mid] > search) {
            return insertValueSearch(arr, left, mid, search);
        } else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int index = mid - 1;
            while (true) {
                if (index < left || arr[index] != arr[mid]) {
                    break;
                }
                list.add(index);
                index--;
            }
            list.add(mid);
            index = mid + 1;
            while (true) {
                if (index > right || arr[index] != arr[mid]) {
                    break;
                }
                list.add(index);
                index++;
            }
            return list;
        }
    }

}