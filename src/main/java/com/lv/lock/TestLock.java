package com.lv.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: learnning
 * @description: 中断锁
 * @author: Lv
 * @create: 2020-05-20 10:11
 **/
public class TestLock
{
    // @Test
    public void test() throws Exception
    {
        final Lock lock = new ReentrantLock();
        lock.lock();


        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        },"child thread -1");

        t1.start();
        Thread.sleep(1000);

        t1.interrupt();

        Thread.sleep(10000);
    }

    public static void main(String[] args) throws Exception
    {
        new TestLock().test();
    }


}
