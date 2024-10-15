package com.shinhan.day03;

import java.util.Scanner;

public class LAB1 {

	public static void main(String[] args) {
		//ex1();
		//ex2_ForTest();
		//ex3_SumTest();
		//hokeyGraphics('*', 3, true); // 4번문제
		//hokeyGraphics('&', 3, false); // 4번문제
		ex5();
	}
	public static void ex5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력할 줄 수 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		for(int i=num;i>=1;i--) {
			for(int j=1; j<=i;j++)
				System.out.print("*");
			System.out.println();
		}
		
		sc.close();
		
	}
	// 함수 정의 : 매개변수를 선언
	public static void hokeyGraphics(char cell, int size, boolean isRect) {
		// 특정 도형을 출력하는 메소드 구현
		if(isRect) {
			for(int row=1;row<=size;row++) {
				for(int col=1;col<=size;col++) {
					System.out.print(cell);
				}
				System.out.println();
			}
		}
		else {
			for(int row=1;row<=size;row++) {
				for(int col=1;col<=row;col++) {
					System.out.print(cell);
				}
				System.out.println();
			}
		}
		
	}
	
	public static void ex3_SumTest() {
		Scanner sc = new Scanner(System.in);
		int start=0, num, sum=0;
		
		System.out.print("숫자를 입력하세요. :");
		num = sc.nextInt();
		sc.nextLine();
		
		if(num%2!=0) start=1;
		
		for(int i=start;i<=num;i+=2)
			sum+=i;
		System.out.printf("결과 값 : %d",sum);
		
		sc.close();
	}
	
	public static void ex2_ForTest() {

		Scanner sc = new Scanner(System.in);
		String str;
		
		System.out.print("문자열을 입력하세요. :");
		str = sc.nextLine();
		
		for(int i=0;i<str.length();i++) {
			System.out.print(str.substring(0,i+1).toUpperCase()); // startIndex<=str<lastIndex
			System.out.println();
		}
		
		sc.close();
	}
	
	public static void ex1() {
		Scanner sc = new Scanner(System.in);
		int init, last, add, sum=0;
		
		System.out.print("초기값을 정수로 입력하세요. :");
		init = sc.nextInt();
		
		System.out.print("마지막 값을 정수로 입력하세요. :");
		last = sc.nextInt();
		
		System.out.print("증가분을 정수로 입력하세요. :");
		add = sc.nextInt();
		
		for(int i=init;i<=last;i+=add) {
			sum += i;
		}
		if(sum>1000)
			sum += 2000;
		
		System.out.printf("총합은 %d 입니다.",sum);
		
		sc.close();
	}
}
