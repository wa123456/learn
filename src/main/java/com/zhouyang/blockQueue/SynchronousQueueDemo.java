package com.zhouyang.blockQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: learnning
 * @description:SynchronousQueue没有容量，与其他BlockingQueue不同，
 * SynchronousQueue是一个不存储的BlockingQueue，每一个put操作必须等待一个take操作，否者不能继续添加元素
 * @author: Lv
 * @create: 2020-12-10 10:32
 **/
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put A ");
                blockingQueue.put("A");

                System.out.println(Thread.currentThread().getName() + "\t put B ");
                blockingQueue.put("B");

                System.out.println(Thread.currentThread().getName() + "\t put C ");
                blockingQueue.put("C");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();



        new Thread(() -> {
            try {

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take A ");

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take B ");

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take C ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }

    /**
     * 我们从最后的运行结果可以看出，每次t1线程向队列中添加阻塞队列添加元素后，t1输入线程就会等待 t2消费线程，
     * t2消费后，t2处于挂起状态，等待t1在存入，从而周而复始，形成 一存一取的状态
     */

}
