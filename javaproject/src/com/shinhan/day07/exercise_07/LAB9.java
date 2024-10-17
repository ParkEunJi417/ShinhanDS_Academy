package com.shinhan.day07.exercise_07;

class A { }
class B extends A { }
class C extends A { }
class D extends B {
	String subject="java";
}
class E extends B { }
class F extends C { }

public class LAB9 {
	public static void main(String[] args) {
		// 자식의 instance를 부모의 class 타입에 넣을 수 있음
		// 부모 = 자식
		D v1 = new D();
		A v2 = new D();
		B v3 = new D();

		System.out.println(v1.subject);
		
		// 변수는 타입을 따름
//		System.out.println(v2.subject);
//		System.out.println(v3.subject);
		
		// 강제 형 변환 : instance 타입으로 강제 형변환 가능
		D v4 = (D)v2;
		System.out.println(v4.subject);
		D v5 = (D)v3;
		System.out.println(v5.subject);
		
		if(v3 instanceof E) {
			E v6 = (E)v3;
		}
	}
}
