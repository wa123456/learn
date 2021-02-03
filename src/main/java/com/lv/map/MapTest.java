package com.lv.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap();
        map.put("aaa",1);
        map.put("bbb",1);
        map.put("ccc",2);
        map.put("ddd",3);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        for (Integer value : map.values()) {
            System.out.println("Value = " + value);
        }

    }
}
