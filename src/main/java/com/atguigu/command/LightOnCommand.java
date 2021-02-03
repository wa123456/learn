package com.atguigu.command;

public class LightOnCommand implements Command {

	//将一个接受者对象与一个动作绑定，调用接受者相应的操作，实现execute
	//聚合LightReceiver

	LightReceiver light;

	//构造器
	public LightOnCommand(LightReceiver light) {
		super();
		this.light = light;
	}

	@Override
	public void execute() {
		//调用接收者的方法
		light.on();
	}



	@Override
	public void undo() {
		//调用接收者的方法
		light.off();
	}

}
