package com.lv;

/**
 * 第四种情况：同时访问同步方法和非同步方法
 *                                                                                                                                                                                      结果：两个线程几乎同时输出。原因是：synchronized只作用于指定的方法上
 */
public class SynchronizedYesAndNo6 implements Runnable {
    static SynchronizedYesAndNo6 instance=new SynchronizedYesAndNo6();
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

    public synchronized void method1(){
        System.out.println("我是加锁的方法。我叫"+Thread.currentThread().getName());  //Thread-0
        try{
            //等待3秒
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public void method2(){
        System.out.println("我是没加锁的方法。我叫"+Thread.currentThread().getName());   //Thread-1
        try{
            //等待3秒
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}

