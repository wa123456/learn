package com.lv;


import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestDemo2 {
    HashMap<String, String > map = new HashMap<>();


    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    Lock readLock1 = reentrantReadWriteLock.readLock();
    Lock writeLock = reentrantReadWriteLock.writeLock();

    public static void main(String[] args) {

        TestDemo2 testDemo2 = new TestDemo2();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                testDemo2.put("a"+ finalI,"A"+ finalI);
            }).start();

        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                testDemo2.get("a"+ finalI);
            }).start();

        }

    }


    public void put(String key,String value){

        //writeLock.lock();
        System.out.println("获取到写锁");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        map.put(key,value);
        System.out.println("放入值"+ key+"-->"+value);
        //writeLock.unlock();
        System.out.println("释放写锁");


    }

    public String get(String key){
        //readLock1.lock();
        System.out.println("获取到读锁");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s = map.get(key);
        System.out.println("获取值" + key+ "----"+ s);
        //readLock1.unlock();
        System.out.println("释放读锁");
        return s;
    }


}

