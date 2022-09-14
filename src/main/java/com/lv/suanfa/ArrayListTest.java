package com.lv.suanfa;

import java.util.ArrayList;

public class ArrayListTest {
    /**
     * ArrayList 数组扩容，10 然后到了
     * 整理：https://blog.csdn.net/qq_42453117/article/details/122099920
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ff");

        arrayList.add("ff");
        arrayList.add("ff");
        arrayList.add("ff");
        arrayList.add("ff");
        arrayList.add("ff");
        arrayList.add("ff");
        arrayList.add("ff");
        arrayList.add("ff");
        arrayList.add("ff");
        //移位操作，应该就是除以的意思
        //System.out.println(15 >> 1);

    }
}
