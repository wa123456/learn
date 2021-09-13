package com.lv.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        /*
        List<String> list= Arrays.asList("a", "b", "c", "d");
        List<String> collect =list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect); //[A, B, C, D]

        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(collect1); //[2, 4, 6, 8, 10
        */

        //IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        //IntStream.range(1, 5).forEach(System.out::println);

        //IntStream.rangeClosed(1, 6).forEach(System.out::println);

        //这段代码生成一个整数 list 的平方数 {1, 4, 9, 16}。
        /*
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(squareNums);
        */
        /*
        //flatMap
        //将最底层元素抽出来放到一起，最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字。
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.flatMap((childList) -> childList.stream());
        List<Integer> list =outputStream.collect(Collectors.toList());
        System.out.println(list.toString());
        */

        //留下偶数，经过条件“被 2 整除”的 filter，剩下的数字为 {2, 4, 6}。
        /*
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens =Stream.of(sixNums).filter(n -> n%2 == 0).toArray(Integer[]::new);
        Stream.of(evens).forEach(System.out::println);
        */
        //把每行的单词用 flatMap 整理到新的 Stream，然后保留长度不为 0 的，就是整篇文章中的全部单词了。
        //REGEXP为正则表达式，具体逻辑具体分析
        /*
        List<String> output = reader.lines().
                flatMap(line -> Stream.of(line.split(REGEXP))).
                filter(word -> word.length() > 0).collect(Collectors.toList());
        */
        //年龄为男性的，则打印出他的名字；
        //roster.stream().filter(p -> p.getGender() == Person.Sex.MALE).forEach(p -> System.out.println(p.getName()));
        //当需要为多核系统优化时，可以 parallelStream().forEach()，只是此时原有元素的次序没法保证，并行的情况下将改变串行时操作的行为，
        // 此时 forEach 本身的实现不需要调整，而 Java8 以前的 for 循环 code 可能需要加入额外的多线程逻辑。

        String strA = " abcd ", strB = null;
        print(strA);
        print("");
        print(strB);

        //getLength(strA);
        //getLength("");
        //getLength(strB);





        /*
        // reduce用例
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        // 求和，sumValue = 10, 无起始值，返回Optional,所以有get()方法
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F")
                .filter(x -> x.compareTo("Z") > 0)
                .reduce("", String::concat);
        */
    }


    //输出text不为null的值
    public static void print(String text) {
        // Java 8
        Optional.ofNullable(text).ifPresent(
                System.out::println);
        // Pre-Java 8
        //if (text != null) {
        //    System.out.println(text);
        //}
    }
    //输出text的长度，避免空指针
    public static int getLength(String text) {
        // Java 8
        return Optional.ofNullable(text).map(String::length).orElse(-1);
        // Pre-Java 8
        //return if (text != null) ? text.length() : -1;
    }

}
