package com.lv.algorithm;

import java.util.Arrays;

/**
 * @program: learnning
 * @description:  计数排序

 * https://www.cnblogs.com/zer0Black/p/6169858.html
 */

public class CountSort {


    public static void countingSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int max = 0, min = 0;

        //找出数组中最大最小值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int[] count = new int[max - min + 1];

        //对数组中每个出现的元素计数
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        //然后通过count数组得到数据的顺序
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {        //这里count[i]先与0比较,后--
                arr[index++] = i + min;        //这里arr[index]=i+min之后,index再++
            }
        }

    }


    public static void main(String[] args) {
        int[] arr = {5,200, 5, 3, 7, 2, 9, 4, 1};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}



