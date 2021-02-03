package com.lv.test;

/**
 * @program: learnning
 * @description: 单向链表测试
 * @author: Lv
 * @create: 2020-08-07 09:50
 **/

//记住一个头结点，先初始化一个头结点，头节点不放数据，头结点不动；

public class SingleLinkedListTest {

}

class SingleLinkedList{
    private int value;
    private SingleLinkedList nextNode;

    //应该有个head的头节点，

    public void add(int value){
        SingleLinkedList nextTempNode = null;
        while (null != this.nextNode){
            nextTempNode = this.nextNode;
        }
        nextTempNode.value = value;
    }

}
