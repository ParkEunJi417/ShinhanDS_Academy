package com.shinhan.day03;

import java.util.Scanner;
// .javac → .class(Byte Code)
// cmd>java LAB3
// class load (JVM에 올라옴)

public class LAB3 {
	// cmd>java LAB2 10 → 10이 명령형 매개변수
	// 명령형 args[0]=10
	// Eclipse에서 설정하는 경우는 Run > Run Configuration 팝업창 > arguments > Program argument에 입력
	
	static Scanner sc;
	static final String name="100";	// 상수
	
	public static void main(String[] args) {
		//ex1(args[0]);
		ex2();

	}

	private static void ex2() {
		System.out.println(abs(10,20));
		System.out.println(abs(20,10));
	}

	private static int abs(int num1, int num2) {
		int result = num1 - num2;
		return result<0?result*-1:result;
	}

	private static void ex1(String strMonth) {
		int month = Integer.parseInt(strMonth);
		printSeason(month);
	}

	private static void printSeason(int month) {
		String message="";
		
		switch(month) {
			case 3,4,5->{message="봄";}
			case 6,7,8->{message="여름";}
			case 9,10,11->{message="가을";}
			case 12,1,2->{message="겨울";}
			default->{System.out.println("1~12사이의 숫자만 입력하셔야 합니다");}
		}
		System.out.println(message+"에 태어나셨네요.");
	}

}
