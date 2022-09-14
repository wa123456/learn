package com.lv.book.lock;

import java.util.ArrayList;

/**
 * 计算器算法
 *
 * 1.用ArrayList集合
 *
 * 2.正则表达获取数字集合注意有小数Double
 *
 * 3.获取符号集合,注意符号先转成@,再转成-
 *
 * 4.获取* / 注意符号的0,就获取数字的01 ,1就获取12,再放入
 *
 * 5.获取+- 获取完* / +-只用while寻0即可
 *
 */

public class Demo11_Calc {
    public static void main(String[] args) {
        String str = "-3+5.0*-4-9/-3";
        Result(str);
    }

    static void Result(String str) {
        ArrayList<String> ops = getOps(str);
        ArrayList<Double> num = getNum(str);
        // 先乘除再加减
        for (int i = 0; i < ops.size(); i++) {
            if (ops.get(i).contains("*") || ops.get(i).contains("/")) {
                String op = ops.remove(i);
                if (op.equals("*")) {
                    // 从数字集合取对应和后面一位数字
                    double d1 = num.remove(i);
                    double d2 = num.remove(i);

                    double number = d1*d2;
                    //再加上
                    num.add(i,number);
                }
                if (op.equals("/")) {
                    double d1 = num.remove(i);
                    double d2 = num.remove(i);
                    double number = d1/d2;
                    num.add(i, number);
                }
                i--;    //刚刚移掉两个,却又刚加上一个新数,所以i要--,因为i++,所以才能取到,如果不加那么虽然貌似正常,但是如果如8*3/3,*/连在一起就报错了;因为连着的两个if;
            }
        }
        //到+-,按顺序的所以就用while()了
        while (ops.size() != 0) {
            String op = ops.remove(0);
            double d1 = num.remove(0);
            double d2 = num.remove(0);

            if (op.equals("+")) {
                double number = d1+d2;
                //再加入
                num.add(0, number);
            }
            if (op.equals("-")) {
                double number = d1-d2;
                num.add(0, number);
            }
        }
        System.out.println(num);
        //return num
    }

    /**
     * 获取符号 1.首位 和 * /后面 的-变成@,其他的-不用
     */
    private static ArrayList getNum(String str) {
        // -变成@
        str = change(str);
        ArrayList<Double> list = new ArrayList();

        String[] split = str.split("[\\+\\-\\*/]");
        for (int i = 0; i < split.length; i++) { // @3,5,@4,9,@3
            String s = split[i];
            // 再把@变成-
            if (s.contains("@")) {
                s = '-' + s.substring(1);
            }
            list.add(Double.parseDouble(s));
        }

        return list;
    }

    private static String change(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // @3+5*-4-9/-3
            if (i == 0 && chars[i] == '-') {
                str = '@' + str.substring(i + 1);
            }
            // @3+5*@4-9/@3
            if (chars[i] == '*' && chars[i + 1] == '-' || chars[i] == '/' && chars[i + 1] == '-') {
                str = str.substring(0, i + 1) + '@' + str.substring(i + 2);
            }
        }
        return str;
    }

    // 获取符号
    private static ArrayList getOps(String str) {
        ArrayList<String> list = new ArrayList();
        // @变-
        str = change(str);
        // @3+5*@4-9/@3
        String[] split = str.split("[0-9\\.@]");// 表示0-9包括小数和@
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains("+") || split[i].contains("-") || split[i].contains("*") || split[i].contains("/")) {
                list.add(split[i]);
            }
        }
        return list;
    }
}