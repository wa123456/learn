package com.zhouyang.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @program: learnning  同学都走了，班长才关灯
 * @description:
 * @author: Lv  先 countDown 然后 await 最后关灯
 * @create: 2020-12-09 09:47
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        // 计数器
        CountDownLatch countDownLatch = new CountDownLatch(7);

        for (int i = 0; i <= 6; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) { e1.printStackTrace(); }

                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() + "\t 班长最后关门");
    }
}
