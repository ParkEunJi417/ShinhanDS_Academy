package com.shinhan.day02_teacher;

import java.util.Scanner;

public class 연산자 {

	public static void main(String[] args) {
		method9();
		System.out.println("MAIN END~~~~");
	}

	private static void method9() {
		int a=12;
		//짝수인지, 홀수인지 판별..2로 나눈나머지가 0이면 짝수 아니면 홀수 
		if(a%2==0) {
			System.out.printf("%d는 짝수입니다.\n", a);
		}else {
			System.out.printf("%d는 홀수입니다.\n", a);
		}
		//간단한 조건문은 3항연산자를 이용하자~
		System.out.printf("%d는 %s입니다.\n",a, a%2==0?"짝수":"홀수");
		
		String result = a%2==0?"짝수":"홀수";
		System.out.printf("%d는 %s입니다.\n",a,result);
	}

	private static void method8() {
		//String은 고정문자열이다. 값을 바꾸면 새로운 주소에 객체가 생성 
		//String에  new생성시 만들어진다.           
		String s1 = new String("자바");
		String s2 = new String("자바");
		s1 = s1 + "프로그램";
		s2 = s2 + "프로그램";
		//==
		//기본형타입은 값을 비교, 객체는 주소비교  
		System.out.println(s1 == s2);//주소 비교
		System.out.println(s1.equals(s2));//값비교 
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		
	}
	
	private static void method7() {
		//String은 고정문자열이다. 값을 바꾸면 새로운 주소에 객체가 생성 
		//String에 literal을 직접입력하면 컴파일시에 만들어진다. 
		//                 이미있는 문자열은 다시 생성하지않고 존재한 주소사용 
		String s1 = "자바";
		String s2 = "자바";
		s1 = s1 + "프로그램";
		s2 = s2 + "프로그램";
		
		System.out.println(s1 == s2);//주소 비교
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		
	}

	private static void method6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나눌수, 나누는수 입력>>");
		int a=sc.nextInt();
		double b=sc.nextDouble();
		double result=0, result2=0;
		//실수는 0.0나누면(/, %) 오류아님, Infinite, NaN
		if(!Double.isInfinite(a/b)) result = a/b;  //몫
		if(!Double.isNaN(a%b)) result2 = a%b; //나머지 
		System.out.println(result);
		System.out.println(result2);
		sc.close();
		
	}

	private static void method5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나눌수, 나누는수 입력>>");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int result=0;
		//if(b!=0) {result = a/b;	}
		try {
			result = a/b;  //오류발생->자바가상머신이 Exception객체를 생성해서 변수에 할당
		}catch(ArithmeticException ex) {
			//Exception처리가되면 프로그램은 정상적으로 진행한다. 처리안하면 중지
			System.out.println(ex.getMessage());
		}
		
		System.out.println(result);
		sc.close();
	}

	private static void method4() {
		int a=5;
		int b=0;
		//개발시에 값을 할당하는 것이 아니므로 컴파일 오류없음
		//실행오류발생 :java.lang.ArithmeticException 연산오류 , 정수는 0으로 나눌수없음 
		//프로그램중지됨 , 프로그램은 정상적으로 종료되어야한다. 
		//JVM이 RuntimeException을 처리해준다. 개발자가 처리하지 않아도된다. 
		//Exception처리를 한다 : 1.오류없도록 값 체크, 2.Exception처리 
		int result=0;
		//1.
		//if(b!=0) result = a/b;
		//2.
		try {
		   //Exception이 일어날 가능성이 있는 문장
		   result = a/b;
		}catch(ArithmeticException ex) {
		   //Exception처리
			System.out.println(ex.getMessage());
		}
		System.out.println(result);
		System.out.println("method4가 END~~~~");
		
		
	}

	private static void method3() {
		int apple=1;
		double pieceUnit = 0.1;
		int number  = 7;
		double result = apple - number*pieceUnit;
		System.out.println("사과1개에서 남은양:" + result);
		
	}

	private static void method2() {
		int a=10, b=3;
		System.out.println(++a);
		System.out.println(a++);
		System.out.println(a);
		a++;
		++a;
		System.out.println(a);
		
	}

	private static void method1() {
		int a=10, b=3;
		System.out.println( ++a + b); //전위연산자는 증감후 연산한다. 
		System.out.println( a++ + b); //후위연산자는 연산후 증감한다.
		
		++b;
		b++;
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		
	}

}





