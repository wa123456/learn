package com.zhouyang;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-11-09 00:22
 **/
public class ChangeStrDemo {

    public static void main(String[] args) {
        ChangeStrDemo c1 = new ChangeStrDemo();

        String str = "abc";

        System.out.println("str_main = " + str);
        c1.changeValue(str);
        System.out.println("str_main2 = " + str);

    }
    //我这个怎么错了呢？？，好奇怪啊！！！
    public void changeValue(String str){
        str = "xxx";
        System.out.println("str_inner = " + str);


    }

}
