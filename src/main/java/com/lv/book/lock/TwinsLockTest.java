package com.lv.book.lock;

import com.lv.book.SleepUtils;
import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * @program: learnning
 * @description: 测试共享锁
 *
 * 运行该测试用例，可以看到线程名称成对输出，也就是在同一时刻只有两个线程能够获
 * 取到锁，这表明TwinsLock可以按照预期正确工作。
 *
 * @author: Lv
 * @create: 2020-06-02 10:15
 **/
public class TwinsLockTest {
    @Test
    public void test() {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        // 启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            //守护线程--也称“服务线程”，
            /**
            example: 垃圾回收线程就是一个经典的守护线程，
             当我们的程序中不再有任何运行的Thread,程序就不会再产生垃圾，
             垃圾回收器也就无事可做，所以当垃圾回收线程是JVM上仅剩的线程时，垃圾回收线程会自动离开。
             它始终在低级别的状态中运行，用于实时监控和管理系统中的可回收资源。

             当java虚拟机中没有非守护线程在运行的时候，java虚拟机会关闭。当所有常规线程运行完毕以后，
             守护线程不管运行到哪里，虚拟机都会退出运行。所以你的守护线程最好不要写一些会影响程序的业务逻辑。
             否则无法预料程序到底 会出现什么问题。
             **/
            w.setDaemon(true);
            w.start();
        }
        // 每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
