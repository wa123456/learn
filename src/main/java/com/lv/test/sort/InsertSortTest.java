package com.lv.test.sort;

import java.util.Arrays;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-08-25 14:05
 **/
public class InsertSortTest {

    public static void main(String[] args) {
        int array [] = {4,3,1,6,7,2,9,5};
        InsertSortTest.InsertSort(array);
        System.out.println("array =: " + Arrays.toString(array));
    }


    public static void InsertSort(int [] array){

            for (int i = 1; i < array.length; i++) {
               if(array[i] < array[i-1]){
                   int j =i;
                   int temp = array[i];
                   while(j-1 >= 0 &&  temp < array[j-1]){
                       array[j]= array[j-1];
                       j = j-1;
                   }
                   array[j] = temp;
               }
            }

    }

}
