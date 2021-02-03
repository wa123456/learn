package com.lv.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = { 9,8,2, 1,7,6, 4,0, 5,3 };

        System.out.println(bubbleSort(a));

        for (int i = 0; i < a.length; i++) {
            System.out.println("a[i]  = " + a[i] +" ");
        }
    }


    /**
     * 第一个元素依次与别的元素比较，找到最小的元素
     * @param a
     * @return
     */
    public static  int[]   bubbleSort(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i]>a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j]= temp;
                }
            }
        }
        return a ;
    }

    /**
     * 内层元素比较，最小的放在最左边
     * @param a
     * @return
     */
    public static  int[]   bubbleSort2(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length- i-1; j++) {
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1]= temp;
                }
            }
        }
        return a ;
    }
}
