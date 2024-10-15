package com.shinhan.day07;

// 자바의 최상위 class : Object
public class Parent extends Object {
	int a=10;
	
	Parent(){
		System.out.println("부모의 생성자");
	}
	
	void method1() {
		System.out.println("부모의 method1()");
	}
}
