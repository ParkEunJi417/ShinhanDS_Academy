package com.shinhan.day07.exercise_07;

public class Child extends Parent {
	public int studentNo;

	public Child(String name, int studentNo) {
		
		// 해결2)명시적으로 부모의 생성자 호출
		super(name);
//		this.name = name;
		
		this.studentNo = studentNo;
	}
}
