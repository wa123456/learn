package com.zhouyang.lock;

public class ReadWriteLockDemoRW {
    public static void main(String[] args) {

        MyCacheRW myCacheRW = new MyCacheRW();

        // 线程操作资源类，5个线程写
        for (int i = 1; i <= 5; i++) {
            // lambda表达式内部必须是final
            final int tempInt = i;
            new Thread(() -> {
                myCacheRW.put(tempInt + "", tempInt +  "");
            }, String.valueOf(i)).start();
        }

        // 线程操作资源类， 5个线程读
        for (int i = 1; i <= 5; i++) {
            // lambda表达式内部必须是final
            final int tempInt = i;
            new Thread(() -> {
                myCacheRW.get(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }
}