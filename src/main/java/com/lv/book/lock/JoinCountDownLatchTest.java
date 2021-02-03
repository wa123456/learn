package com.lv.book.lock;

/**
 * @program: learnning
 * @description: Threadjoin方法  join用于让当前执行线程等待join线程执行结束
 * @author: Lv
 * @create: 2020-06-05 09:20
 **/
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser1 finish");
            }
        });
        Thread parser2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser2 finish");
            }
        });
        parser1.start();
        parser2.start();
        System.out.println("before t1.join》》》");
        parser1.join();
        System.out.println("finish t1.join》》》》");
        parser2.join();
        //我的理解，这句话永远最后一行执行，
        System.out.println("all parser finish");
    }
}
