package com.lv.book.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class CountDownLatchTest3 {
    public static void main(String[] args)   {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {

            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + "尝试进入停车场...");
                    //尝试获取许可
                    semaphore.acquire();
                    long time = (long) (Math.random() * 10000 + 1);
                    System.out.println(Thread.currentThread().getName() + "进入了停车场，停车" );
                    Thread.sleep(time);
                    System.out.println(Thread.currentThread().getName() + "\t，停了" + time +
                            "秒...");



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放许可
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "离开了停车场！");

                }


            },String.valueOf(i)+"号汽车").start();

        }





    }
}
