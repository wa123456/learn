package com.lv.testThis;

/**
 * @program: learnning
 * @description:
 * @author: Lv
 * @create: 2020-04-22 16:09
 **/

public class Student {
    String name;
    int id;
    public  Student(String name,int id){
        this(name);   //通过this调用其他构造方法，必须位于第一句！ Constructor call must be the first statement in a constructor
        this.name = name;
        this.id = id;
    }

    public Student(String name){
        this.name = name;
    }
    public Student(){
        System.out.println("构造一个对象");
    }

    public void setName(String name){
        this.name = name;
    }

}
