package com.lv;

public class SingleClass {
    public String myName = "zero";// 单例的名字，可以通过修改该成员变量，判断单例是否真的只有一个,本例子没做这部分内容判断，感兴趣可以自己改一下这个名字后，输出一下

    private static SingleClass self;// 持有自身对象的引用

    private SingleClass() {
    }

    public static SingleClass getInstance() {
        if (self == null) {// 双重检查锁
            newSelf();
        }
        return self;
    }

    private static synchronized/* 双重检查锁 */ SingleClass newSelf() {
        if (self == null) {// 双重检查锁
            self = new SingleClass();// 创建单例
        }
        return self;
    }

    public int cale(int x, int y) throws InterruptedException {
        Thread.sleep((int) (Math.random() * 100));// 随机时间休眠，模拟运算过程的时间长短不一，以造成多线程异步抢夺效果
        int z = x + y;
        Thread.sleep((int) (Math.random() * 100));
        return z;
    }



    public static void main(String[] args) {
        SingleClass sc = SingleClass.getInstance();// 先获取一下单例，保证初始化的稳定性
        for (int i = 0; i < 100; i++) {// 创建100个线程进行异步循环计算
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            SingleClass sc = SingleClass.getInstance();// 多线程模拟获取使用单例
                            int z, x, y, r;
                            x = (int) (Math.random() * 100);// 做两个int类型的随机数
                            y = (int) (Math.random() * 100);
                            z = x + y;// 预期结果
                            r = sc.cale(x, y);// 利用单例方法进行计算
                            if (r != z) {// 如果与预期结果不服，则输出
                                System.out.println("got error" + x + "|" + y + "|" + z + "|" + r + "|");
                                System.exit(0);// 系统自动退出
                            }
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        //System.out.println("程序运行结束");
    }


}
