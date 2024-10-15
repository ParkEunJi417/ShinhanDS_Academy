package com.shinhan.day05;

// static은 컴파일전에 이미 생성

public class Car {
	// field(변수) : instance 변수(멤버변수), static 변수
	// 1)instance 변수
	int gas;
	private int speed;
	
	// 2)static 변수(class 변수) : 객체 생성 없이 사용 가능, C언어의 Share변수와 같음
	static String company="현대자동차";
	
	// method
	// 1)static method : non-static 사용불가
	static void print() {
		System.out.println("static method:"+company);
	}
	
	// 2)instance method : static 사용 가능
	void setSpeed(int speed) {
		System.out.println("---method이용---"+company);
		this.speed=speed;
	}
	
	int getSpeed() {
//		return this.speed; 이렇게 쓰는거와 동일
		return speed;
	}
	
	// block
	{
		System.out.println("instance block..객체 생성시마다 실행");
	}
	static{
		System.out.println("static block..최초 load시 실행");
	}
}
