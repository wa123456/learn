package com.lv.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: learnning
 * @description: 算法
 * @author: Lv
 * @create: 2020-07-04 14:52
 **/
public class RadixSort {
    public static void main(String[] args) {


        int a[]  = {10086,135,242,192,93,345,11,24,19,6};
        System.out.println("未排序后："+ Arrays.toString(a) );

        int[] b = RadixSort.bulkSort(a);
        //System.out.println("b = " + (int) Math.pow(10, 2));
        System.out.println("未排序后："+ Arrays.toString(b) );

    }

    public static int[] bulkSort(int[] a){
        //首先，找到最大的元素；看有多少位

        int max = a[0];
        for (int i = 0; i < a.length; i++) { // 找到数组中的最大值
            if (a[i] > max) {
                max = a[i];
            }
        }

        int keysNum = 0; // 关键字的个数，我们使用个位、十位、百位...当做关键字，所以关键字的个数就是最大值的位数
        while (max > 0) {
            max /= 10;
            keysNum++;
        }
        //其次，拿到个十、百、千、万位数的筒子

        List<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) { // 每位可能的数字为0~9，所以设置10个桶
            buckets.add(new ArrayList<Integer>()); // 桶由ArrayList<Integer>构成
        }
        //



        for (int i = 0; i < keysNum; i++) { // 由最次关键字开始，依次按照关键字进行分配

            for (int j = 0; j < a.length; j++) { // 扫描所有数组元素，将元素分配到对应的桶中
                // 取出该元素对应第i+1位上的数字，比如258，现在要取出十位上的数字，258%100=58,58/10=5
                //多少次方
                int key = a[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                buckets.get(key).add(a[j]); // 将该元素放入关键字为key的桶中
            }

            // 分配完之后，将桶中的元素依次复制回数组
            int counter = 0; // 元素计数器
            for (int j = 0; j < 10; j++) {
                ArrayList<Integer> bucket = buckets.get(j); // 关键字为j的桶
                while (bucket.size() > 0) {
                    a[counter++] = bucket.remove(0); // 将桶中的第一个元素复制到数组，并移除
                }
            }

        }
        return a;


    }

}
