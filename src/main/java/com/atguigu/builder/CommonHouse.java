package com.atguigu.builder;

public class CommonHouse extends AbstractHouse {

	@Override
	public void buildBasic() {
		System.out.println("普通盖房打地基");
	}

	@Override
	public void buildWalls() {
		System.out.println("普通盖房砌墙");
	}

	@Override
	public void roofed() {
		System.out.println("普通盖房盖顶");
	}

}
