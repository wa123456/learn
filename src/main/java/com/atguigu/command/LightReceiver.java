package com.atguigu.command;

public class LightReceiver {
	//接受者角色，知道如何实施和执行一个请求相关的操作
	public void on() {
		System.out.println(" 电灯打开了.. ");
	}

	public void off() {
		System.out.println(" 电灯关闭了.. ");
	}
}
