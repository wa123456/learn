package com.lv.test.sort;

import java.util.Arrays;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-08-25 14:05
 **/
public class ShellSortTest {

    public static void main(String[] args) {
        int array [] = {4,3,1,6,7,2,9,5};
        ShellSortTest.shellSort(array);
        System.out.println("array =: " + Arrays.toString(array));
    }


    public static void shellSort(int [] array){
        for (int gap = array.length/2; gap > 0; gap = gap/2) {
            for (int i = gap; i < array.length; i++) {
               if(array[i] < array[i-gap]){
                   int j =i;
                   int temp = array[i];
                   while(j-gap >= 0 &&  temp < array[j-gap]){
                       array[j]= array[j-gap];
                       j = j-gap;
                   }
                   array[j] = temp;
               }
            }
        }
    }

}
