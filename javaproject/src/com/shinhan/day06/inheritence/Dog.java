package com.shinhan.day06.inheritence;

// 자식은 (하나) 부모의 정보를 알 수 있음

public class Dog extends Animal {
	public Dog(){
		super();
		System.out.println("2.Dog 생성됨");
	}
	
	@Override
	void sing() {
		System.out.println("Dog → 멍멍");
	}
	
	@Override
	void fly() {
		System.out.println("Dog → 날 수 없음");
	}
}
