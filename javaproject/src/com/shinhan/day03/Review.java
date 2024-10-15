package com.shinhan.day03;

// JVM
// cmd>java Review
// class load
public class Review {

	public static void main(String[] args) {
		//ex3_1();
		//ex3_2();
		//ex3_3();
		//ex3_4();
		//ex3_5();
		//ex3_6();
		ex3_7();
		System.out.println("-----END-----");
	}
	public static void ex3_7() {
		/* 추가 예제
		int a=10, b=0;
		if(b!=0)
			System.out.println(a/b);
		else
			System.out.println("정수는 0으로 나눌 수 없음");
		*/
		
		double x = 5.0;
		double y = 0.0;
		double z = 5 % y;
		if ( Double.isNaN(z) ) {
			System.out.println("0.0으로 나눌 수 없습니다.");
		} else {
			double result = z + 10;
			System.out.println("결과: " + result);
		}
	}
	public static void ex3_6() {
		int x = 10;
		int y = 5;
		
		System.out.println( (x>7) && (y<= 5) );
		System.out.println( (x%3 == 2) || (y%2 != 1) );
	}
	
	public static void ex3_5() {
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthTop+lengthBottom) * height / 2.0;
		System.out.println(area);
		
		/* 정답 1,2,3										  실행값
		1. (lengthTop+lengthBottom) * height / 2.0			▶ 52.5
		2. (lengthTop+lengthBottom) * height * 1.0 / 2		▶ 52.5
		3. (double)(lengthTop+lengthBottom) * height / 2	▶ 52.5
		4. (double)( (lengthTop+lengthBottom) * height / 2)	▶ 52.0 
		*/
	}
	
	public static void ex3_4() {
		int value = 356;
		System.out.println(value/100*100); // 정답
	}
		
	public static void ex3_3() {
		int pencils = 534;
		int students = 30;
		//학생 한 명이 가지는 연필 수
		int pencilsPerStudent = pencils/students; // 정답1
		System.out.println(pencilsPerStudent);
		//남은 연필 수
		int pencilsLeft = pencils%students; // 정답2
		System.out.println(pencilsLeft);
	}
	
	public static void ex3_2() {
		int score = 85;
		String result = !(score>90)?"가":"나";
		System.out.println(result);
	}
	
	// 함수이름(){}
	public static void ex3_1() {
		int x = 10;
		int y = 20;
		int z = (++x) + (y--); // 증감연산자 우선순위때문에 괄호 없어도 값 동일
		
		System.out.println(z);
		System.out.println(x);
		System.out.println(y);
	}
}
