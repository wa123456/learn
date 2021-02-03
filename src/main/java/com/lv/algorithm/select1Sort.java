package com.lv.algorithm;

import java.util.Arrays;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-07-07 11:13
 **/
public class select1Sort {
    public static void main(String[] args) {
        int [] arr = {1024,2,4,5,7,1,6,12,32,51,22};
        select1Sort.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] selectionSort(int[] array) {
        int minPoint; // 存储最小元素的小标
        int len = array.length;
        int temp;
        int counter = 1;

        for (int i = 0; i < len - 1; i++) {

            minPoint = i;
            for (int j = i + 1; j <= len - 1; j++) { // 每完成一轮排序，就确定了一个相对最小元素，下一轮排序只对后面的元素排序
                if (array[j] < array[minPoint]) { // 如果待排数组中的某个元素比当前元素小，minPoint指向该元素的下标
                    minPoint = j;
                }
            }

            if (minPoint != i) { // 如果发现了更小的元素，交换位置
                temp = array[i];
                array[i] = array[minPoint];
                array[minPoint] = temp;
            }

            //System.out.print("第" + counter + "轮排序结果：");

            counter++;
        }
        return array;
    }
}
