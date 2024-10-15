package com.shinhan.day02;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * java.base 모듈의 java.lang패키지는 import없이 사용
 * 나머지 calss 등등 들은 반드시 import 해야함!
 * */
public class 표준입출력 {

	public static void main(String[] args) throws IOException {
		//print();
		//input();
		//input2();
		input3();

	}

	private static void input3() {
		// 이름, 나이, 전공, 3과목 점수를 입력하고 평균 구하기
		String name, major;
		int age, score1, score2, score3;
		double avg;
		
		InputStream input = System.in;
		Scanner sc;
		sc = new Scanner(input);
		
		System.out.print("당신의 이름은?");
		name = sc.nextLine();
		
		System.out.print("당신의 나이는?");
		age = sc.nextInt();
		sc.nextLine();		
		
		System.out.print("당신의 전공은?");
		major = sc.nextLine();
		
		System.out.print("당신의 세과목 점수는?");
		score1 = sc.nextInt();
		score2 = sc.nextInt();
		score3 = sc.nextInt();
		sc.nextLine();
		
		avg = (double) (score1 + score2 + score3) / 3;
		
		System.out.printf("이름:%s, 나이:%d, 전공:%s, 평균점수:%f", name, age, major, avg);
		
		sc.close();
	}

	private static void input2() {
		// scanner : 표준입력을 간단히 사용하기 위해 제공되는 util
		InputStream a = System.in;
		// 1. 객체 참조 변수 선언
		Scanner sc;
		// 2. 객체 생성
		sc = new Scanner(a);
		
		System.out.print("당신의 이름은 >>");
		// String name = sc.next(); // next(), nextInt() : 한 단어 읽음(기본은 공백분류)
		String name = sc.nextLine(); // 한 줄 읽음
		
		System.out.print("당신의 나이는 >>");
		int age = sc.nextInt(); // 섞이면 next() 다음에 nextLine()를 사용한 경우 \r\n을 읽음
		sc.nextLine(); // 불필요한 엔터키를 버림
		
		System.out.printf("전공 >>");		
		String major = sc.nextLine();
		
		System.out.printf("당신의 나이가 %d이고 이름은 %s이군요\n", age, name);
		System.out.println("전공 → "+major);
		
		sc.close();
	}

	private static void input() throws IOException {
		// 표준입력 : 기본은 키보드
		InputStream a = System.in;
		int b = a.read();
		System.out.println((char)b);
	}

	private static void print() {
		// 표준출력 : 기본은 모니터로 되어있음
		System.out.println();
		PrintStream a = System.out;
		a.println(10);
		a.println("20");
		a.println(false);
		a.println(a);
	}

}
