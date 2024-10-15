package com.shinhan.day01;

// 하나의 자바파일은 여러 개의 class를 정의할 수 있다.
// 단, public은 1개만 가능
// 반드시 public class로 파일이름을 저장한다.

public class Hello {

	public static void main(String[] args) {
		System.out.println("Hello~");
		System.out.println("안녕");
	}

}

class Hello2{
	public static void main(String[] args) {
		System.out.println("Hello2~");
		System.out.println("안녕2");
	}
}