package com.lv.suanfa.singleLInkedList;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLInkedList singleLInkedList = new SingleLInkedList();


        singleLInkedList.add(new HeroNode(1,"tom","tomNick"));
        singleLInkedList.add(new HeroNode(2,"tom2","tomNick2"));

        singleLInkedList.add(new HeroNode(4,"tom4","tomNick4"));

        singleLInkedList.insert(new HeroNode(3,"tom3","tomNick3"));
        //singleLInkedList.delete(1);

        singleLInkedList.show();
    }
}
