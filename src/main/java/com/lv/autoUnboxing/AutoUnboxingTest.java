package com.lv.autoUnboxing;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-04-22 15:43
 **/
public class AutoUnboxingTest {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;
        System.out.println(a == b);//false
        System.out.println(a == c);//true
        System.out.println(" ******************** "  );
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);//true
        System.out.println(f3 == f4);//false
    }
}
