package com.lv.test.sort;

import java.util.Arrays;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = {5,3,6,1,2,8,9,4,7};
        quickSort(arr,0,arr.length-1);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public static void quickSort(int [] arr,int left,int right){


        int l =left;
        int r = right;
        int middle = arr[(left+right)/2];


        while(l<r){

            while (arr[l] < middle){
                l+=1;
            }
            while(arr[r] > middle){
                r-=1;
            }

            if(l>= r){
                break;
            }
            swamp(arr,l,r);

            if(arr[l] == middle){
                r-= 1;
            }
            if(arr[r] == middle){
                l+= 1;
            }

        }

        if(l == r ){
            l+=1;
            r-=1;
        }


        if(l<right){
            quickSort(arr,l,right);
        }
        if(left< r){
            quickSort(arr,left,r);
        }
    }

    public static void swamp(int[] arr,int a,int b){
        int temp = 0;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
