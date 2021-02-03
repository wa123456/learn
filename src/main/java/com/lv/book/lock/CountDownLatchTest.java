package com.lv.book.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-06-05 09:50
 **/
public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(0);
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println("3");
    }
}
