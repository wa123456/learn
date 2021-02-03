package com.lv;

/**
 * 第三种情况：两个线程访问的是同一个静态方法
 * 类锁：加在static方法上
 *                                                                                                                                                                                      结果：线程一输出3秒后输出线程二
 */
public class SynchronizedClassStatic4 implements Runnable{

    static SynchronizedClassStatic4 instance1=new SynchronizedClassStatic4();
    static SynchronizedClassStatic4 instance2=new SynchronizedClassStatic4();

    public static synchronized  void method(){
        System.out.println("我是类锁的第一种形式：static形式。我叫"+Thread.currentThread().getName());
        try{
            //第一个线程执行完毕，等待3秒，再执行第二个线程
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
    @Override
    public void run() {
        method();
    }

    public static void main(String[] args) {
        Thread t1=new Thread(instance1);
        Thread t2=new Thread(instance2);
        t1.start();
        t2.start();
        while(t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }
}
