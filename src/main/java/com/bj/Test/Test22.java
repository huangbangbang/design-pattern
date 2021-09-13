package com.bj.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class Test22 implements Runnable {
    private static final AtomicInteger nextId = new AtomicInteger(0);
    private static final ThreadLocal<Integer> threadId = new ThreadLocal() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }

    };

    public static void main(String[] args) {
        Test22 test22 = new Test22();
        Thread thread = new Thread(test22);
        Thread thread1 = new Thread(test22);
        System.out.println(get());

    }

    @Override
    public void run() {
        System.out.println("----------------");
    }
    public static int get() {
          return  threadId.get();
      }
}
