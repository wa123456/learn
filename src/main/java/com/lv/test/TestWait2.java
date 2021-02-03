package com.lv.test;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-07-19 09:26
 **/
public class TestWait2 extends Thread{




    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        Producter producter = new Producter(myObject);
        Consumer consumer = new Consumer(myObject);
        Thread t1 = new Thread(producter);
        Thread t3 = new Thread(producter);
        Thread t2 = new Thread(consumer);
        Thread t4 = new Thread(consumer);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        //todo 为什么程序不能正常退出？？？？？而是阻塞在那里

    }
}





