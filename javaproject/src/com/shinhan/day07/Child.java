package com.shinhan.day07;

public class Child extends Parent {
	boolean a = true;
	String b= "자바.. child";
	
	Child(){
		System.out.println("자식의 생성자");
	}
	
	// override(덮어쓰기) : - 이름 같고 매개변수 같고 returnType 같음
	//					  - 접근 제한자(Modifier)는 크거나 같아야함
	void method1() {
		System.out.println("자식의 method1()");
	}
	
	// overloading(추가) : 이름 같고 매개변수 다름
	void method1(String s) {
		System.out.println("자식의 method1()");
	}
	
	void method2() {
		method1(); // 자식은 부모의 메서드 사용 가능
		System.out.println(a+b); // 자식은 부모의 field 사용 가능
	}
	
}
