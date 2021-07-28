package com.lv;

import java.util.concurrent.*;

public class Test_02 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>() {
            public Double call() {
                return 1.0;//doSomeLongComputation();
            }});
        //doSomethingElse();
        try {
            Double result = future.get(1, TimeUnit.SECONDS);
        } catch (ExecutionException ee) {
// 计算抛出一个异常
        } catch (InterruptedException ie) {
// 当前线程在等待过程中被中断
        } catch (TimeoutException te) {
// 在Future对象完成之前超过已过期
        }
    }
}
