package com.lv.test.sort;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-07-29 10:16
 **/
public class KPMTest {
    public static void main(String[] args) {
        String text =    "ababaababcabcd";
        String pattern = "ababcab";
        int returnSesult = search(text,pattern);
        System.out.println("returnSesult = " + returnSesult);
    }

    public static int search(String text, String pattern) {
        int N = text.length();
        int M = pattern.length();
        for (int i = 0; i < N-M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (text.charAt(i+j) != pattern.charAt(j))
                    break;
            }
            // j 为pattern的下标 M是pattern的长度
            if (j == M) return i;
        }

        return -1;
    }
}
