package com.lv.suanfa;

public class array {
    /**
     * 数组，定长，同类型；
     * @param args
     */
    public static void main(String[] args) {
        //Array array =
        String [] strs = {"a","b"};

        System.out.println(strs.length);

        String [] str2 = new String[3];
        str2[0] = "cc";


        for (int i = 0; i < str2.length; i++) {
            System.out.println(str2[i]);

        }
    }
}
