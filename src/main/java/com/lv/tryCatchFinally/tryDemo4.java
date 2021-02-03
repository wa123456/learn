package com.lv.tryCatchFinally;

/**
 * @program: learnning
 * @description:finally并不会改变返回的内容。
 * @author: Lv
 * @create: 2020-05-22 09:52
 **/
public class tryDemo4 {
    public static int show() {
        int result = 0;
        try {
            return result;
        }finally{
            System.out.println("finally模块被执行");
            result = 1;
        }
    }


    public static void main(String args[]) {
        System.out.println(show());
    }
}
