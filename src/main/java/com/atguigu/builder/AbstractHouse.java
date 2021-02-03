package com.atguigu.builder;

public abstract class AbstractHouse {
	
	//打地基
	public abstract void buildBasic();
	//砌墙
	public abstract void buildWalls();
	//盖顶
	public abstract void roofed();
	
	public void build() {
		buildBasic();
		buildWalls();
		roofed();
	}
	
}
