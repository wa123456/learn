package com.lv.test.sort;

import java.util.Arrays;


/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-07-25 22:06
 **/
public class BubbleSortTest {
    public static void main(String[] args) {
        int [] arr = {9,-1,7,5,70,2,50,0,3,8,6};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        //第一轮
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }


    }

    /**
     *  交换
     * @param arr
     * @param indexA
     * @param indexB
     */
    public static void swap(int[] arr,int indexA,int indexB){
        int temp = arr[indexB];
        arr[indexB] = arr[indexA];
        arr[indexA] = temp;
    }


}
