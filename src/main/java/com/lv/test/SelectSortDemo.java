package com.lv.test;

import java.util.Arrays;

/**
 * @program: learnning
 * @description: 选择排序
 * @author: Lv
 * @create: 2020-08-17 06:41
 **/
public class SelectSortDemo {
    public static void main(String[] args) {
        int[] array = {5,4,1,3,6,2,7,9,8};
        selectSort(array);
        System.out.println("array = " + Arrays.toString(array));
    }


    public static void selectSort(int[] array){

        for (int i = 0; i < array.length; i++) {
            int tempMin = array[i];
            int tempIndex = i;

            //找到这趟的最小值
            for (int j = i+1; j < array.length; j++) {
                if (tempMin > array[j]){
                    tempMin = array[j];
                    tempIndex = j;
                }
            }
            if(i != tempIndex){
                swamp(array,i,tempIndex);
            }
        }
    }
    //交换
    public static void swamp(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
