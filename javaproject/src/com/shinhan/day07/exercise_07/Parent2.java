package com.shinhan.day07.exercise_07;

public class Parent2 {
	public String nation;

	public Parent2() {
		this("대한민국"); // 다른 모양의 자신의 생성자를 호출
		System.out.println("Parent() call");
	}

	public Parent2(String nation) {
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
}
