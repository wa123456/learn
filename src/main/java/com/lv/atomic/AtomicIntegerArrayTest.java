package com.lv.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @program: learnning
 * @description: 会将当前数据复制一份，不会改变他原始的数组值
 *
 * @author: Lv
 * @create: 2020-04-23 09:10
 **/
public class AtomicIntegerArrayTest {
    static int[] value = new int[]{1,2};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0,3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }

}
