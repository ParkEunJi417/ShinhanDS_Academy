package com.shinhan.day04;

// 파일명과 public class 뒤에 오는 이름은 항상 일치해야함 → 그게 main으로 실행됨
class Hello{
	public static void main(String[] args) {
		System.out.println("Hello main");
	}
	public void f2() {
		System.out.println("Hello f2");
	}
}

public class Review {

	public static void main(String[] args) {
		System.out.println("Review main 시작");
		f();
		f3();
		Hello a = new Hello();
		a.f2();
		System.out.println("Review main 종료");
	}
	
	private static void f3() {
		// Data Type
		// 1.기본형 : byte < char, short < int < long < float < double
		//          boolean
		// 2.참조형 : array, class, enum, interface ...
		
		int[] arr = {10,20,30};
//		arr = new int[4]; → heap영역에 정수 4칸 생성 및 0으로 초기화됨
		
		// 일반 for문
		for(int i=0;i<arr.length;i++) { // 변수.:속성, 변수.():기능이 있는 함수
			System.out.println(arr[i]);
		}
	}

	public static void f() {
		System.out.println("Review f");
	}

}
