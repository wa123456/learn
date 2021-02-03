package com.lv.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1
{
    public static void main(String[] args) {
        /*
        //groupingBy使用
        System.out.println("=======groupingBy==========");
        Stream<Person> stream = Stream.of(new Person("1", "aa", "12"), new Person("1", "bb", "13"), new Person("3", "cc", "14"));
        System.out.println(stream.collect(Collectors.groupingBy(x -> x.id)));

        //groupingBy
        Map<String, List<Person>> tempMap = Stream.of(new Person("1", "aa", "12"), new Person("1", "bb", "13"), new Person("3", "cc", "14"))
                .collect(Collectors.groupingBy(x -> x.id));
        for (String s : tempMap.keySet()) {
            tempMap.get(s).stream().forEach(x -> System.out.println(x));
        }

        Map<Boolean, List<Integer>> collectGroup = Stream.of(1, 2, 3, 4)
                .collect(Collectors.groupingBy(it -> it > 3));
        System.out.println("collectGroup : " + collectGroup);
        */


        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"e", "f", "c", "d"};
        String[] arr3 = {"h", "j", "c", "d"};
         Stream.of(arr1, arr2, arr3).flatMap(x -> Arrays.stream(x)).forEach(System.out::println);
        //Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).forEach(System.out::println);


    }
}


class Student {

    String name;
    int age;

    //ThreadPoolExecutor


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
    }

    public Student( String name, int age) {

        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +

                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

class Person {
    String id;
    String name;
    String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
