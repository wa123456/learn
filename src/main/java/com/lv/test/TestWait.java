package com.lv.test;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-07-19 09:26
 **/
public class TestWait extends Thread{




    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        Producter producter = new Producter(myObject);
        Consumer consumer = new Consumer(myObject);
        Thread t1 = new Thread(producter);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();


    }
}





