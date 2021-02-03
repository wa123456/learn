package com.lv;

/**
 * @program: learnning
 * @description: 证明可重入不要求是同一个类中
 * @author: Lv
 * @create: 2020-05-19 15:53
 **/
public class synchronizedSuperClass {
    public synchronized void doSomething(){
        System.out.println("我是父类方法");

    }
}

class TestClass extends synchronizedSuperClass{
    public synchronized void doSomething(){
        System.out.println("子类方法");
        //调用其他方法 不需要获取锁
        super.doSomething();
    }
    public static void main(String[] args) {
        TestClass a =new TestClass();
        a.doSomething();
    }
}
