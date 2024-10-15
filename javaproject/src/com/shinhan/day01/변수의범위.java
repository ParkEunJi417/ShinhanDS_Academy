package com.shinhan.day01;

public class 변수의범위 {

	// static변수 : class의 모든 메서드에서 공유(c언어의 share 변수와 동일)
	static int score = 300;
	
	public static void main(String[] args) {
		System.out.println("class변수접근:"+score);
		// 메서드내의 변수는 지역변수
		int score = 100;
		method1();
		method2();
		System.out.println("-----------");
		System.out.println("main에서 출력:"+score); // 100
		System.out.println("main에서 출력:"+변수의범위.score); // 300

	}

	// 지역변수는 선언 후 초기화없이 사용하면 오류
	// 변수는 반드시 초기화 후 사용!
	private static void method2() {
		String grade="A학점";
		int score=88;
		String title; // 초기화안됨
		if(score<90) {
			title ="!!!!"; // 이렇게만 하면 초기화 될지 안될지 몰라서 오류
			grade="B학점";
		}
		System.out.println("당신의 점수는 "+score+", 학점은 "+grade);
		
	}
	
	private static void method1() {
		int score = 200;
		System.out.println("method1에서 출력:"+score); // 200
		System.out.println("method1에서 출력:"+변수의범위.score); // 300
		
	}

}
