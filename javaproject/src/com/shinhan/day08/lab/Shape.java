package com.shinhan.day08.lab;

// abstract class : 추상메서드가 0개 이상
public abstract class Shape {
	// 1.field
	int numSides; // 변의 수

	// 2.생성자
	public Shape(int numSides) {
		this.numSides = numSides;
	}

	// 3.일반메서드
	int getNumSides() {
		return numSides;
	}

	// 추상메서드 : 정의 있고 구현 없음
	abstract double getArea(); // 넓이

	abstract double getPerimeter(); // 둘레 길이
}
