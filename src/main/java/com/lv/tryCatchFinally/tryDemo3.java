package com.lv.tryCatchFinally;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: learnning
 * @description:我们可以看到当finally有返回值时，会直接返回。不会再去返回try或者catch中的返回值。
 * @author: Lv
 * @create: 2020-05-22 09:52
 **/
public class tryDemo3 {
    public static int show() {
        try {

            List list = new ArrayList<>();
            list.add("tom");
            //ReentrantLock
            int a = 8/0;
            return 1;
        }catch (Exception e) {
            return 2;
        }finally{
            System.out.println("finally模块被执行");
            return 0;
        }
    }


    public static void main(String args[]) {
        System.out.println(show());
    }
}
