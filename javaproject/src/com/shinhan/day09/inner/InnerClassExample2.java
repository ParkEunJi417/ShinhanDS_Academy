package com.shinhan.day09.inner;

public class InnerClassExample2 {
	public static void main(String[] args) {
		method1("");
	}

	public static void method1(String title) {
		// 메서드내의 class : 함수 내에서만 사용 가능
		
		// 지역변수(메서드내의 변수, 매개변수)
		// 내부class에서 지역변수가 사용되면 무조건 fianl(수정불가)
		String subject="java";
		class LocalClass {
			// 1.field
			int score = 100;
			
			// 2.method
			void print(){
				System.out.println("지역변수 사용:"+title);
				System.out.println("LocalClass score="+score);
				System.out.println("지역변수 사용:"+subject);
			}
		}
		LocalClass aa = new LocalClass();
		aa.print();
	}
}
