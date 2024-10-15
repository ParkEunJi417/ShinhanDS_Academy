package com.shinhan.day01;

/*
 	1.정수 : byte, short, int, long
 	2.실수 : float, double
 	3.논리 : boolean  
*/

public class 변수타입 {
	public static void main(String[] args) {
		System.out.println("main시작");
		//f1(); // byte
		//f2(); // short
		//f3(); // char
		//f4(); // int
		//f5(); // long
		//f6(); // float, double
		f7(); //boolean
		System.out.println("main끝");
	}

	// 자바의 예약어는 소문자
	private static void f7() {
		// 1.변수선언
		boolean flag;
		int a=10, b=20;
		// 2.변수에 값 할당
		//flag = true;
		flag = a>b; // 조건문으로 사용
		flag = a==b;
		// && : 모두 참이면 참, 앞의 값이 거짓이면 뒤의 문장은 무시
		flag = a>=10 && ++b>=20;
		// || : 하나라도 참이면 참, 앞의 결과가 참이면 뒤의 문장을 무시
		flag = a<10 || ++b>=20;
		// 3.변수사용 → 초기화하지 않은 변수는 사용 불가
		System.out.println(flag);
		System.out.println("b="+b);
	}

	private static void f6() {
		// 실수 : 소숫점이 있음
		// float(4byte), double(8byte)
		// 실수의 literal(값) : 기본타입은 double
		// 실수는 정수부, 가수부 나누어 저장
		// 저장 방식이 다르므로 int, long보다 범위가 큼
		float data = 3.14f;
		double data2 = 3.14;
		double data3 = 3;
		float data4 = 3;	
		System.out.println("float="+data);
		System.out.println("double="+data2);
		System.out.println("double="+data3);
		System.out.println("float="+data4);
	}

	private static void f5() {
		// long(8byte)
		// 기본형타입long + 기능추가 → Long Wrapper class
		// literal(값) : 기본타입은 int
		
		long score = 2147483648L; //마지막에 L or l을 붙임
		score = score + 1;
		score += 1;
		score++;
		System.out.println("score=" + score);
	}

	private static void f4() {
		// int(4byte) : -2147483648~2147483647
		// 기본형타입int + 기능추가 → Integer Wrapper class
		// literal(값) : 기본타입은 int
		
		int score = Integer.MAX_VALUE;
		score = score + 1;
		score += 1;
		score++;
		System.out.println("score=" + score);
	}

	private static void f3() {
		// char(2byte) : 단일문자, 0~65535
		char grade = 'A'; // 빈문자불가
		grade = 44032;
		grade = 65;
		grade = 97;
		grade = 0x0041;
		grade++;
		System.out.println("grade=" + grade);
	}

	private static void f2() {
		// 변수의 범위 : 함수내의 변수는 외부에서 접근불가, 함수종료시 제거됨
		// short(2byte) : -32768~32767
		// 1.변수선언 및 할당
		short score = Short.MAX_VALUE;
		score++;
		++score;
		// 복합대입연산자 += : 자동 형변환하여 진행
		score += 2;
		System.out.println("Short=" + score);
	}

	private static void f1() {
		System.out.println("--byte--");
		// 1.변수선언
		byte score; // -128~127
		// 2.변수값 할당 : 메모리에 저장한다.
		score = 127;
		score++;
		// score = score + 1; byte에 int를 더할 수 없음
		// 3.변수사용
		System.out.println("score=" + score); // 문자+숫자→문자
	}
}
