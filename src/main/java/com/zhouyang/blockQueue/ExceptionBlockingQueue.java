package com.zhouyang.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-12-10 10:02
 **/
public class ExceptionBlockingQueue {
    public static void main(String[] args) {
        /*
        // 阻塞队列，需要填入默认值
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.add("XXX"));
        //java.lang.IllegalStateException: Queue full
        */

        // 阻塞队列，需要填入默认值
        /**/
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //java.util.NoSuchElementException

    }

}
