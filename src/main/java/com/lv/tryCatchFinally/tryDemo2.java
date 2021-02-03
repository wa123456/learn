package com.lv.tryCatchFinally;

/**
 * @program: learnning
 * @description:先finally然后再catch中的return，当抛出异常后，就不在执行try后边的语句
 * @author: Lv
 * @create: 2020-05-22 09:52
 **/
public class tryDemo2 {
    public static int show() {
        try {
            int a = 8/0;
            return 1;
        }catch (Exception e) {
            return 2;
        }finally{
            System.out.println("finally模块被执行");
        }
    }

    public static void main(String args[]) {
        System.out.println(show());
    }
}
