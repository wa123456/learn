package com.zhouyang.CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: learnning
 * @description: 比较并交换：compareAndSet
 * @author: Lv
 * @create: 2020-11-07 20:32
 **/


public class CASDemo {
    public static void main(String[] args) {
        // 创建一个原子类
        AtomicInteger atomicInteger = new AtomicInteger(5);

        /**
         * 一个是期望值，一个是更新值，但期望值和原来的值相同时，才能够更改
         * 假设三秒前，我拿的是5，也就是expect为5，然后我需要更新成 2019
         */
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data: " + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data: " + atomicInteger.get());
    }
}
/**疑问：
 * 1，怎么看unsafe类的源码？为什么要到安装包下面去看？
 * 2，多核cpu与单核CPU有哪些区别；
 *
 * 总结：
 * 1，调用UnSafe类中的CAS方法，JVM会帮我们实现出CAS汇编指令，这是一种完全依赖于硬件的功能，通过它实现了原子操作
 * 也就是说CAS是一条CPU的原子指
 * 2，Unsafe相当于一个后门，基于该类可以直接操作特定的内存数据
 *
 *
 * 特点：
 * 优点：CAS轻量，这样提高了并发性，
 * 缺点：1、可能会多次循环，循环时间长，开销大
 *      2、但是对于多个共享变量操作时，循环CAS就无法保证操作的原子性，这个时候只能用锁来保证原子性
 */

