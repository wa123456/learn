package com.lv.test;

import java.util.Arrays;

/**
 * @program: learnning
 * @description: 插入排序
 * @author: Lv
 * @create: 2020-08-17 06:41
 **/
public class InsertSortDemo {
    public static void main(String[] args) {
        int[] array = {5,4,1,0,3,6,2,7,9,8};
        insertSort(array);
        System.out.println("array = " + Arrays.toString(array));
    }


    public static void insertSort(int[] array){

        for (int i = 1; i < array.length; i++) {
            int current = i;
            int temp = array[current];
            while( current> 0 && temp < array[current-1] ){
                //锚点的后面的数只要比锚点大，就前移
                array[current] = array[current-1];
                current --;
            }
            if(current != i){
                array[current] = temp;
            }
        }
    }


}
