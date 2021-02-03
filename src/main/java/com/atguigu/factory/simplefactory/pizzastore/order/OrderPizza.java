package com.atguigu.factory.simplefactory.pizzastore.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import atguigu.factory.simplefactory.pizzastore.pizza.CheesePizza;
import atguigu.factory.simplefactory.pizzastore.pizza.GreekPizza;
import atguigu.factory.simplefactory.pizzastore.pizza.PepperPizza;
import atguigu.factory.simplefactory.pizzastore.pizza.Pizza;


/** Pizza类 准备原材料（抽象）烘烤、切、打包等方法
 * 具体CheesePizza类，实现了具体的准备原材料方法 ，其余
 * //准备原材料, 不同的披萨不一样，因此，我们做成抽象方法
 *
 * 简单工厂模式只是根据类型来生产不同类型pizza的逻辑抽取出来了，不放在OrderPizza中了
 *
 * 总结： 简单工厂模式最大的优点在于工厂类中包含了必要的逻辑判断，根据客户端的选择条件动态实例化相关的类，
 * 对于客户端来说，去除了与具体产品的依赖。
 * 但是当需求变动的时候，需要对原有的类进行修改，违背了开放封闭原则。
 */
public class OrderPizza {
	//构造器
	public OrderPizza(SimpleFactory simpleFactory) {
		setFactory(simpleFactory);
	}
	//定义一个简单工厂对象
	SimpleFactory simpleFactory;
	Pizza pizza = null;



	public void setFactory(SimpleFactory simpleFactory) {
		String orderType = ""; //用户输入的
		this.simpleFactory = simpleFactory; //设置简单工厂对象

		do {
			orderType = getType();
			pizza = this.simpleFactory.createPizza(orderType);
			//输出pizza
			if(pizza != null) { //订购成功
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
			} else {
				System.out.println(" 订购披萨失败 ");
				break;
			}
		}while(true);
	}

	// 写一个方法，可以获取客户希望订购的披萨种类
	private String getType() {
		try {
			BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("input pizza 种类:");
			String str = strin.readLine();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	// 构造器
	/*
	public OrderPizza() {
		Pizza pizza = null;
		String orderType; // 订购披萨的类型
		do {
			orderType = getType();
			if (orderType.equals("greek")) {
				pizza = new GreekPizza();
				pizza.setName(" 希腊披萨 ");
			} else if (orderType.equals("cheese")) {
				pizza = new CheesePizza();
				pizza.setName(" 奶酪披萨 ");
			} else if (orderType.equals("pepper")) {
				pizza = new PepperPizza();
				pizza.setName("胡椒披萨");
			} else {
				break;
			}
			//输出pizza 制作过程
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();

		} while (true);
	}
	*/



}
