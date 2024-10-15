package com.shinhan.day06;

//public class Printer {
//	public static void println(int value) {
//		System.out.println(value);
//	}
//	public static void println(boolean value) {
//		System.out.println(value);
//	}
//	public static void println(double value) {
//		System.out.println(value);
//	}
//	public static void println(String value) {
//		System.out.println(value);
//	}
//}

 // 6강 16번 문제
 // 메서드 : 행위, 기능, 필수구성요소는 ReturnType 함수이름(){}
 // 구현됨 {}
 // non-static : instance 메서드, 객체 생성 후 호출 가능
 // static : class 메서드, 객체 생성 불필요

public class Printer {
	public void println(int value) {
		System.out.println(value);
	}
	public void println(boolean value) {
		System.out.println(value);
	}
	public void println(double value) {
		System.out.println(value);
	}
	public void println(String value) {
		System.out.println(value);
	}
	
	static void println2(int value) {
		System.out.println(value);
	}
	static void println2(boolean value) {
		System.out.println(value);
	}

}
