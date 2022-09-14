package com.lv.book.lock;

import java.util.ArrayList;
import java.util.Stack;

public class Demo10_test {
    private static Object calc;

    public static void main(String[] args) {
                calcDemo();
    }

    private static void calcDemo() {
        String str = "3+12/(2-8)+7*((55+1)/2+0.2*(9-1))/2+10";
        // 括弧:先判断左括号和右括号是否相等,再判断括号是否左右是否匹配
        if (!isPiPei(str)) {
            return;
        }
        if (str.contains("()")) {
            System.out.println("包含了空的括号，不符合,请检查重新输入");
            return;
        }
        /*--------------集合存单字符,用于随时移除和添加--------------*/
        // 加上括号,这样就能当作最终的表达式并判断，最终求出结果
        str = "(" + str + ")";

        ArrayList str_list = new ArrayList();

        for (int i = 0; i < str.length(); i++) {
            str_list.add(str.charAt(i));
        }
        /*--------------获取所有的单位括号内容--------------*/
        //关键是获取每一次“对称的括号”，并逐个计算，小到大，所以用栈是最好的方法。
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < str_list.size(); i++) {
            if ((char)str_list.get(i) == '(') {
                stack.add(i);
            }
            if ((char)str_list.get(i) == ')') {
                // 移除栈记录的内容角标
                int s = stack.pop();

                // 获取式子内容
                StringBuilder sb = new StringBuilder();
                for (int j = s; j <= i; j++) {
                    sb.append(str_list.get(j));
                }

                int sbLength = i - s + 1;// 重点(这部把是最容易出错的了,(sb.Length()按照的是字符串,看似满足其实不满足list,因为8123488或者再长的小树，在list只占一位,这里用i-s+1才满足所有))

                for (int k = 0; k < sbLength; k++) {
                    str_list.remove(s);// 移除这个位置长度次
                }
                // 获取括号中的式子,计算成结果,在放入集合变成新的式子
                String strCalc = sb.substring(1, sb.length() - 1);
                double num = new Double(1);// Demo11_Calc.Result(strCalc);
                str_list.add(s, num);

                System.out.println(str_list);
                i = i - sbLength + 1; // 移掉后,占一位,++后要能获取"本来i位置"的下一位
                if (i < -1) {// 防越界
                    break;
                }
            }
        }
    }

    /**
     * 判断字符串里的"左和右"括号是否"相等"
     */
    private static boolean isCountEqual(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                left++;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')') {
                right++;
            }
        }
        if (left == right) {

        } else {
            System.out.println("表达式括号不匹配");
        }
        return left == right;
    }

    /**
     * 判断字符串里的"左和右"括号是否"匹配"
     */
    private static boolean isPiPei(String str) {
        boolean isPiPei = false;
        //先判断是否相等
        if (!isCountEqual(str)) {
            return false;
        }
        //定义栈记录左
        Stack<Character> stack = new Stack<>();
        char pop;
        char[] chs = str.toCharArray();
        fo:
        for (int i = 0; i < chs.length; i++) {
            switch (chs[i]) {
                case '(':
                    stack.add(chs[i]);// 放在前面
                    break;
                case ')':
                    pop = stack.pop();// 获取并移除
                    if (pop == '(') {
                        isPiPei = true;
                    } else {
                        isPiPei = false;
                        // 并停止所有
                        break fo;
                    }
                    break;
            }
        }
        return isPiPei;
    }
}