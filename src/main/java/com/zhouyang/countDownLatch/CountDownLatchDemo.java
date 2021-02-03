package com.zhouyang.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @program: learnning
 * @description: 秦灭六国，一统华夏
 * @author: Lv
 * @create: 2020-12-09 09:47
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        // 计数器
        CountDownLatch countDownLatch = new CountDownLatch(7);

        for (int i = 0; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() + "\t 班长最后关门");
    }
}
