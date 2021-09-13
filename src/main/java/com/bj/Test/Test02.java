package com.bj.Test;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class Test02  implements Callable {
    int[] nums = new int[]{1,2,3,4,5};
    /*@Override
    public void run() {
        for (int a: nums
             ) {
            System.out.println(Thread.currentThread().getName()+"-->"+a);
        }
    }*/

    @Override
    public String call() throws Exception {
        for (int a: nums
        ) {
            System.out.println(Thread.currentThread().getName()+"-->"+a);
        }
        return Arrays.toString(nums);
    }
}
