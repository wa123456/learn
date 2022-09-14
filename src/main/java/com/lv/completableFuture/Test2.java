package com.lv.completableFuture;

import java.util.concurrent.*;

public class Test2 {
    public static void main(String[] args) {

        Phone phonea = new Phone();
        Phone phoneb = new Phone();

        new Thread(()->{
            phonea.sendEmail();
        }).start();
        new Thread(()->{
            phonea.sendMsg();
        }).start();


    }
}


class Phone{

    public  synchronized void sendEmail(){
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("---send Email---");
    }

    public   void sendMsg(){
        synchronized (Phone.class){
            System.out.println("---send Msg---");
        }

    }

    public  void sayHello(){
        System.out.println("---say hello---");
    }

}

