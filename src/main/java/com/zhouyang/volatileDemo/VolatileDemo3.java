package com.zhouyang.volatileDemo;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-11-08 11:57
 **/
public class VolatileDemo3 {
    
    public static void main(String[] args) {


/*
        SingleTon s1 = SingleTon.getSingleTon();
        System.out.println("s1 = " + s1);
        SingleTon s2 = SingleTon.getSingleTon();
        System.out.println("s2 = " + s2);

        if(s1 == s2){
            System.out.println(" s1 == s2 true "  );
        }else {
            System.out.println(" s1 != s2 " );
        }
        */

        for (int i = 0; i < 10; i++) {
            new Thread(
            () ->{
                     SingleTon.getSingleTon();
                }

            ).start();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(
                    () -> {
                SingleTon.getSingleTon();
            }, String.valueOf(i)

            ).start();
        }



    }
}

class SingleTon{

    private volatile static SingleTon singleTon = null;

    private  SingleTon(){
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo");
    }
    



    
    public static SingleTon getSingleTon(){

        if(null == singleTon){
            // a 双重检查加锁多线程情况下会出现某个线程虽然这里已经为空，但是另外一个线程已经执行到d处
            synchronized (SingleTon.class) {
                //是不是用volatile禁止指令重排呀？？，分析文章，是禁止了指令重排；
//c不加volitale关键字的话有可能会出现尚未完全初始化就获取到的情况。原因是内存模型允许无序写入
                if (null == singleTon) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }

    /*
    private  SingleTon(){
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo");
    }

    private static SingleTon singleTon = null;

    public static SingleTon getSingleTon(){
        if(null == singleTon){
            singleTon = new SingleTon();
        }
        return singleTon;
    }
    */


    
}

