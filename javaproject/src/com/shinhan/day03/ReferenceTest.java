package com.shinhan.day03;

import java.util.Scanner;

public class ReferenceTest {

	public static void main(String[] args) {
		//f1();
		//f2();
		//f3();
		//f4();
		//f5();
		//f6();
		//f7();
		//f8();
		//f9();
		// 명령형 매개변수로 두 수를 받아서 사칙연산 수행
		if(args.length<2) {
			System.out.println("명령형 매개변수로 두 수가 필수!");
			return;
		}
		System.out.println(args[0]);
		System.out.println(args[1]);
		
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		System.out.println(num1+num2);
		System.out.println(num1-num2);
		System.out.println(num1*num2);
	}

	private static void f9() {
		// 다차원 : 배열이 배열을 참조
		// 1.배열참조변수 선언
		int[][] arr;
		int[] arr2[];
		int arr3[][];
		
		// 2.배열 객체 생성
		arr = new int[3][4]; // arr은 3개짜리 배열을 참조
		arr2 = new int[3][]; // 첫번째[]의 개수는 필수
//		arr3 = new int[][]; 초기화 불가능
		arr3 = new int[][] {{1,2,3},{10,20}}; // 정방배열이 아님
		
		for(int[] num:arr3) {
			for(int n:num) {
				System.out.print(n+"\t");
			}
			System.out.println();
		}
		
		System.out.println("-----------------");
		
		for(int i=0;i<arr3.length;i++) {
			for(int j=0;j<arr3[i].length;j++) {
				System.out.printf("%d행 %d열 값 : %d/",i,j,arr3[i][j]);
			}
			System.out.println();
		}
		
		/*
		for(int i=0;i<arr.length;i++) {
			arr2[i] = new int[5-i];
			
			for(int j=0;j<arr2[i].length;j++) {
				System.out.printf("%d행 %d열 값 : %d/",i,j,arr2[i][j]);
			}
			System.out.println();
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.printf("%d행 %d열 값 : %d/",i,j,arr[i][j]);
			}
			System.out.println();
		}
		*/
	}

	private static void f8() {
		int[] scores= {100,90,88,100,30};
		int sum=0, avg;
		
		for(int score:scores) {
			sum+=score;
		}
		System.out.println(sum);
		System.out.println((double)sum/scores.length);
	}

	private static void fn7() {
		String[] arr;
		arr = new String[3];
		
		String[] arr2 = new String[3];
		
		//String[] arr3 = new String[] {"HTML", "CSS", "JavaScript"};
		//String[] arr3 = {"HTML", "CSS", "JavaScript"};
		String[] arr3;
		arr3 = new String[] {"HTML", "CSS", "JavaScript"};
		
		arr[0] = "자바";
		arr[1] = new String("DB");
		arr[2] = new String("Spring");
//		arr[3] = new String("Spring"); index범위가 벗어남 → ArrayIndexOutOfBoundsException
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+" / "+arr3[i]);
		}
	}

	private static void f6() {
		// 배열 : 연속된 공간에 값을 나열시키고, 각 값에 인덱스를 부여해놓은 자료구조
		// 1.배열참조변수 선언
		int[] arr;
		int arr2[] = new int[5]; // 선언+생성
		int[] arr3 = new int[] {100,200,300,400,500}; // 선언+생성+초기화, []안에 개수 사용X
		int[] arr4 = {100,200,300,400,500}; // 선언시 초기화할때 생성코드인 new int[] 생략가능
		int[] arr5;
		arr5 = new int[]{1,10,100,1000,10000}; // 선언과 초기화가 분리된 경우 생성코드인 new int[] 생략불가
		
		// 2.배열생성 : Heap영역에 생성, 개수는 필수, 생성시 자동 초기화됨
		// 기본형 정수 → 0, 실수 → 0.0, 논리 → false, 참조형 → null
		arr = new int[5];
		
		// 3.배열사용
		for(int i =0;i<arr.length;i++)
			System.out.println(i+"번째:"+arr[i]+" / "+arr2[i]
					+" / "+arr3[i]+" / "+arr4[i]+" / "+arr5[i]);
		
		/*
		for(int s:arr) {
			System.out.println(s);
		}
		*/
	}

	private static void f5() {
		// String은 고정 문자열로 변경불가
		String s1 = "신한DS,금융 소프트/아카 데미";
		
		System.out.println("문자열의 길이:"+s1.length()); // 문자열의 길이
		System.out.println("문자열의 5번째 문자:"+s1.charAt(5));
		System.out.println("문자열의 일부:"+s1.substring(7));
		System.out.println("문자열의 일부:"+s1.substring(7,10));
		System.out.println("문자열의 대체:"+s1.replace("금융", "Money"));
		System.out.println("특정 문자의 위치:"+s1.indexOf("프"));
		System.out.println("------------------------");
		
		// 배열 : 하나의 이름으로 같은 타입의 값 여러개를 갖는 자료구조
		String[] arr=s1.split(",| |/");
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println("------------------------");
		System.out.println("향상된 For문 사용");
		
		// 향상For, 확장For
		// For(반복자(literate):배열(array))
		for(String s:arr) {
			System.out.println(s);
		}
		
		System.out.println("문자열 원본:"+s1);
	}

	private static void f4() {
		/*
		1.객체 참조변수 선언
			String s1=null; // 결정된 값이 없음
		2.변수 초기화
		3.변수 사용 → 반드시 초기화 후 사용가능
		null값일때는 length를 알 수 없음, null인 경우는 아직 참고하지 않고 있음을 의미, 기능 이용 불가
			System.out.println(s1.length()); 
		*/
		
		String s1="param";
		System.out.println(s1);
		if(s1!=null) 
			System.out.println(s1.length());
		else
			System.out.println("참조된 값이 없음");
	}

	private static void f3() {
		char c1 = 'A';
		char c2 = 'A';
		
		// 컴파일시에 객체를 생성하고, 이미 생성된 리터럴과 같으면 재사용
		String s1 = "자바";
		String s2 = "자바";
		
		// 실행시 객체 생성
		String s3 = new String("자바");
		String s4 = new String("자바");
		
		System.out.println(c1==c2); // 기본형이므로 값을 비교
		System.out.println(s1==s2); // 참조형이므로 주소를 비교
		System.out.println(s3==s4); // 참조형이므로 주소를 비교
		System.out.println(s1==s4); // 참조형이므로 주소를 비교
		System.out.println(s1.equals(s2)); // 참조형에서 값비교는 함수 이용
		System.out.println(s3.equals(s4)); // 참조형에서 값비교는 함수 이용
	}

	private static void f2() {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println(sc1==sc2); // sc1와 sc2는 실행할때마다 new하기 때문에 주소가 다름
		
		sc1.close();
		sc2.close();
	}

	private static void f1() {
		// 기본형이 아니면 참조형
		int a = 10; // Stack 영역에 저장
//		Integer b = new Integer(20); // 참조형 기본 문법
		
		/* Integer b = 20
		  - b는 객체참조변수
		  - 기본형 기능(값 할당, 연산, 비교) + 기타기능
		  - Heap영역에 저장
		  - 자동으로 AutoBoxing됨
		*/
		Integer b = 20; // Java9에서만 가능 
		
		System.out.println(b.compareTo(30)); // -1,0,1
		System.out.println(b.compareTo(10)); // -1,0,1
		
	}

}
