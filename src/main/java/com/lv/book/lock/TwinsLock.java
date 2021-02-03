package com.lv.book.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program: learnning
 * @description:共享式访问，共享锁
 * ：该工具在同一时刻，只允许至多两个线程同时访问，超过两个线程的
 * 访问将被阻塞，
 *
 * @author: Lv
 * @create: 2020-06-02 10:08
 **/
public class TwinsLock implements Lock {
    //设置初始状态status为2，当一个线程进行获取，status减1，该
    private final Sync sync = new Sync(2);
    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count) {
            if (count <= 0) {
                throw new IllegalArgumentException("count must largethan zero.");
            }
            setState(count);
        }
        public int tryAcquireShared(int reduceCount) {
            for (;;) {
                int current = getState();
                int newCount = current - reduceCount;
                //在同步状态变更时，需要使用
                //compareAndSet(int expect,int update)方法做原子性保障
                if (newCount < 0 || compareAndSetState(current,
                        newCount)) {
                    return newCount;
                }
            }
        }
        public boolean tryReleaseShared(int returnCount) {
            for (;;) {
                int current = getState();
                int newCount = current + returnCount;
                //在同步状态变更时，需要使用
                //compareAndSet(int expect,int update)方法做原子性保障
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }
    }
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
// 其他接口方法略
}