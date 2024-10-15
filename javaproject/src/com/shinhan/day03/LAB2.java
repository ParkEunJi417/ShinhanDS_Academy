package com.shinhan.day03;

import java.util.Scanner;

public class LAB2 {
	static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		//ex1();
		//ex2();
		//ex3();
		//ex3_T();
		//ex4();
		//ex5();
		//ex6();
		//ex7();
		ex8();
		sc.close();
	}
	
	public static void ex8() {
		System.out.println(gcd(2,5));
		System.out.println(gcd(5,15));
		System.out.println(gcd(250,30));
	}
	
	private static int gcd(int num1, int num2) {
		int minNum = Math.min(num1, num2);
		
		for(int i=minNum;i>=1;i--) {
			if(num1%i==0 && num2%i==0) {
				return i;
			}
		}
		return 0;
	}
	
	/* 내가 짠 코드
	private static int gcd(int num1, int num2) {
		int result=1, minNum;

		minNum = Math.min(num1, num2);
		//minNum = num1 > num2?num2:num1;
		
		for(int i=1;i<=minNum;i++) {
			if(num1%i==0 && num2%i==0) {
				result = i;
			}
		}
		return result;
	}*/

	public static void ex7() {
		System.out.print("월 입력 : ");
		int month = sc.nextInt();
		
		numDay(month);
	}
	
	
	private static void numDay(int month) {
		int day=1;
		
		switch(month) {
		case 1,3,5,7,8,10,12->{day=31;}
		case 4,6,9,11->{day=30;}
		case 2->{day=28;}
		default->{
			System.out.printf("%d월은 존재하지 않습니다. 다시 입력하세요.",month); 
			return;
			}
		}
		System.out.println(day);
	}

	public static void ex6() {
		int year=100, month=2;
		int day=1;
		
		switch(month) {
			case 1,3,5,7,8,10,12->{day=31;}
			case 4,6,9,11->{day=30;}
			case 2->{
				if(year%4==0 && year%100!=0 || year%100==0 && year%400==0) {
					day=29;
				}
				else
					day=28;
			}
			default->{System.out.println("잘못된 월입니다.");}
		}
		System.out.println(year+"년 "+month+"월의 말일은 "+day+"일 입니다");
	
	}
	
	public static void ex5() {
        int GOAL_NUM = 15;  //목표 값
        int i = 0;  //증가분
        int current_step = 0;  //현재 반복 횟수
        int result = 1;  //수열 + 증가분
        int total = 0;  //증가된 수열의 합
        
        while (current_step < GOAL_NUM) {
            result += i++;
            current_step++;
            total += result;
        }
        System.out.printf("%d번째까지의 합: %d", GOAL_NUM, total);
	}
	
	public static void ex4() {
		int count=0, sum=0;
		System.out.print("양의 정수를 입력하세요. :");
		int num = sc.nextInt();
		
		for(int i=num;i<=1000;i+=num) {
				count++;
				sum += i;
		}
		System.out.printf("%d의 배수 개수 = %d\n",num,count);
		System.out.printf("%d의 배수 합 = %d\n",num,sum);
	}
	
	public static void ex3_T() {
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. :");
		int num = sc.nextInt();
		
		if(num<2 || num>9) {
			System.err.println("잘못된 숫자가 입력되었습니다.");
			return; // 함수 빠져나감
		}
		
		for(int i=1;i<=num;i++)
			System.out.printf("%d ! = %d\n", i, factorial(i));
	}
	
	public static int factorial(int su) {
		if(su==1)
			return 1;
		else
			return su*factorial(su-1);
	}
	
	// 함수 끝나고 돌아갈 때 int 값을 가지고 감
	/*public static int factorial(int su) {
		int answer=1;
		for(int i=1;i<=su;i++) {
			answer *= i;
		}
		return answer;
	}*/
	
	public static void ex3() {
		int total=1;
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. :");
		int num = sc.nextInt();
		
		if(num<2 || num>9) {
			System.err.println("잘못된 숫자가 입력되었습니다.");
			return; // 함수 빠져나감
		}
		
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=i;j++) {
				total = total * j;
			}
			System.out.printf("%d ! = %d\n",i,total);
			total=1;
		}
	}
	
	public static void ex2() {
		boolean isPrime=true;
		System.out.print("2~100사이의 정수를 입력하세요. :");
		int num = sc.nextInt();
		
		if(num<2 || num>9) {
			System.err.println("잘못된 숫자가 입력되었습니다.");
			return; // 함수 빠져나감
		}
		
		for(int i=2;i<num;i++) {
			if(num==2 || num%i==0) {
				isPrime=false;
				break;
			}
		}
			System.out.printf("%d는(은) %s니다.",num, isPrime?"소수입":"소수가 아닙");
	}

	public static void ex1() {
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. : ");
		int num = sc.nextInt();
		
		if(num<2 || num>9) {
			System.err.println("잘못된 숫자가 입력되었습니다.");
			return; // 함수 빠져나감
		}
		
		for(int i=1;i<10;i++) {
			System.out.printf("%2d * %2d = %2d\n",num,i,num*i);
		}
		//return; // void는 return할 값이 없음
	}
}
