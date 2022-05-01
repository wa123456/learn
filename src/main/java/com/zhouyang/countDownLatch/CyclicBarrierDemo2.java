package com.zhouyang.countDownLatch;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo2 {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            public void run() {
                Date date1 = new Date();
                String szDate = String.format("当前时间为：%tH时%tM分%tS秒", date1, date1, date1);
                System.out.println("既然都到了，那就一起去找产品谈谈吧,时间：" + szDate);
            }
        });
        for (int i = 0; i < 3; i++) {
            new Thread() {
                public void run() {
                    long thread1Id = Thread.currentThread().getId();
                    try {
                        Date date1 = new Date();
                        String szDate = String.format("当前时间为：%tH时%tM分%tS秒", date1, date1, date1);
                        System.out.println("程序员:" + thread1Id + "正在准备中，时间：" + szDate);
                        int r = (int) (Math.random() * 10000);
                        Thread.sleep(Long.parseLong(r + ""));
                        Date date2 = new Date();
                        String szDate2 = String.format("当前时间为：%tH时%tM分%tS秒", date2, date2, date2);
                        System.out.println("程序员:" + thread1Id + "  准备好了" + szDate2);
                        try {
                            System.out.println(
                                    "程序员:" + thread1Id + "到达栅栏，此时前面已经来了（被阻塞了）的程序员人数（线程数）" + cb.getNumberWaiting());
                            cb.await();
                        } catch (BrokenBarrierException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}