package com.lv.java8.learn;



import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

public class TestLambda1 {

	//原来的匿名内部类,
	//TODO 是否要求函数式接口只有一个方法？回答：不包括equals，等方法

	
	//现在的 Lambda 表达式

	
	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99),
			new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "王五", 8, 7777.77),
			new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "李xi", 8, 7777.77),


            new Employee(105, "田七", 38, 5555.55)
	);



	@Test
    public void test(){
        //emps.stream().map(employee -> {return  employee.getName();}).forEach(str -> System.out.println(str));
        //emps.stream().map(Employee::getName).forEach(System.out::println);

        Optional<Double> reduce = emps.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce.get());

    }
    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }




	@Test
	public void Test1(){
		/*List<Employee> employees = filterEmployee(emps, (employee)->{
			return employee.getSalary() > 5000;
		});


		for (Employee employee : employees) {
			System.out.println(employee);
		}*/

	}

    public List<Employee> filterEmployee(List<Employee> listEmployee,Mypreidict<Employee> mp){
        List<Employee> list = new ArrayList<>();

        for (Employee employee : listEmployee) {
            if (mp.test(employee)){
                list.add(employee);
            }

        }
        return list;
    }



	//优化方式一：策略设计模式




	/**需求：获取公司中年龄小于 35 的员工信息
	 * @param emps
	 * @return
	 */
	public List<Employee> filterEmployeeAge(List<Employee> emps){
		List<Employee> list = new ArrayList<>();

		for (Employee emp : emps) {
			if(emp.getAge() <= 35){
				list.add(emp);
			}
		}

		return list;
	}






	

}
