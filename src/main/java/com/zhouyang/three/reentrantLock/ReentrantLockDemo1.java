package com.zhouyang.three.reentrantLock;

public class ReentrantLockDemo1 {
    Object object = new Object();

    public void sychronizedMethod(){
       new Thread(()->{
           synchronized (object){
               System.out.println(Thread.currentThread().getName()+"\t"+"外层....");
               synchronized (object){
                   System.out.println(Thread.currentThread().getName()+"\t"+"中层....");
                   synchronized (object){
                       System.out.println(Thread.currentThread().getName()+"\t"+"内层....");
                   }
               }
           }
       },"Thread A").start();
    }

    public static void main(String[] args) {
        new ReentrantLockDemo1().sychronizedMethod();
    }
    
}
