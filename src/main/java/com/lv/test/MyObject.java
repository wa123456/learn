package com.lv.test;

/**
 * @program: learnning
 * @description:只负责按照条件线程安全的增加或者减少计数
 * @author: Lv
 * @create: 2020-07-19 09:51
 **/
public class MyObject {
    private int count ;
    //增加
    public synchronized void increase(){
        while (count != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count ++;

        System.out.println(Thread.currentThread().getName()+ "count ++= " + count);
        notify();
    }

    public synchronized  void decrease(){
        while(count == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count --;

        System.out.println(Thread.currentThread().getName()+ "count --= " + count);
        notify();
    }

}

