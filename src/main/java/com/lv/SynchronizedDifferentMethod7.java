package com.lv;

/**
 * 第五种情况：同时访问一个类的不同的普通同步方法
 *                                                                                                                                                                                      结果：第一个线程输出3秒后第二个线程输出
 */
public  class SynchronizedDifferentMethod7 implements Runnable {

    static SynchronizedDifferentMethod7 instance=new SynchronizedDifferentMethod7();

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
        System.out.println("我是第一个加锁的方法。我叫"+Thread.currentThread().getName());  //Thread-0
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public synchronized void method2(){
        System.out.println("我是第二个加锁的方法。我叫"+Thread.currentThread().getName());   //Thread-1
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}
