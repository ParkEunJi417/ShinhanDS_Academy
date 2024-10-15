package com.shinhan.day09.inner;

public class A2 {
	// 1.field
	B field1 = new B();

	// 2.생성자
	A2() {
		System.out.println(B.field2);
		B.method2();
		B field2 = new B();
		System.out.println(field2.field);
		field2.method1();
	}

	// 3.instance method
	void method1() {
		B field3 = new B();
	}

	// 4.static method
	static void method2() {
		System.out.println(B.field2);
		B.method2();
		B field4 = new B();
	}

	void useB() {
		// A class내의 B class 사용하기
		// 1)instance 사용
		B b = new B();
		System.out.println(b.field);
		b.method1();

		// 2)static 사용
		System.out.println(B.field2);
		B.method2();
	}

	static class B {
		// 1.field
		int field = 1;
		static int field2 = 2;

		// 2.constructor
		B() {
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
}
