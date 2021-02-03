package com.lv.exception;

/**
 * @program: learnning
 * @description: try, catch,finally ,return 执行顺序
 * 注：当异常处理的代码执行结束以后，是不会回到try语句去执行尚未执行的代码
 * @author: Lv
 * @create: 2020-05-19 17:20
 **/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestException {
    public static void main(String[] args) {
        String str = new TestException().openFile();
        System.out.println(str);

    }

    String openFile() {
        try {
            System.out.println("aaa");
            FileInputStream fis = new FileInputStream("d:/a.txt");
            int a = fis.read();
            System.out.println("bbb");
            return "step1";
        } catch (FileNotFoundException e) {
            System.out.println("catching !!!!!");
            e.printStackTrace();
            return "step2";// 先确定返回值，并不会直接结束运行。
        } catch (IOException e) {
            e.printStackTrace();
            return "step3";
        } finally {
            System.out.println("finally !!!!!");
            // return "fff";不要在finally中使用return.
        }
    }
}
