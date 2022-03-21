package com.lv.java8.collector;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestCollectByCollector {

    public static void main(String[] args) {
        Map<String, List<Apple>> baskets = TestCollectByNormal.orchard.stream()
                .collect(Collectors.groupingBy(Apple::getColor));
        System.out.println(baskets);
    }

}
