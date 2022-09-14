package com.lv.completableFuture;

import java.util.Date;
import java.util.concurrent.Callable;

public class ThreadCallBack implements Callable {
 
    private static Callable callable;
    public static synchronized Callable getInstance(){
        if(callable == null){
            callable = new ThreadCallBack();
        }
        return callable;
    }
 
    @Override
    public Object call() throws Exception {
        for (int i=0;i<3;i++){
            System.out.println((new Date()).toLocaleString() + "   " + Thread.currentThread().getName() + "执行ing");
        }
//        Thread.sleep(2000);
        return "return true";
    }
 
}