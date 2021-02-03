package com.lv;

/**
 * 情况二：两个线程访问的是两个对象的同步方法
 * 对象锁：同步代码块
 * 结果：两个线程几乎同时输出（即不会受干扰，因为他们真正采用的锁对象不是同一个）
 */
public class SynchonizedObjectCodeBlock implements Runnable {
    static SynchonizedObjectCodeBlock instance1=new SynchonizedObjectCodeBlock();


    Object lock1 = new Object();
    Object lock2 = new Object();

    @Override
    public void run() {
        synchronized (lock1){
            System.out.println("我是lock1对象的代码块形式。我叫"+Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("我是lock1: "+Thread.currentThread().getName()+"运行结束");
        }


        synchronized (lock2){
            System.out.println("我是lock2对象的代码块形式。我叫"+Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("我是lock2: "+Thread.currentThread().getName()+"运行结束");
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(instance1);
        Thread t2=new Thread(instance1);
        t1.start();
        t2.start();
        while(t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }
}

