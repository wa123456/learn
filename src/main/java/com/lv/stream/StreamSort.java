package com.lv.stream;

import java.util.*;

public class StreamSort {

    /**
     *  https://blog.csdn.net/weixin_38569499/article/details/87875183
     *
     * @param args
     */

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

        System.out.println("listOfIntegers:");
        listOfIntegers
                .stream()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("listOfIntegers sorted in reverse order:");
        Comparator<Integer> normal = Integer::compare;
        Comparator<Integer> reversed = normal.reversed();
        Collections.sort(listOfIntegers, reversed);
        listOfIntegers
                .stream()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("Parallel stream");
        listOfIntegers
                .parallelStream()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("Another parallel stream:");
        listOfIntegers
                .parallelStream()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("With forEachOrdered:");
        listOfIntegers
                .parallelStream()
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("");
    }
}

/*
流的元素的执行顺序，取决于流的串并行、流的数据源、以及中间操作：

1、数据源：如果数据源本身是无序的，那么讨论元素的执行顺序就没有意义；

2、对于串行的流，其数据源是有序的，如果中间操作中没有排序之类的影响顺序的操作，那么在最终操作中处理元素的顺序，和数据源中元素的顺序就是一致的；如果中间操作中有排序之类的操作，那么在最终操作中处理元素的顺序，和依次执行各个中间操作之后的元素顺序，是一致的。

3、对于并行的流，其数据源是有序的，但是其最终操作中处理元素的顺序依然是随机的；但是并行流可以通过foreachOrdered保证执行顺序和数据源中元素的顺序一致。

原文链接：https://blog.csdn.net/weixin_38569499/article/details/87875183
 */
