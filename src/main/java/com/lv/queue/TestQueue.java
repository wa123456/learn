package com.lv.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class TestQueue {
    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

    public static void main(String[] args) {
        TestQueue test = new TestQueue();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();

        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                try {

                    queue.take();
                    System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
                    //实际运行之后syso语句的数值确实是有误的。原因在于非阻塞案例中，synchronized同步了整个逻辑代码块，包含了syso语句，而阻塞案例中，只有阻塞容器的put()、take()方法内含锁，同步操作未能包括syso语句。

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread {

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                try {
                    queue.put(1);
                    System.out.println("向队列取中插入一个元素，队列剩余空间：" + (queueSize - queue.size()));
                    //实际运行之后syso语句的数值确实是有误的。原因在于非阻塞案例中，synchronized同步了整个逻辑代码块，包含了syso语句，而阻塞案例中，只有阻塞容器的put()、take()方法内含锁，同步操作未能包括syso语句。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}