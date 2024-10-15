package com.shinhan.day06.inheritence;

// 부모는 자식의 정보를 가지고 있지 않음

public class Animal {
	public Animal(){
		System.out.println("1.Animal 생성됨");
	}
	void sing() {
		System.out.println("부모 → 동물은 소리를 낸다.");
	}
	
	void fly() {
		System.out.println("부모 → 동물은 날 수 있다.");
	}
}
