package com.lv.java8.collector;

import java.util.*;

public class TestCollectByOptional {

    public static void main(String[] args) {
        Map<String, List<Apple>> baskets = new HashMap<>();
        TestCollectByNormal.orchard.forEach(apple -> {
            //这个颜色的篮子如果有的话就直接放对应颜色的苹果，如果没有的话，就先创建一个这样的篮子
            List<Apple> basket = Optional.ofNullable(baskets.get(apple.getColor()))
                    .orElseGet(() -> {
                        List<Apple> tempbasket = new ArrayList<>();
                        baskets.put(apple.getColor(), tempbasket);
                        return tempbasket;
                    });
            basket.add(apple);
        });
        System.out.println(baskets);
    }

}
