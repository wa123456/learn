package com.lv;

import java.util.concurrent.TimeUnit;

public class TestDemo1 {
    public static void main(String[] args) {

        MyData myData1 = new MyData();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");

            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("sleep end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myData1.addTo60();

            System.out.println(Thread.currentThread().getName() + "\t update number value:" + myData1.number);

        }, "AAA").start();


        while (myData1.number == 0) {
            //System.out.println("while"+ myData1.number);
            //这是为什么呢？？
        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over");
        System.out.println(Thread.currentThread().getName() + "\t mission is over " + myData1.number);


    }    // seen  int num = 60;  if60 ze 执行下面的话






}


class MyData {

    int number = 0;

    public void addTo60(){
        this.number = 60;
    }

}