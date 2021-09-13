package com.bj.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test24 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (5, 20, 200, TimeUnit.MILLISECONDS,
                        new ArrayBlockingQueue<>(5));
        for (int i = 0; i < 40; i++) {
            executor.execute(new Task());
            System.out.println("线程池线程数:"+executor.getPoolSize()+
                    "  队列尺寸:"+executor.getQueue().size()+"  线程池完成的线程数:"+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }


}

class Task implements Runnable {

    @Override
    public void run() {
        /*try {
            Thread.currentThread().sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("---------");
    }
}