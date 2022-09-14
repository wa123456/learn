package com.zhouyang.three.lockSupport;

/**
 *  1、lock.wait()是Object对象的方法
 *  2、lock.wait、notify必须在 synchronized体内；
 *  3、必须先wait 然后再 notify
 *
 */
public class WaitNotifyDemo {

	static Object lock = new Object();
	
	public static void main(String[] args) {
		new Thread(()->{
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName()+" come in.");
				try {
					lock.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+" 换醒.");
		}, "Thread A").start();
		
		new Thread(()->{
			synchronized (lock) {
				lock.notify();
				System.out.println(Thread.currentThread().getName()+" 通知.");
			}
		}, "Thread B").start();
	}
}
