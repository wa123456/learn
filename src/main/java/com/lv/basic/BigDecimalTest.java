package com.lv.basic;

import java.math.BigDecimal;

public class BigDecimalTest {
    /**参考
     * https://blog.csdn.net/weixin_41797098/article/details/102898971
     * Java语言的浮点类型默认是double类型
     * 　由于Java浮点数使用二进制数据的科学计数法表示，所以可能不能精确表示一个浮点数。
     * 如果需要进行不产生误差的精确数字计算，需要使用BigDecimal类。
     *
     *  https://blog.csdn.net/qq_35868412/article/details/89029288
     *
     * ：浮点类型float，double的数据不适合在不容许舍入误差的金融计算领域。如果需要进行不产生舍入误差的精确数字计算，需要使用BigDecimal类。
     *  3.14/0 Infinity
     */

    public static void main(String[] args) {
        float a = 3.14f;

        float f = 0.1f;

        double d = 1.0/10;

        System.out.println(f==d);

        float d1 = 423432423f;

        float d2 = d1+1;

        if(d1==d2){
            //输出结果为 d1==d2
            System.out.println("d1==d2");

        }else{
            System.out.println("d1!=d2");
        }


        System.out.println("********************");
        System.out.println(0.3-0.1);

        BigDecimal doubleStr = new BigDecimal(1.11111111);
        System.out.println(doubleStr);

    }



}
