package com.atguigu.proxy.staticproxy;

//代理对象,静态代理
public class TeacherDaoProxy implements ITeacherDao{
	
	private ITeacherDao target; //目标对象，通过接口来聚合


	//构造器
	public TeacherDaoProxy(ITeacherDao target) {
		this.target = target;
	}



	@Override
	public void teach() {
		System.out.println("真实对象前的某些操作。。。。。 ");
		target.teach();
		System.out.println("真实对象后的某些操作。。。。。");
	}

}
