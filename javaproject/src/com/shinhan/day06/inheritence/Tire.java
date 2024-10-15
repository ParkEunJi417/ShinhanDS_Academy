package com.shinhan.day06.inheritence;

// 객체지향프로그램 : 정보은닉(캡슐화, private), 상속성(물려받고 수정 가능, 추가가능),
//				  다형성(사용법은 같으나 결과가 다름)

// 규격, 틀 template, 부모class
public class Tire {
	public String color;
	
	public void roll() {
		System.out.println("타이어가 굴러갑니다.");
	}
}
