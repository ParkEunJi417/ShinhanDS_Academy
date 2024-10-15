package com.shinhan.day02;

import java.util.Scanner;

public class 연산자 {

	public static void main(String[] args) {
		//method4();
		//method5();
		//method6();
		//method7();
		method8();
		System.out.println("MAIN END");
	}

	private static void method8() {
		int a = 10;
		// 짝수인지, 홀수인지 판별. 2로 나눈 나머지가 0이면 짝수 아니면 홀수
		/*
		if(a%2==0) {
			System.out.printf("%d는 짝수 입니다.\n",a);
		}
		else {
			System.out.printf("%d는 홀수 입니다.",a);
		}
		*/

		// 간단한 조건문은 삼항연산자 이용
		System.out.printf("%d는 %s입니다.\n", a, a%2==0?"짝수":"홀수");
		
		String result = a%2==0?"짝수":"홀수";
		System.out.printf("%d는 %s입니다.\n", a, result);
	}

	private static void method7() {
		// String은 고정 문자열. 값을 바꾸면 새로운 주소에 객체가 생성
		// String에 literal을 직접 입력하면 컴파일시에 만들어짐.
		// ▶ 이미 있는 문자열은 다시 생성하지 않고 존재한 주소 사용
		/*
		String s1 = "자바";
		String s2 = "자바";
		s1 = s1 + "프로그램";
		s2 = s2 + "프로그램";
		*/
		
		// String에 new 생성시 만들어짐
		String s1 = new String("자바");
		String s2 = new String("자바");
		
		s1 = s1 + "프로그램";
		s2 = s2 + "프로그램";		
		
		// 기본형 타입은 값을 비교, 객체는 주소 비교
		System.out.println(s1 == s2); // 주소 비교
		System.out.println(s1.equals(s2)); // 값 비교
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
	}

	private static void method6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나눌수, 나누는 수 입력>>");
		
		int a = sc.nextInt();
		double b = sc.nextDouble();
		double result = 0;
		double result2 = 0;
		
		// 실수는 0.0으로 /,%면 오류는 아님! Infinite와 NaN으로 나올뿐
		if(!Double.isInfinite(a/b)) // 몫
			result = a/b;
		if(!Double.isNaN(a%b)) // 나머지
			result2 = a%b;
		
		System.out.println(result);
		System.out.println(result2);
		
		sc.close();
	}

	private static void method5() {
		//int a = 5, b = 0, result = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("나눌수, 나누는 수 입력>>");
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int result = 0;
		
		/*if(b!=0)
			result = a/b;*/
		try {
			result = a/b; // 오류발생 → 자바 가상머신이 Exception 객체를 생성해서 변수에 할당
		}catch(ArithmeticException ex) {
			// Exception 처리가 되면 프로그램은 정상적으로 진행. 처리 안하면 중지됨
			System.out.println(ex.getMessage());
		}
		
		System.out.println(result);
		System.out.println("Method5 END");
		
		sc.close();
	}

	private static void method4() {
		int a = 5, b = 0;
		// 개발시에 값을 할당하는 것이 아니므로 컴파일 오류 없음
		// 실행오류 발생:java.lang.ArithmeticException 연산오류, 정수는 0으로 나눌 수 없음
		// 프로그램 중지됨, 프로그램은 정상적으로 종료되어야함
		// JVM이 RuntimeException을 처리해줌. 개발자가 처리하지 않아도 됨
		// Exception 처리 : 오류 없도록 값 체크, Exception처리
		int result = 0;
		//if (b!=0) result = a/b;
		try {
			// Exception이 일어날 가능성이 있는 문장
			result = a/b;
		}catch(ArithmeticException ex) {
			// Exception처리
			System.out.println(ex.getMessage());
		}
		System.out.println(result);
		System.out.println("method4 End");
	}

}
