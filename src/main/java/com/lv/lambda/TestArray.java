package com.lv.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: learnning
 * @description: lambda 数组
 * @author: Lv
 * @create: 2020-01-11 15:22
 **/
public class TestArray {
    public static void main(String[] args) {
        String[] players = {"zhansgan", "lisi", "wangwu", "zhaoliu", "wangmazi"};

        // 1.1 使用匿名内部类根据 surname 排序 players
        /*
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });
        */

        

        // 1.2 使用 lambda 排序,根据 surname
        //Arrays.sort(players, (String s1, String s2) -> s1.compareTo(s2));
        /*
        Arrays.sort(players, (String s1, String s2) -> (s1.length() - s2.length()));
        for (String a :players) {
            System.out.println("a = " + a);
        }

        */
        List<String> list = Arrays.asList("xuxiaoxiao", "xudada", "xuzhongzhong");
        list.forEach(value -> System.out.println(value));

    }


}