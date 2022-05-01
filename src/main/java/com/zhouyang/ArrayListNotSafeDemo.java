package com.zhouyang;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListNotSafeDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        //List<String> list = new CopyOnWriteArrayList();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
    /**
    并发修改的异常
    java.util.ConcurrentModificationException
     */
}
