package com.lv.suanfa.singleLInkedList;

/**
 * 单链表，找到头节点（空节点），然后往下遍历即可；
 */
public class SingleLInkedList {
   private HeroNode headNode = new HeroNode();


    SingleLInkedList(){

    }

    //空节点
    public HeroNode getHeadNode(){
        return headNode;
    }



    //增加，在队尾
    public void add(HeroNode heroNode){
        HeroNode temp = headNode;
        while (true){
            if(temp.next == null){
                break;
            }else {
                temp.next.next = temp;
            }

        }
        temp.next = heroNode;
    }

    //显示
    public void show(){
        HeroNode temp = headNode;
        if(null == temp.next){
            System.out.println("链表为空");
            return;
        }
        while (temp.next != null){

            temp = temp.next;
            System.out.println(temp);

        }
    }
    //插入,按照年龄从小到大插入
    public void insert(HeroNode insertNode){
        HeroNode temp = headNode;
        if( null == temp.next ){
            temp.next = insertNode;
            return;
        }
        while (temp.next != null){
           if(temp.next.age >  insertNode.age) {
               HeroNode saveNode = temp.next;
               temp.next = insertNode;
               insertNode.next = saveNode;
               break;
           }else {
               temp = temp.next;
           }
        }
    }

    //删除
    public void delete(int age){
        HeroNode temp = headNode;
        if( null == temp.next ){
            return;
        }
        while (temp.next != null){
            if(temp.next.age ==  age) {
                //HeroNode saveNode = temp.next;
                temp.next = temp.next.next;
                break;
            }else {
                temp = temp.next;
            }
        }

    }

    //链表翻转

    //环形链表
    public void reverse(){
        HeroNode firstNode = headNode.next;
        HeroNode current = headNode.next;
        //HeroNode temp = headNode;
        while (current.next != null){
            HeroNode tempNext = current.next;

            HeroNode temp = current;
            if(firstNode == current){
                temp.next = null;
            }else {
                tempNext.next = temp;
            }


            current = tempNext;
        }

    }






}
