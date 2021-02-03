package com.lv.tryCatchFinally;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: learnning
 * @description: 当返回的变量的类型是引用类型时，结果也是一样的 finally并不会改变返回的内容。
 * @author: Lv       finally语句在return语句执行之后”这个结论的
 * @create: 2020-05-22 09:52
 **/
public class tryDemo5 {
    public static Object show() {
        Object obj = new Object();
        try {
            return obj;
        }finally{
            System.out.println("finally模块被执行");
            obj = null;
        }
    }

    /**
     * 1、不管有木有出现异常，finally块中代码都会执行；
     * 2、当try和catch中有return时，finally仍然会执行；
     * 3、finally是在return后面的表达式运算后执行的（此时并没有返回运算后的值，而是先把要返回的值保存起来，管finally中的代码怎么样，返回的值都不会改变，任然是之前保存的值），所以函数返回值是在finally执行前确定的；
     * 4、finally中最好不要包含return，否则程序会提前退出，返回值不是try或catch中保存的返回值。
     *
     */

    //ThreadPoolExecutor
    public static void main(String args[]) {
        System.out.println(show());
    }
}
