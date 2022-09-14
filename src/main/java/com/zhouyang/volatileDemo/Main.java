package com.zhouyang.volatileDemo;

/**
 * ResortSeqDemo
 *
 * @author: 陌溪
 * @create: 2020-03-10-16:08
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author lucas
 * @program java-test
 * @description 测试类
 * @createDate 2020-12-29 11:31:23
 * @slogan 别人笑我太疯癫，我笑他人看不穿； 长风破浪会有时，直挂云帆济沧海。
 **/
public class Main {
    static int a,b,x,y;
    public static void main(String[] args) throws InterruptedException {

        Set<String> stringSet = new HashSet<>();
        while (true){
            a=0;
            b=0;
            x=0;
            y=0;
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    x = 1; // 1
                    a = y; // 4

                }
            };
            Thread t2 = new Thread() {
                @Override
                public void run() {
                    y=1;  //2
                    b=x;  //3

                }
            };
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            stringSet.add("a:"+a+",b:"+b);
            System.out.println(stringSet);
            if(a == 0 && b ==0){
                break;
            }
        }
    }

}
