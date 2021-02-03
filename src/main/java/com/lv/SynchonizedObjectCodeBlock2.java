package com.lv;

/**
 * 情况二：两个线程访问的是两个对象的同步方法
 * 对象锁：同步代码块
 *                                                                                                                                                                                      结果：两个线程几乎同时输出（即不会受干扰，因为他们真正采用的锁对象不是同一个）
 */
public class SynchonizedObjectCodeBlock2 implements Runnable {


    @Override
    public void run() {
        synchronized (this){
            System.out.println("我是对象的代码块形式。我叫"+Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
         SynchonizedObjectCodeBlock2 instance1=new SynchonizedObjectCodeBlock2();
         SynchonizedObjectCodeBlock2 instance2=new SynchonizedObjectCodeBlock2();
        Thread t1=new Thread(instance1);
        Thread t2=new Thread(instance2);
        t1.start();
        t2.start();
        while(t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }
}

