package com.shinhan.day04;

// class : 설계도, 구성요소로는 field+method
// object : 실체(instance), class를 이용해서 생성(new)
public class Person {

	// 5가지만 사용 가능 → 문장 불가
	// 1.field : 속성, 변수 선언, object들의 공통 특성
	String name;
	int age;
	
	// 2.constructor(생성자) : - new를 수행시 자동으로 호출되는 함수
	// 						  - 정의하지 않으면 컴파일시에 자동으로 만들어짐
	// class이름과 같음. return을 가질 수 없음
	public Person(){
		System.out.println("「수행순서:3번");
		System.out.println("Person class의 생성자이다. new시 마다 실행」");
	}
	
	public Person(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	void useCalculator() {
		// 객체 참조 변수 선언 + 객체 생성
		Calculator cal = new Calculator();
		cal.model="ABC모델";
		cal.color="black";
		cal.price=20000;
		
		cal.print();
		System.out.println(cal.plus(10, 20));
		System.out.println(cal.minus(20, 10));
	}
	
	// 3.method : 문장들의 묶음
	// 			  함수는 반드시 return 타입을 정의해야함
	void study(){
		System.out.println("「수행순서:함수 호출시 수행");
		System.out.println(name+" 공부한다.」");
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	// 4.block
	{
		System.out.println("「수행순서:2번");
		System.out.println("object block:객체 생성시마다 실행」");
	}
	static {
		System.out.println("「수행순서:1번");
		System.out.println("static block:class가 load시 1번만 실행」");
	}
	
	// 5.inner class
	class InnerClass{
		
	}
}
