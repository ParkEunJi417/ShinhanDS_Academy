package com.shinhan.day09.inner;

public class A {
	// instance inner class(인스턴스 멤버 클래스)
	class B{
		// 1.field
		int field1=1;
		static int field2=2;
		
		// 2.constructor
		B(){
			System.out.println("B 생성자 실행");
		}
		
		// 3.method
		void method1() {
			System.out.println("B method1 실행");
		}
		
		static void method2() {
			System.out.println("B method2 실행");
		}
	}
	
	void useB() {
		// A class내의 B class 사용하기
		// 1)instance 사용
		B b = new B();
		System.out.println(b.field1);
		b.method1();
		
		// 2)static 사용
		System.out.println(B.field2);
		B.method2();
	}
}
