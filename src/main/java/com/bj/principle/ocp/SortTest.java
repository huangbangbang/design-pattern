package com.bj.principle.ocp;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] a = {11,5,6,7,8};
        System.out.println(a[0]);
        Arrays.sort(a);
        System.out.println(a[0]);
    }

}
