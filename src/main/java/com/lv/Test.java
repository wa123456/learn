package com.lv;

public class Test {

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        final Counter counter = new Counter();
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 50; j++) {
                        counter.increase();
                        System.out.println("cc");
                    }
                }
            }).start();
        }
        // 等待所有线程执行完毕
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(counter.count);

    }

}
