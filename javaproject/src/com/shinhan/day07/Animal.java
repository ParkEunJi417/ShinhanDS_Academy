package com.shinhan.day07;

// abstract class : - abstract method가 있음을 의미
//					- 직접 생성 불가
public abstract class Animal {
	private String name;
	private int size;
	
	Animal(){
		
	}
	
	Animal(String name, int size){
		this.name=name;
		this.size=size;
	}
	
	// 추상메소드 : 자식이 구현
	abstract void sound();
	
	// 일반메소드 : 내가 직접 구현
	void f1() {
		
	}
}
