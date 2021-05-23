package com.zhouyang.countDownLatch;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *  * 六车三位
 * 初始化一个信号量为3，默认是false 非公平锁， 模拟3个停车位
 * semaphore.acquire release
 * 即，多人抢多个资源问题；
 **/
public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3, false);
        // 模拟6部车
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    // 代表一辆车，已经占用了该车位
                    semaphore.acquire(); // 抢占

                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    // 每个车停3秒
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) { e.printStackTrace(); }

                    System.out.println(Thread.currentThread().getName() + "\t 离开车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放停车位
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
