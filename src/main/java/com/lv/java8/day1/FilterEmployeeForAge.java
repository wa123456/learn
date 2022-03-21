package com.lv.java8.day1;

import com.lv.java8.day1.MyPredicate;

public class FilterEmployeeForAge implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getAge() <= 35;
	}

}
