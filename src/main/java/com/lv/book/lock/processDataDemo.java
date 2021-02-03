package com.lv.book.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: learnning
 * @description: 锁降级例子
 * @author: Lv
 * @create: 2020-06-02 14:26
 **/
public class processDataDemo {
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock readLock = rwl.readLock();
    static Lock writeLock = rwl.writeLock();
    static volatile boolean  update = false;

    public void processData() {

        readLock.lock();
        if (!update) {
        // 必须先释放读锁
            readLock.unlock();
            // 锁降级从写锁获取到开始
            writeLock.lock();
            try {
                if (!update) {
                // 准备数据的流程（略）
                    update = true;
                }
                readLock.lock();
            } finally {
                writeLock.unlock();
            }
            // 锁降级完成，写锁降级为读锁
        }
        try {
        // 使用数据的流程（略）
        } finally {
            readLock.unlock();
        }
    }
    /**
     * 保证数据的可见性可以这样理解：假设线程A修改了数据，释放了写锁，
     * 这个时候线程T获得了写锁，修改了数据，然后也释放了写锁，线程A读取数据的时候，
     * 读到的是线程T修改的，并不是线程A自己修改的，那么在使用修改后的数据时，
     * 就会忽略线程A之前的修改结果。书上说的【当前线程无法感知线程T的数据更新】，
     * 是说线程A使用数据时，并不知道别的线程已经更改了数据，所以使用的是线程T的修改结果。
     * 因此通过锁降级来保证数据每次修改后的可见性。
     */
}
