package com.bj.Test;

import java.util.concurrent.*;

public class Test03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*FutureTask task01 = new FutureTask<>(new Test02());
        FutureTask task02 = new FutureTask<>(new Test02());
        Thread t1 = new Thread(task01);
        Thread t2 = new Thread(task02);
        t1.setName("jack");
        t2.setName("tom");
        t1.setPriority(1);
        t2.setPriority(1);
        t1.start();
        t2.start();
        try {
            System.out.println(task01.get());
            System.out.println(task02.get());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        }*/
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor
                        (5,10,200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(20));
        Future task;
        for (int i=0;i<5;i++){
            task=executor.submit(new Test02());
            System.out.println(task.get());
        }
        executor.shutdown();
    }
}
