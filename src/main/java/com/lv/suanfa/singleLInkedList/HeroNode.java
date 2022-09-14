package com.lv.suanfa.singleLInkedList;

public class HeroNode {//用类来做节点，一个节点就做完了
    public int age;
    public String name;
    public String nickName;

    public HeroNode next;//使用类做指针，指向下一个

    @Override
    public String toString() {//为了显示方便重写toString方法
        return "HeroNode{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public HeroNode(){//一个无参构造

    }
    public HeroNode(int age, String name, String nickName){//一个构造器
        this.age = age;
        this.name = name;
        this.nickName = nickName;

    }
}
