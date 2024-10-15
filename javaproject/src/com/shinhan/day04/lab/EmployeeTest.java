package com.shinhan.day04.lab;

import com.shinhan.day04.Car;
import com.shinhan.day04.Person;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee emp = new Employee("123","홍길동",1000);
		
		// 주소출력 : 패키지이름.class이름@hashcode
		System.out.println(emp.getSalary(0.1));
		System.out.println(emp);
		System.out.println(emp.toString());
		
		Car car1 = new Car("A","green",1000);
		System.out.println(car1);
		
		Person p1 = new Person("홍길동",20);
		System.out.println(p1);
	}

}
