package com.lv;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class test1 {
    public static void main(String args[]) {
        //System.out.println("Hello World!");

        /*
        TestRunnable mTestRunnable = new TestRunnable();
        Thread mThread = new Thread(mTestRunnable);
        mThread.start();
        */

        MyTestCallable mMyTestCallable= new MyTestCallable();
        ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
        Future mfuture = mExecutorService.submit(mMyTestCallable);
        try {
        //等待线程结束，并返回结果
            System.out.println(mfuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class TestRunnable implements Runnable {
    //    public void run() throws Exception {
    public void run() {
        System.out.println("Hello World");
    }
}


class MyTestCallable implements Callable {
  public String call() throws Exception {
      return "Hello World";
  }
}
