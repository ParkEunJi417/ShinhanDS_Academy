package com.shinhan.day04;

public class PersonTest {

	public static void main(String[] args) {
		//f1();
		//f2();
		//f3();
		f4();
	}

	private static void f4() {
		Car c = new Car();
		
	}

	private static void f3() {
		Person p1 = new Person();
		p1.useCalculator();
	}

	private static void f2() {
		// 1.객체 참조 변수 선언
		Person p1, p2;
		
		// 2.객체 생성
		p1 = new Person();
		p2 = new Person();
		
		// 3.객체 참조 변수 사용
		p2.name="박은지";
		p2.age=27;
		
		System.out.println(p1);
		System.out.println(p1.name);
		System.out.println(p1.age);
		p1.study();
		
		System.out.println("-------------");

		System.out.println(p2);
		System.out.println(p2.name);
		System.out.println(p2.age);
		p2.study();
	}

	private static void f1() {
		// 기본형 타입 사용
		int a;
		a = 10;
		System.out.println(a);
		
		// 참조형
		// 1.객체 참조 변수 선언
		String s1;
		
		// 2.객체 생성
		s1 = new String("자바");
		
		// 3.객체 참조 변수 사용
		System.out.println(s1);		
	}

}
