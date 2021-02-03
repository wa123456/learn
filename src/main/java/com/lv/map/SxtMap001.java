package com.lv.map;

import java.util.HashMap;

public class SxtMap001 {
    public static void main(String[] args) {

    }
    SxtEntry [] sxtEntries = new SxtEntry[990];



    public void put(Object key,Object value){
        //f
        SxtEntry sxtEntry = new SxtEntry(key,value);
        for (int i = 0; i < sxtEntries.length ; i++) {
            sxtEntries[i] = sxtEntry;
        }

    }

}

class SxtEntry{
    public SxtEntry(){
        super();
    }

    public SxtEntry(Object key,Object value){
        this.key = key;
        this.value = value;
    }

    Object key;
    Object value;



}

