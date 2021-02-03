package com.atguigu.factory.originpizzastore.order;

import atguigu.factory.originpizzastore.pizza.GreekPizza;
import atguigu.factory.originpizzastore.pizza.PepperPizza;
import atguigu.factory.originpizzastore.pizza.CheesePizza;
import atguigu.factory.originpizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//准备原材料, 不同的披萨不一样，因此，我们做成抽象方法
/** Pizza类 准备原材料（抽象）烘烤、切、打包等方法
 * 具体CheesePizza类，实现了具体的准备原材料方法 ，其余
 * OrderPizza，在构造方法中通过不同类型的orderType生成不同的pizza，
 * 如果新加Pizza类，则需要修改OrderPizza类及新增新类型的Pizza
 */
public class OrderPizza {

	// 构造器
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
	/*
	//定义一个简单工厂对象
	SimpleFactory simpleFactory;
	Pizza pizza = null;

	//构造器
	public OrderPizza(SimpleFactory simpleFactory) {
		setFactory(simpleFactory);
	}

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
	*/
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

}
