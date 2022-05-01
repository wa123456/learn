package com.lv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Huangqing
 * @date 2018/7/25 16:37
 */
public class IteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        list.add("goudan");
        list.add("mafei");
        list.add("lubenwei");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("lisi")) {
                list.remove(list.get(i));
            }
        }
        System.out.println(list);


        /*for (String s : list) {
            if (s.equals("lisi")) {
                list.remove(s);
            }
        }*/
        /*Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
        }*/
    }
}