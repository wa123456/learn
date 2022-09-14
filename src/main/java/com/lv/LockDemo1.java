package com.lv;

import java.util.concurrent.atomic.AtomicReference;

public class LockDemo1 {

    public static void main(String[] args) {

    }



    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){
        Thread thread = Thread.currentThread();


        while(! atomicReference.compareAndSet(null,thread)){

        }

    }




    public void unlock(){

        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
    }
}
