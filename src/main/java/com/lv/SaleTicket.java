package com.lv;

public class SaleTicket {

    public static void main(String[] args) {

        // 创建一个Ticket类的对象,分别传给不同的线程
        Ticket ticket = new Ticket();

        // 创建四个买票线程,开始卖票
        Thread t2 = new SaleTicketThread("卖票线程1", ticket);
        Thread t3 = new SaleTicketThread("卖票线程2", ticket);
        Thread t4 = new SaleTicketThread("卖票线程3", ticket);
        Thread t5 = new SaleTicketThread("卖票线程4", ticket);
    }
}
/**
 * 创建车票类、初始化车票
 * @author haokui
 *
 */
class Ticket {
    // 初始化200张票的作为空间
    private String[] tickets = new String[200];
    private int index = tickets.length - 1; // 指向数组的索引(第一张票)

    public Ticket() {
        this.initTicket();
    }

    public void initTicket() {
        // 初始化车票,给数组的元素赋值,考虑是否要同步
        for (int i = 0; i < tickets.length; i++) {
            tickets[i] = "第" + (i + 1) + "号车票";
        }
    }

    public synchronized String saleTicket() throws Exception {
        // 判断是否有票,有票的情况下再卖票,没有票呢,抛出异常,
        // 考虑是否需要同步
        if (index >= 0) {
            String s = tickets[index];
            // 故意制造了一个问题,出现多个线程共卖一张车票
            try {
                Thread.sleep(10); } catch (InterruptedException e) {
                e.printStackTrace(); }
            tickets[index] = null;
            index--;
            return s;
        } else {
            throw new Exception("没有票了");
        }

    }
}
/**
 * 创建卖票线程类
 * @author haokui
 *
 */
class SaleTicketThread extends Thread {

    private Ticket ticket;

    public SaleTicketThread(String name, Ticket ticket) {
        super(name);
        this.ticket = ticket;
        this.start();
    }

    // 在run方法中卖车票
    @Override
    public void run() {
        for (int i = 0; i < 60; i++) {
            try {
                String s = ticket.saleTicket();
                System.out.println(this.getName() + "卖票成功========>" + s);
            } catch (Exception e) {
                System.out.println(this.getName() + " 卖票时发生异常!");
                e.printStackTrace();
                // 如果发生异常,说明没有车票了,就中断循环,不要在卖票了
                break;
            }
        }
    }
}

