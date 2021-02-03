package com.lv;

/**
 * 情况一：两个线程同时访问同一个对象
 * 对象锁：普通方法锁
 *                                                                                                                                                                                  结果：线程一输出3秒后输出线程二
 */
public class SynchronizedObjectMethod3 implements Runnable {
    //创建实例对象
    static SynchronizedObjectMethod3 synchronizedObjectMethod3=new SynchronizedObjectMethod3();

    public static void main(String[] args) {
        Thread t1=new Thread(synchronizedObjectMethod3);
        Thread t2=new Thread(synchronizedObjectMethod3);
        t1.start();
        t2.start();
        while(t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }
    @Override
    public void run() {
        //运行普通方法method
        method();
    }
    public synchronized void method(){
        System.out.println("我是对象锁的方法修饰符形式,我叫"+Thread.currentThread().getName());
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}
