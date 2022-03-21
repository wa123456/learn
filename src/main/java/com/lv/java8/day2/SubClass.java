package com.lv.java8.day2;

import com.lv.java8.day2.MyInterface;

public class SubClass /*extends MyClass*/ implements MyFun, MyInterface {

	@Override
	public String getName() {
		return MyInterface.super.getName();
	}

}
