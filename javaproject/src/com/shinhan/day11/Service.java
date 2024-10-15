package com.shinhan.day11;

public class Service {
	
	int score;
	
	@PrintAnnotation
	public void method1() {
		System.out.println("method1 실행");
	}
	
	// value 속성은 생략 가능
	@PrintAnnotation("#")
	public void method2() {
		System.out.println("method2 실행");
	}

	@PrintAnnotation(value="@",number=20)
	public void method3() {
		System.out.println("method3 실행");
	}
}
