package com.shinhan.day06.inheritence;

// final
// 1)field : 값 할당 후 변경 불가
// 2)method : Override(재정의) 불가
// 3)class : 상속 불가 

public class Parent {
	// 1.field
	int a = 100;

	// 2.method
	void f1() {
		System.out.println("부모가 정의한 함수 f1()");
	}
}
