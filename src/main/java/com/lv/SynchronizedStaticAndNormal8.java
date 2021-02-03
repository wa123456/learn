package com.lv;

/**
 * 第六种情况：同时访问静态synchronized和非静态synchronized方法
 *                                                                                                                                                                                  结果：两个线程几乎同时输出。原因是：静态锁锁住的是Class对象，非静态锁锁的只是实例本身，可以看出他们不是同一个锁，所以可以同时运行
 */
public class SynchronizedStaticAndNormal8 implements Runnable {

    static SynchronizedStaticAndNormal8 instance=new SynchronizedStaticAndNormal8();
    public static void main(String[] args) {
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        while(t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }

    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else if(Thread.currentThread().getName().equals("Thread-1")){
            method2();
        }
    }

    //类锁：方法上加上static
    public static synchronized void method1(){
        System.out.println("我是静态加锁的方法。我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    //对象锁：普通方法锁
    public synchronized void method2(){
        System.out.println("我是非静态加锁的方法。我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

}

