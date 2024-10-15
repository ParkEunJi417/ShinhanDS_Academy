package com.shinhan.day12;

import java.util.HashMap;

import lombok.AllArgsConstructor;

class Person{}
class Worker extends Person{}
class Student extends Person{}
class HighStudent extends Student{}
class MiddleStudent extends Student{}

@AllArgsConstructor
class Applicant<T>{
	T kind;
}

class Course{
	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println("registerCourse1가 등록됨(?를 공부:모두)");
	}
	
	public static void registerCourse2(Applicant<? extends Student> applicant) {
		System.out.println("registerCourse2가 등록됨(? extends를 공부:Student만 가능)");
	}
	
	public static void registerCourse3(Applicant<? super Worker> applicant) {
		System.out.println("registerCourse3가 등록됨(? super를 공부:Worker의 상위인 Person만 가능)");
	}
}

public class GenericTest {

	public static void main(String[] args) {
//		f1();
		f2();
	}

	private static void f2() {
		Person p = new Person();
		Student s = new Student();
		Worker w = new Worker();
		HighStudent h = new HighStudent();
		MiddleStudent m = new MiddleStudent();
		
		Applicant<Person> a1 = new Applicant<>(p);
		Applicant<Student> a2 = new Applicant<>(s);
		Applicant<Worker> a3 = new Applicant<>(w);
		Applicant<HighStudent> a4 = new Applicant<>(h);
		Applicant<MiddleStudent> a5 = new Applicant<>(m);
		
		Applicant<String> a6 = new Applicant<>("자바");
		Applicant<Integer> a7 = new Applicant<>(100);
		Applicant<Money> a8 = new Applicant<>(new Money(100));
		
		Course.registerCourse1(a1);
		Course.registerCourse1(a2);
		Course.registerCourse1(a3);
		Course.registerCourse1(a4);
		Course.registerCourse1(a5);
		
		Course.registerCourse1(a6);
		Course.registerCourse1(a7);
		Course.registerCourse1(a8);
		
//		Course.registerCourse2(a1); → Person은 불가
		Course.registerCourse2(a2);
//		Course.registerCourse2(a3); → Worker는 불가
		Course.registerCourse2(a4);
		Course.registerCourse2(a5);
		
		Course.registerCourse3(a1);
//		Course.registerCourse3(a2);
		Course.registerCourse3(a3);
//		Course.registerCourse3(a4);
//		Course.registerCourse3(a5);
	}

	private static void f1() {
		Box<Integer> data = new Box<>(100);
		System.out.println(data);
		
		Box<Money> data2 = new Box<>(new Money(1000));
		System.out.println(data2);
		
		HashMap<Money, String> map = new HashMap<>();
		map.put(new Money(10), "용돈");
		map.put(new Money(10), "저축");
		map.put(new Money(20), "선물");
		System.out.println(map);
		
		Box<String> a = makeBox("문자");
		Box<Integer> b = makeBox(100);
		System.out.println(a);
		System.out.println(b);
		
		boolean result1 = compare(10,20);
		System.out.println(result1);
	}
	
	// extends Number : 숫자로 제네릭을 제한함
	private static <T extends Number> boolean compare(T data1, T data2) {
		double a = data1.doubleValue();
		double b = data2.doubleValue();
		return a==b;
	}

	private static <T> Box<T> makeBox(T data) {
		return new Box<>(data);
	}

}
