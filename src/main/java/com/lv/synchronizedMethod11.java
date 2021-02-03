package com.lv;

/**
 * @program: learnning
 * @description: 证明可重入不要求是同一个方法
 * @author: Lv
 * @create: 2020-05-19 15:51
 **/
public class synchronizedMethod11 {
    public synchronized  void method1(){
        System.out.println("我是method1");
        //调用自己累的同步方法 不需要再次获取锁 是可重入的
        method2();
    }
    private synchronized  void method2(){
        System.out.println("我是method2");
    }

    public static void main(String[] args) {
        synchronizedMethod11 s = new synchronizedMethod11();
        s.method1();
    }

}