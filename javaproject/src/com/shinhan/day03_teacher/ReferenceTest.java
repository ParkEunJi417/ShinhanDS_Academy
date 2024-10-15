package com.shinhan.day03_teacher;

import java.util.Scanner;
//cmd>java ReferenceTest 10 20
// new String[]{"10","20"}
public class ReferenceTest {

	public static void main(String[] aa) {
		//명령행 매개변수로 두수를 받아서 사칙연산 수행한다. 
		if(aa.length<2) {
			System.out.println("명령행 매개변수로 두수가 필수");
			return;
		}
		System.out.println(aa[0]);
		System.out.println(aa[1]);
		int su1 = Integer.parseInt(aa[0]);
		int su2 = Integer.parseInt(aa[1]);
		System.out.println(su1+su2);
		System.out.println(su1-su2);
		System.out.println(su1*su2);
		System.out.println(su1/su2);
		//f4(null);
		//f4("이것이 자바다");
		//f9();

	}

	private static void f9() {
		// 다차원 : 배열이 배열을 참조한다. 
		//1.배열참조변수 선언
		int[][] arr;
		int[] arr2[];
		int arr3[][];
		//2.배열객체생성
		arr = new int[3][4]; //arr은 3개짜리 배열을 참조한다. 
		arr2 = new int[3][]; //첫번째[]안의 배열갯수는 필수 
		arr3 = new int[][] {{1,2,3},{10,20}};
		
		for(int i=0;i<arr3.length;i++) {
			//arr2[i] = new int[5-i]; 
			for(int j=0;j<arr3[i].length;j++) {
				System.out.printf("%d행 %d열 %d값/ ", i, j, arr3[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("==============향상FOR==========");
		for(int[] aa:arr3) {
			for(int bb:aa) {
				System.out.print(bb + "\t");
			}
			System.out.println();
		}
		
		
	}

	private static void f8() {
		int[] scores = {100,90,88,100,30};
		int total = 0;
		for(int data:scores) {
			total += data;
		}
		System.out.println(total);
		System.out.println((double)total/scores.length);
		System.out.println(scores[scores.length-1]);
		
	}

	private static void f7() {
		String[] arr;
		String arr2[] = new String[3];
		arr = new String[3];
		
		//String[] arr3 = new String[] {"HTML","CSS","JavaScript"};
		//String[] arr3 = {"HTML","CSS","JavaScript"};
		String[] arr3;
		arr3 = new String[]{"HTML","CSS","JavaScript"};
		
		arr[0] = "자바";
		arr[1] = new String("DB");
		arr[2] = new String("Spring");
		//arr[3] = new String("Spring"); index번위가 벗어남 Exception 
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i] + "---" + arr3[i]);
		}
		
	}

	private static void f6() {
		//연속된 공간에 값을 나열시키고, 각 값에 인덱스를 부여해 놓은 자료구조
		//1.배열참조변수 선언
		int[] arr;
		//선언+생성 
		int arr2[] = new int[5];
		//선언+생성+초기화 
		int[] arr3 = new int[] {100,200,300,400,500}; //[]안에 개수 사용불가 
		int[] arr4 = {100,200,300,400,500}; //선언시 초기화할때 생성코드는 생략가능 
		int[] arr5;
		arr5 = new int[]{1,10,100,1000,10000}; //선언과 초기화가 분리된 경우 생성코드는 생략불가 
		
		//2.배열생성-Heap영역에 생성된다...개수는 필수 , 생성시 자동초기화된다.
		//기본형 정수->0 실수->0.0 논리->false 참조형->null
		arr = new int[5]; 
		//3.배열사용
		for(int i=0;i<arr.length;i++) {
			System.out.println(i + "번째:" + arr[i] + "-----" + 
		             arr2[i]+ "-----" + arr3[i]+ "-----" + arr4[i]+ "-----" + arr5[i]);
		}
		/*
		for(int data:arr) {
			System.out.println(data);
		}*/
		

		
	}

	private static void f5() {
		//String은 고정문자열이다. 변경불가
		String s1 = "신한DS,금융 소프트/아카 데미";
		System.out.println("문자열의 길이:" + s1.length());
		System.out.println("특정위치의 문자:" + s1.charAt(5));
		System.out.println("문자열의 일부:" + s1.substring(7));
		System.out.println("문자열의 일부:" + s1.substring(7,10));
		System.out.println("문자열의 대체:" + s1.replace("금융", "Money"));
		System.out.println("특정문자의 position:" + s1.indexOf("프"));
		
		//배열 : 하나의 이름은 같은 타입의 값 여러개를 갖는 자료구조 
		String[] arr = s1.split(",| |/"); //|는 OR의 의미 
		System.out.println(arr.length);
		//일반FOR문 
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("=======================");
		//향상For, 확장FOR ...반복자(literate) 
		for(String s:arr) {
			System.out.println(s);
		}
		System.out.println(s1);
		
	}

	private static void f4(String param) {
		// 1.객체참조변수 선언
		String s1 = param; // 결정된 값이 없다.
		// 2.변수초기화
		// 3.변수사용...반드시 초기화후 사용가능
		System.out.println(s1);
		// null인 경우는 아직 참조하지않고 있음을 의미, 기능이용불가

		if (s1 != null)
			System.out.println(s1.length());
		else
			System.out.println("참조된 값이 없음");

	}

	private static void f3() {
		char c1 = 'A';
		char c2 = 'A';
		// 컴파일시에 객체생성하고 이미생성된 리터럴과 같으면 재사용
		String s1 = "자바";
		String s2 = "자바";
		// 실행시 객체생성
		String s3 = new String("자바");
		String s4 = new String("자바");
		System.out.println(c1 == c2); // 기본형이므로 값을 비교
		System.out.println(s1 == s2); // 참조형이므로 주소을 비교
		System.out.println(s3 == s4); // 참조형이므로 주소을 비교
		System.out.println(s1 == s4); // 참조형이므로 주소을 비교
		System.out.println(s1.equals(s4)); // 참조형에서 값비교는 함수이용
		System.out.println(s3.equals(s4)); // 참조형에서 값비교는 함수이용

	}

	private static void f2() {
		Scanner a = new Scanner(System.in);
		Scanner b = new Scanner(System.in);

		System.out.println(a == b); // 주소가 다르다.
		System.out.println(a != b); // 주소가 다르다.

		a.close();
		b.close();
	}

	private static void f1() {
		// 기본형이 아니면 참조형이다.
		int a = 10; // stack영역에 저장됨

		// b는 객체참조변수이다.
		// Integer b = new Integer(20);
		Integer b = 20; // 기본형기능(값할당,연산,비교) + 기타기능 .....Heap영역에 저장된다.
		// 자동으로 AutoBoxing된다.

		System.out.println(b.compareTo(30)); // -1 0 +1
		System.out.println(b.compareTo(10)); // -1 0 +1
	}

}
