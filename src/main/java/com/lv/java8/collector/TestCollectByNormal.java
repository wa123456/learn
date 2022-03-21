package com.lv.java8.collector;

import java.util.*;

public class TestCollectByNormal {

    public static List<Apple> orchard = Arrays.asList(new Apple("green", 150),
            new Apple("red", 170), new Apple("green", 100), new Apple("red", 170),
            new Apple("yellow", 170), new Apple("green", 150));

    public static void main(String[] args) {
        Map<String, List<Apple>> baskets = new HashMap<>();
        for (Apple apple : orchard) {
            String color = apple.getColor();
            List<Apple> basket = baskets.get(color);
            if (null == basket) {
                basket = new ArrayList<>();
                baskets.put(color, basket);
            }
            basket.add(apple);
        }
        System.out.println(baskets);
    }

}
