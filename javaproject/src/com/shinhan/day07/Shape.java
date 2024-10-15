package com.shinhan.day07;

// abstract class : 추상메서드가 하나 이상 존재함
// abstract method : 함수의 정의는 있으나 구현은 없음, 자식이 반드시 구현함
public abstract class Shape {

	private String color;
	private String type;

	public Shape() {
	}

	public Shape(String color, String type) {
		this.color = color;
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public String getType() {
		return type;
	}

	// abstract(추상)
	// 부모의 메서드는 있지만 ( 부모를 통해 자식의 기능을 수행하기 위해 존재)
	// field 값을 가지고 있지 않아서 구현 불가
	// 부모는 정의하고 자식이 구현하도록 함
	public abstract double calculateArea();

	public abstract double calculatePerimeter();

	public String toString() {
		return color + " " + type;
	}
}