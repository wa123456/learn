package com.lv.singleton;

public class TestSingleton {
    public static void main(String[] args) {
        /*
        SingletonDemo2 s2_1 = SingletonDemo2.getInstance();
        SingletonDemo2 s2_2 = SingletonDemo2.getInstance();
        System.out.println(s2_1 == s2_2);
        */

        ImageLoader i1 = ImageLoader.getInstance();
        ImageLoader i2 = ImageLoader.getInstance();

        System.out.println(i1 == i2);
    }
}
