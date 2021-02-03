package com.lv.algorithm;

import java.util.Arrays;

/**
 * @program: learnning
 * @description:堆排序
 * @author: Lv
 * @create: 2020-07-12 21:16
 **/
public class Sort {
    static int [] array = {7,1,9,2,5,10,6,4,3,8};
    public static void main(String[] args) {
        Sort sort = new Sort();
        System.out.println("未排序时："+ Arrays.toString(array));
        sort.heapSort();
        System.out.println("排序后数组 = " + Arrays.toString(array));
    }

    // 堆排序
    public void heapSort() {

        buildHeap();
        System.out.println("建堆：");
        printTree(array.length);

        int lastIndex = array.length - 1;
        while (lastIndex > 0) {
            swap(array,0, lastIndex);
            // 取出堆顶元素，将堆底放入堆顶。其实就是交换下标为0与lastIndex的数据
            if (--lastIndex == 0)
                break; // 只有一个元素时就不用调整堆了，排序结束
            adjustHeap(0, lastIndex); // 调整堆

            System.out.println("调整堆：");
            printTree(lastIndex + 1);
        }

    }

    /**
     *
     * - 用数组中的元素建堆
     */
    private void buildHeap() {
        int lastIndex = array.length - 1;
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // (lastIndex-1)/2就是最后一个元素的根节点的下标，依次调整每棵子树
            adjustHeap(i, lastIndex); // 调整以下标i的元素为根的子树


        }
    }

    /**
     *
     * - 调整以下标是rootIndex的元素为根的子树
     *
     * - @param rootIndex 根的下标
     *
     * - @param lastIndex 堆中最后一个元素的下标
     */
    private void adjustHeap(int rootIndex, int lastIndex) {

        int biggerIndex = rootIndex;
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;

        if (rightChildIndex <= lastIndex) { // 存在右子节点，则必存在左子节点

            if (array[rootIndex] < array[leftChildIndex] || array[rootIndex] < array[rightChildIndex]) { // 子节点中存在比根更大的元素
                biggerIndex = array[leftChildIndex] < array[rightChildIndex] ? rightChildIndex : leftChildIndex;
            }

        } else if (leftChildIndex <= lastIndex) { // 只存在左子节点

            if (array[leftChildIndex] > array[rootIndex]) { // 左子节点更大
                biggerIndex = leftChildIndex;
            }
        }

        if (biggerIndex != rootIndex) { // 找到了比根更大的子节点

            swap(array,rootIndex, biggerIndex);

            // 交换位置后可能会破坏子树，将焦点转向交换了位置的子节点，调整以它为根的子树
            adjustHeap(biggerIndex, lastIndex);
        }
    }

    /**
     *
     * - 将数组按照完全二叉树的形式打印出来
     */
    private void printTree(int len) {

        // int len = array.length;
        int layers = (int) Math.floor(Math.log((double) len) / Math.log((double) 2)) + 1; // 树的层数
        int maxWidth = (int) Math.pow(2, layers) - 1; // 树的最大宽度
        int endSpacing = maxWidth;
        int spacing;
        int numberOfThisLayer;
        for (int i = 1; i <= layers; i++) { // 从第一层开始，逐层打印
            endSpacing = endSpacing / 2; // 每层打印之前需要打印的空格数
            spacing = 2 * endSpacing + 1; // 元素之间应该打印的空格数
            numberOfThisLayer = (int) Math.pow(2, i - 1); // 该层要打印的元素总数

            int j;
            for (j = 0; j < endSpacing; j++) {
                System.out.print("  ");
            }

            int beginIndex = (int) Math.pow(2, i - 1) - 1; // 该层第一个元素对应的数组下标
            for (j = 1; j <= numberOfThisLayer; j++) {
                System.out.print(array[beginIndex++] + " ");
                for (int k = 0; k < spacing; k++) { // 打印元素之间的空格
                    System.out.print("  ");
                }
                if (beginIndex == len) { // 已打印到最后一个元素
                    break;
                }
            }

            System.out.println();
        }
        System.out.println();
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
