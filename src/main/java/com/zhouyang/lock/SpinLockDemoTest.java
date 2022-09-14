package com.zhouyang.lock;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SpinLockDemoTest {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        lock.lock();

        lock.unlock();

    }


    //lock need releaseLock and getLock()
    //lock.lock  lock.unlock

    //write cas lock


    AtomicReference<Thread> threadAtomicReference = new AtomicReference<>();
    public void getLock(){
        Thread thread = Thread.currentThread();

        while (!threadAtomicReference.compareAndSet(null, thread)){

        }
    }


    public void unlock(){
        Thread thread = Thread.currentThread();
        while (!threadAtomicReference.compareAndSet(thread,null)){

        }
    }


}
