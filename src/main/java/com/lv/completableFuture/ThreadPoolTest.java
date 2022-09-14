package com.lv.completableFuture;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadPoolTest {
    @Test
    public void test() throws  Exception {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            /*pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });*/
            FutureTask futureTask = new FutureTask(ThreadCallBack.getInstance());
            Object obj = "默认值";
            pool.submit(futureTask, obj);
            //此处打印futureTask.get(),所以线程会获得线程执行完成任务的结果，才会进入下一层循环
            System.out.println(futureTask.get());
        }
        pool.shutdown();
    }
 
}