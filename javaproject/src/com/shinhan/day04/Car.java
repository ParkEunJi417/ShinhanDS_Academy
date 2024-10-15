package com.shinhan.day04;
/*
자동차(Car) class 정의
특징 : model, color, price
기능 : go(), back(), stop()
*/

// class : 틀, 설계도, template, object들의 공통 특성을 정의
public class Car {
	// 1.field(변수) : 생성시 field가 자동 초기화, 멤버변수
	String model, color;
	int price;
	
	// 2.생성자 메서드 → 생략가능, 정의하지 않으면 컴파일러가 자동으로 만들어줌
	// 정의가 있으면 자동으로 만들어주지 않음
	// 생성자의 오버로딩
	// 오버로딩 : 이름은 같으나 매개변수가 다름
	// 값을 초기화 하는 것이 목적
	public Car() {
		this(null,null,0);
		System.out.println("Car의 default생성자:매개변수 없음");
	}
	
	// 매개변수 이름과 field이름이 충돌 발생
	// 구분하기 위해 현재 객체를 this 사용
	// 생성자가 여러개인 경우 하나의 생성자가 다른 생성자를 호출 → this()
	public Car(String model, String color, int price) {
		System.out.println("---Car가 생성됨---");
		this.model=model;
		this.color=color;
		this.price=price;
	}
	
	public Car(String model, String color) {
		this(model,color,0);
		//this.model=model;
		//this.color=color;
	}
	
	public Car(String model) {
		this(model,null,0);
		//this.model=model;
	}

	// 3.일반 메서드(기능) → 반드시 return 필요
	void go() {
		System.out.println("직진");
	}
	
	void back() {
		System.out.println("후진");
	}
	
	void stop() {
		System.out.println("멈춤");
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", color=" + color + ", price=" + price + "]";
	}
		
	// 4.block : instance(object) block, static block
//	{
//		System.out.println("instance block-생성시마다 수행");
//	}
//	static {
//		System.out.println("static block 수행");
//	}
	// 5.Inner Class
}
