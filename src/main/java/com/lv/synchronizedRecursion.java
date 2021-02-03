package com.lv;

/**
 * @program: learnning
 * @description: 证明同一个方法是可重入的
 * @author: Lv
 * @create: 2020-05-19 15:50
 **/
public class synchronizedRecursion {
    int a = 0;
    public static void main(String[] args) {
        synchronizedRecursion synchronizedRecursion= new synchronizedRecursion();
        synchronizedRecursion.method1();

    }

    private synchronized  void method1() {
        System.out.println("这时method1,a=" + a);
        if(a == 0){
            a++;
            //递归调用自己 此时内部方法 不需要从外再次获取锁
            method1();
        }
    }
}