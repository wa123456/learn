package com.zhouyang.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-12-10 10:27
 **/
public class TimeWaitBlockQuene {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        try {
            System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer("b", 2L, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer("c", 2L, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer("d", 2L, TimeUnit.SECONDS));

            System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
            System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
            System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
            System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //前面3个立马放进去了，最后一个试了2s才放进去的；取得时候、尝试2s，如果2秒内取不出来，那么就返回null
    }
}
