package com.lv.test.sort;

import java.util.Arrays;

/**
 * 参考https://www.jianshu.com/p/705676f48e6c
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-07-22 17:06
 **/
public class HeapSortTest {
    public static void main(String[] args) {
        //int [] arr = {9,-1,7,5,70,2,50,0,3,8,6};
        int [] arr = {1,2,3,4,5,6,7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
   public static void heapSort(int[] arr){
        //构建一个大顶堆，从最左、下面的非叶子节点开始向上遍历
        for(int i = arr.length/2-1;i>= 0;i--){
            adjustHeap(arr,i,arr.length);
        }
        //循环执行以下操作：1.交换堆顶元素和末尾元素 2.重新调整为大顶堆
        for(int i =arr.length-1;i>0;i--){
            //将堆顶最大的元素与末尾元素互换，则数组中最后的元素变为最大值
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,i);
        }
   }

    /**
     * 构建大堆栈
     * @param arr 待调整的数组
     * @param parent 当前父节点下标，（当前节点）
     * @param length 数组长度（需要对多少元素进行调整）
     */
    public static void adjustHeap(int[] arr,int parent,int length){
        // 左子节点的下标
        int child = parent * 2 +1;
        // 临时保存父节点
        int temp = arr[parent];
        // 如果子节点的下标大于等于当前需要比较的元素个数，则结束循环
        while(child < length){
            // 判断左子节点和右子节点的大小，若右表大，则把child定位到右子节点
            if (child + 1 < length && arr[child] < arr[child+1]) {
                child++;
            }
            // 如果当前节点大于父节点赋值的temp
            if(arr[child] > temp){
                // 把当前节点的值赋给父节点
                arr[parent] = arr[child];
                //因为交换位置之后，不能保证当前的子节点是它子树的最大值，所以需要继续向下比较，
                //把当前子节点设置为下次循环的父节点，同时，找到它的左子节点，继续下次循环
                parent = child;
                child = parent * 2 + 1;
            }else {
                //如果当前子节点小于等于父节点，则说明此时的父节点已经是最大值了，
                //todo 前端是从最开始构建大堆是从左下开始，否则就不行
                break;
            }
        }
        //把当前节点值替换为最开始暂存的父节点值
        arr[parent] = temp;
    }

}
