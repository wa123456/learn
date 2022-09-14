package com.zhouyang.lock;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Copyright: 2019-2021
 * @FileName: FileUploadQueue.java
 * @Author: PJL
 * @Date: 2020/12/3 10:35
 * @Description: 文件上传队列
 */
@Slf4j
public class FileUploadQueue {
 
    private ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
 
    private AtomicLong total = new AtomicLong(0);
 
    private AtomicLong completed = new AtomicLong(0);
 
    private AtomicInteger exeCount = new AtomicInteger(0);
 
    private ExecutorService executorService;
 
    //private OssHttpService ossHttpService;
 
    private Boolean started = false;
 
    private int poolSize;
 
    /**
     * 文件上传队列初始化
     *

     * @param executorPoolSize
     * @param startConsumer
     */
    public FileUploadQueue(//OssHttpService ossHttpService,
                           int executorPoolSize, boolean startConsumer) {
        this.poolSize = executorPoolSize;
        //this.ossHttpService = ossHttpService;
        //this.executorService = Executors.newWorkStealingPool(this.poolSize);
        this.executorService = Executors.newFixedThreadPool(4);
        if (startConsumer) {
            this.start();
        }
    }

    public static void main(String[] args)   {
        FileUploadQueue fileUploadQueue = new FileUploadQueue(5,true);

        new Thread(()->{
            try {
                while (true){
                    Thread.sleep((long) (Math.random()* 1000));
                    fileUploadQueue.enqueue(2);
                }



            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        ).run();
    }
 
    /**
     * 文件入队列
     *
     * @param fileInfo
     */
    public Long enqueue(Integer fileInfo) {
        queue.add(fileInfo);
        return total.incrementAndGet();
    }
 
    /**
     * 空闲判断
     *
     * @return
     */
    public Boolean isUnFull() {

        return exeCount.get() < poolSize;
    }
 
    /**
     * 空闲判断
     *
     * @return
     */
    public Boolean isBusy() {
        return exeCount.get() > 5 && isUnFull();
    }
 
    /**
     * 空闲判断
     *
     * @return
     */
    public Boolean isIdle() {
        return exeCount.get() <= 5;
    }
 
    /**
     * 开启消费线程
     */
    public void start() {
        if (!started) {
            new Thread(() -> {
                while (true) {
                    try {
                        System.out.println("poolSize:" + poolSize);
                        System.out.println("exeCount:"+exeCount);
                        int count = queue.size();
                        System.out.println("count:" + count);
                        // 线程池消费
                        if (count > 0 && isUnFull()) {
                            consumer();
                        }
                        // 忙碌延长休眠
                        if (count > 0 && isBusy()) {
                            Thread.sleep(100);
                        }
                        // 空闲缩短休眠
                        else if (count > 0 && isIdle()) {
                            Thread.sleep(50);
                        }else{
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"bbc").start();
            started = true;
        }
    }
 
    /**
     * 执行业务处理
     */
    private void consumer() {
        try {
            Thread.sleep((long) (Math.random()* 3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer fileInfo = queue.poll();
        if (null != fileInfo) {
            // 增加线程占用数量
            exeCount.incrementAndGet();
            // 提交执行任务
            executorService.submit(() -> {
                // 处理业务数据
                //ossHttpService.syncToAliyunOss(fileInfo);
                // 执行个数增加
                completed.incrementAndGet();
                // 线程池占用减少
                if (exeCount.get() > 0) {
                    exeCount.decrementAndGet();
                }
                // 打印处理进度
                System.out.println("线程名:" + Thread.currentThread().getName());
                System.out.println("===队列消费进度==={}/{}" + completed.get()+ " / " + total.get());

                // 处理完成通知
                if (completed.get() == total.get()) {
                    System.out.println("=====================所有文件上传完成!=======================");
                }
            });
        }
    }
 
}