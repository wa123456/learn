package com.lv.completableFuture;

import java.util.concurrent.*;

public class TestFuture2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        FutureTask<String> futureTask1 = new FutureTask(()->{
            Thread.sleep(100);
            return "yyds";
        });

        FutureTask<String> futureTask2 = new FutureTask(()->{
            Thread.sleep(200);
            return "yyds";
        });

        FutureTask<String> futureTask3 = new FutureTask(()->{
            Thread.sleep(300);
            return "yyds";
        });
        //所以说，跟get的放置的位置有很大关系；

        long startTime = System.currentTimeMillis();
        /*
        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        new Thread(futureTask3).start();
        */
        Future<?> submit = executorService.submit(futureTask1);
        executorService.submit(futureTask2);
        executorService.submit(futureTask3);


        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
        System.out.println(futureTask3.get());

        long endTime = System.currentTimeMillis();

        System.out.println("总共耗时" + (endTime - startTime) + "毫秒");

    }
}
