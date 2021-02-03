package com.zhouyang.produceConsumer;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-12-10 11:09
 **/
public class ProdConsumerBlockingQueueDemo {
    public static void main(String[] args) {
        // 传入具体的实现类， ArrayBlockingQueue
        //MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(10));
        MyResource myResource = new MyResource(new SynchronousQueue<String>());

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            System.out.println("");
            System.out.println("");
            try {
                myResource.myProd();
                System.out.println("");
                System.out.println("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod").start();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");

            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        // 5秒后，停止生产和消费
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("");
        System.out.println("");
        System.out.println("5秒中后，生产和消费线程停止，线程结束");
        myResource.stop();
    }
}
