package com.lv.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: learnning
 * @description: 相应中断的锁
 * @author: https://blog.csdn.net/u013851082/article/details/70140223
 * @create: 2020-05-20 10:16
 **/
public class TestLockInterruptibly
{

    // @Test
    public void test3() throws Exception
    {
        final Lock lock = new ReentrantLock();
        lock.lock();

        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    lock.lockInterruptibly();
                }
                catch(InterruptedException e)
                {
                    System.out.println(Thread.currentThread().getName() + " interrupted.");
                }
            }
        }, "child thread -1");

        t1.start();
        Thread.sleep(1000);

        t1.interrupt();

        Thread.sleep(1000000);
    }

    public static void main(String[] args) throws Exception
    {
        new TestLockInterruptibly().test3();
    }
}

