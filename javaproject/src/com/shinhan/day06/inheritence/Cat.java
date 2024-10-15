package com.shinhan.day06.inheritence;

public class Cat extends Animal{
	public Cat(){
		super();
		System.out.println("2.Cat 생성됨");
	}
	
	@Override
	void sing() {
		System.out.println("Cat → 야옹");
	}
	
	@Override
	void fly() {
		System.out.println("Cat → 날 수 없음");
	}
	
	void play() {
		System.out.println("Cat → 혼자놀기");
	}
}
