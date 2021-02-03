package com.zhouyang.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Callable有返回值
 * 批量处理的时候，需要带返回值的接口（例如支付失败的时候，需要返回错误状态）
 *
 */
class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("come in Callable");
        Thread.sleep(2000);
        return 1024;
    }


    public static void main(String[] args) {

        //FutureTask  implements RunnableFuture<V> (Runnable Future)

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        // 开启两个线程计算futureTask
         /*
        new Thread(futureTask, "AAA").start();
        // 输出FutureTask的返回值

        try {
            System.out.println("result FutureTask " + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("*********************");
        //这个是怎么给他展示出来呢？？
        */
        /*
        // 开启两个线程计算futureTask
        new Thread(futureTask, "AAA").start();
        new Thread(futureTask, "BBB").start();
        */
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread2());

// 开启两个线程计算futureTask
        new Thread(futureTask, "AAA").start();

        new Thread(futureTask2, "BBB").start();
    }
}