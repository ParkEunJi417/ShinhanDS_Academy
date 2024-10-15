package com.shinhan.day02_teacher;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * java.base모듈의 java.lang패키지는 import없이 사용한다. 
 * 나머지classe등등 들은 반드시 import한다
 */


public class 표준출력입력 {

	public static void main(String[] args) throws IOException {
		//print();
		input3();

	}

	private static void input3() {
		//입력: 이름과 나이와 전공, 3과목 점수
		//모든 정보출력 이때 평균도 출력한다. 
		String name, major;
		int age, java,sql,web;
		double avg;
		Scanner sc = new Scanner(System.in);
		System.out.print("이름>>");
		name = sc.next();
		System.out.print("major>>");
		sc.nextLine(); //이름입력후 enter를 버림
		major = sc.nextLine();
		System.out.print("age>>");
		age = sc.nextInt();
		System.out.print("java sql web(3과목)>>");
		java = sc.nextInt();
		sql = sc.nextInt();
		web = sc.nextInt();
		avg = (java + sql + web)/3.0;
		
		System.out.println("========사용자정보===========");
		System.out.println("이름:" + name);
		System.out.println("전공:" + major);
		System.out.println("나이:" + age);
		System.out.println("평균:" + avg);
		System.out.println();
		sc.close();
	}

	private static void input2() {
		//Scanner : 표준입력을 간단히 사용하기위해 제공되는 util 
		InputStream a = System.in;
		//1.객체참조변수선언 
		Scanner sc ;
		//2.객체생성 
		sc = new Scanner(a);
		System.out.print("당신은 이름은>>");
		String name = sc.nextLine();
		//next(), nextInt():한단어읽음(기본은 공백분류)
		//nextLine() : 한줄읽기 
		//섞이면 next()다음에 nextLine()를 사용경우 \r\n을 읽는다. 
		System.out.print("당신은 나이는>>");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("전공>>");
		String major = sc.nextLine();
		System.out.printf("당신은 나이가 %d이고 이름은 %s이군요",age, name);
		System.out.println("전공=>" + major);
		sc.close();
		
	}

	private static void input() throws IOException {
		// 표준입력 : 기본은 키보드이다. 
		InputStream a = System.in;
		int b = a.read();
		System.out.println((char)b);
	}

	private static void print() {
		// 표준출력: 기본은 모니터로 되어있음
		PrintStream  a = System.out;
		a.println(10);
		a.println("20");
		a.println(false);
		a.println(a);
	}

}
