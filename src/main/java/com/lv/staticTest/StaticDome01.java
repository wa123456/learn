package com.lv.staticTest;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-06-01 07:47
 **/
public class StaticDome01 {
    private int a = 10;
    private static int b = 20;

    static class StaticClass{
        public static int c = 30;
        public int d = 40;

        public static void print(){
            //下面代码会报错，静态内部类不能访问外部类实例成员
            //System.out.println(a);

            //静态内部类只可以访问外部类类成员
            System.out.println("静态内部类的静态方法，调用外部类类成员b");
            System.out.println("外部类类成员b="+b);

        }

        //实例方法
        public void print01(){
            //静态内部内所处的类中的方法，调用静态内部类的实例方法，属于外部类中调用静态内部类的实例方法
            System.out.println("静态内部类的实例方法，调用静态内部类的实例方法");
            StaticClass sc = new StaticClass();
            sc.print();
        }
    }

    public static void main(String[] args) {
        //AbstractQueuedSynchronizer
        StaticDome01 staticDome01 = new StaticDome01();
        //staticDome01
    }

}
