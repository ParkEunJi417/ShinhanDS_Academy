package com.shinhan.day04;

import java.util.Calendar;
import java.util.Scanner;

public class EnumTest {
	// 상수로 쓸때는 변수명 대문자
	// 상수가 목적에 맞게 분리되지 않아서 로직 오류가 날 수 있음
	static final int MONDAY = 1; 
	static final int SUCCESS = 1; 
	
	public static void main(String[] args) {
		//f1();
		//f2();
		//f3();
		//f4();
	}


	private static void f4() {
		// 오늘은 무슨 요일?
		
//		Calendar cal = new Calendar → 익명 타입이라 객체 생성 불가
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		int week = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		
		Week today = null;
		
		switch(week) {
			case 1: today = Week.SUNDAY; break;
			case 2: today = Week.MONDAY; break;
			case 3: today = Week.TUESDAY; break;
			case 4: today = Week.WEDNESDAY; break;
			case 5: today = Week.THURSDAY; break;
			case 6: today = Week.FRIDAY; break;
			case 7: today = Week.SATURDAY; break;
		}
		System.out.println(today+"--"+today.name()+"--"+today.ordinal());
	}

	private static void f3() {
		Week[] arr = Week.values();
		
		for(Week week:arr) {
			// name : 이름
			// ordianl : 순서
			System.out.println(week+"--"+week.name()+"--"+week.ordinal());
		}
		Week w = Week.MONDAY;
		
		System.out.println(w==Week.MONDAY?"월":"기타");
	}

	private static void f2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요일입력(1)>>");
		int su = sc.nextInt();
		
		System.out.println(su==MONDAY?"월요일":"기타");
		
		sc.close();
	}

	private static void f1() {
		// 상수 : 한 번 할당 후 수정 불가
		// ex) 원의 넓이 : r*r*3.14
		// 3.14는 PI로 존재함
		
		int r = 10;
		double area = r*r*Math.PI;
		
		System.out.println(Math.PI);
		System.out.println(area);
	}

}
