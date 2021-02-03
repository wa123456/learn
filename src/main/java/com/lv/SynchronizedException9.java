package com.lv;

/**
 * 第七种情况：方法抛出异常后，锁被释放。
 * 现象：一旦抛出异常，第二个线程会立刻进入同步方法，就意味着第一个的锁已经释放了
 *                                                                                                                                      结果：线程1执行并抛出异常后，线程2立即执行
 */
public class SynchronizedException9 implements Runnable {
    static SynchronizedException9 instance=new SynchronizedException9();
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
        System.out.println("我是第一个方法，我会抛出异常。我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
            //抛出异常

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //不能被捕获， 必须是运行时异常
        throw new RuntimeException();
        //System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    //对象锁：普通方法锁
    public synchronized void method2(){
        System.out.println("我是第二个方法。我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}
