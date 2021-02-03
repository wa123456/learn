package com.lv.test;

/**
 * @program: learnning
 * @description: 生产者，可能随时随地都在生产
 * @author: Lv
 * @create: 2020-07-19 09:54
 **/
public class Producter extends Thread {

    Producter(){

    }
    Producter (MyObject myObject){
        this.myObject = myObject;
    }
    private MyObject myObject;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myObject.increase();
        }
    }
}
