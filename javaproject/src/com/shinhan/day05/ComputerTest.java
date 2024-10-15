package com.shinhan.day05;

public class ComputerTest {
	public static void main(String[] args) {
		//f1();
		//f2();
		f3();
	}

	private static void f3() {
		Computer c3 = new Computer("PC","window11");
		
//		System.out.println(c3.productName);
//		System.out.println(c3.os);
//		System.out.println(c3.price);
		c3.infoPrint();
	}

	private static void f2() {
		Computer c2 = new Computer("PC","window11",300);
		
		System.out.println(c2.productName);
		System.out.println(c2.os);
		System.out.println(c2.price);
	}

	private static void f1() {
		// 기본형 : 선언, 초기화, 사용
		int a; // 선언
		a = 10; //초기화
		++a; // 사용
		System.out.println(a);
		
		// 1.객체 참조 변수 선언
		Computer c1;
		
		// 2.객체 생성
		c1 = new Computer();
		
		// 3.객체 사용
		c1.setProductName("내컴퓨터");
		c1.setOs("window10");
		c1.setPrice(200);
		
//		System.out.println(c1); // 주소
		System.out.println(c1.getProductName()); // Computer class가 가지고 있는 값 
		System.out.println(c1.getOs()); // Computer class가 가지고 있는 값 
		System.out.println(c1.getPrice()); // Computer class가 가지고 있는 값 
	}
}
