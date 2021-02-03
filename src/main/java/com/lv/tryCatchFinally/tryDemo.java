package com.lv.tryCatchFinally;

/**
 * @program: learnning
 * @description:先finally然后再try中的return
 * @author: Lv
 * @create: 2020-05-22 09:52
 **/
public class tryDemo {
    public static int show() {
        try {
            return 1;
        }finally{
            System.out.println("finally模块被执行");
        }
    }
    public static void main(String args[]) {
        System.out.println(show());
    }
}
