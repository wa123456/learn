package com.zhouyang.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-12-10 10:20
 **/
public class BlockQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        try {
            blockingQueue.put("a");
            blockingQueue.put("b");
            blockingQueue.put("c");
            System.out.println("================");

            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //最后一个取不出来时，会阻塞；
    }
}
