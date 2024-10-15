package com.shinhan.day02_teacher;

public class Review {

	public static void main(String[] args) {
		q7();

	}

	private static void q7() {
		 
		System.out.print("출력1");
		System.out.println("출력2");
		System.out.println("출력3");
		System.out.printf("정수값=%5d, 실수값=%10.2f\n",10,3.14);
		System.out.println();
		System.out.printf("정수값=%-5d, 실수값=%f\n",10,3.14);
		String str = "이것이 자바다";
		System.out.printf("문자값=%20s", str);
		
	}

	private static void q6() {
		int v1 = 1; 
		System.out.println("v1: " + v1);
		if(true) {
		int v2 = 2;
		if(true) {
		 int v3 = 2;
		 System.out.println("v1: " + v1);
		 System.out.println("v2: " + v2);
		 System.out.println("v3: " + v3);
		}
		System.out.println("v1: " + v1);
		System.out.println("v2: " + v2);
		//System.out.println("v3: " + v3);
		}
		System.out.println("v1: " + v1);
		//System.out.println("v2: " + v2)
		
	}

	private static void q5() {
		//기본형 + 기능추가 =>Wrapper class
		//기본형 = 값저장, 정수,실수는 연산, 비교 
		/*
		 * byte=>Byte
		 * short=>Short
		 * char=>Character
		 * int=>Integer
		 * long=>Long
		 * float=>Float
		 * double=>Double
		 */
		int a=10;
		Integer b = 7;
		System.out.println(Integer.toBinaryString(b));
		double d = b.doubleValue();
		System.out.println(d);
	}

	private static void q4() {
		byte a=10, b=20, c;
		
		c = (byte)(a + b);
	 	System.out.println(c);
		
	}

	private static void q3() {
		int var1 = 10;
		long var2 = 10000000000L; //정수리터럴은 int범위까지만 가능 
		char var3 = ' '; //빈문자는 불가 
		float var4 = 10;
		String var5 = "a\tbc\nd\nef";//\n:는 new line \t:tab
		String var6 = """
		 abc
		 def
		 "이것이자바" '자바' / \n // \\
		 """;
		String var7 = "문자열" + var1 + " var2=" + var2;
		System.out.println(var5);
		System.out.println(var6);
		System.out.println(var7);
		//f : format
		System.out.printf("var1=%d, var2=%d",var1, var2);
	}

	private static void q2() {
		int intValue = 10;
		char charValue = 'A';
		double doubleValue = 5.7;
		String strValue = "A";
		double var1 = (double) intValue;
		byte var2 = (byte) intValue;
		int var3 = (int) doubleValue;
		//String은 기본형 타입이 아니고 자바의 Class이다. 
		//형변환 불가 ,  기능이 있는지 찾아본다. 
		//char var4 = (char) strValue
		char var4 = strValue.charAt(0); 
		System.out.println(var4);
	}

	private static void q1() {
		//1.변수선언: 선언시 반드시 data의 성격을 결정한다. 변경불가
		//변수 이름으로 사용할 수 없는 것 : 예약어, 공백불가, 숫자시작불가 
		//특수문자는 _와 $가능 
		//관례상 소문자로 시작, 일반적으로 카멜표기법으로 사용
		int _a2var, $aa, mathScore, math_score;
		int var1;
		//2.변수값 할당(초기화)
		var1 = 10;
		var1 = var1 + 20;
		//3.변수사용...초기화없이 사용불가 
		System.out.println(var1);
		
		
	}

}
