package com.lv.completableFuture;

import java.util.concurrent.*;

public class FutureTaskTest {
    //守护线程和非守护线程的区别是
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("我是子线程(用户线程.I am running");
                } catch (Exception e) {
                }
            }
        });
        //标记为守护线程,setDaemon要在start()方法之前使用
        //t1.setDaemon(true);
        //启动线程
        t1.start();

        Thread.sleep(3000);
        System.out.println("主线程执行完毕...");
    }

}
