package com.shinhan.day06.inheritence;

public class Child extends Parent {
	// 1.field 추가
	String myname="자바";
	
	// 3.상속 후 변경하기
	String a = "상속 후 변경하기";
	
	// Override
	public void f1() {
//		super.f1(); → 부모f1() 실행
		System.out.println("f1() → Override");
	}
	
	// 2.method 추가
	public void f2() {
		System.out.println("자식에서 정의한 함수 f2()");
		System.out.println("a="+a);
		f1();
		System.out.println(myname);
	}
}
