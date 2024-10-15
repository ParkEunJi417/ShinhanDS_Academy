package com.shinhan.day09;

class Window{
	// 4)interface
	interface MyInterface{
		void method1();
	}
	
	// 1)instance inner class
	class InnerClass{
		
	}
	
	// 2)static inner class
	static class InnerClass2{
		
	}
	
	String subject="java"; // field
	
	void method(String param) {
		String localVar = "local";
		
		// 3)local class : - method 안에서만 사용 가능
		//				   - 지역변수에 접근하면 modifier가 final이 되어버림
		class LocalClass{
			void call() {
				System.out.println("field:"+subject);
				System.out.println("매개변수:"+param);
				System.out.println("지역변수:"+localVar);
			}
		}
		
		class LocalClass2{
			
		}
		LocalClass aa = new LocalClass();
		aa.call();
	}
}

public class InnerClassTest2 {

	public static void main(String[] args) {
		// 1.instance inner class
		Window.InnerClass aa = new Window().new InnerClass();
		
		// 2.static inner class
		Window.InnerClass2 bb = new Window.InnerClass2();
		
		// 익명 구현 클래스
		Window.MyInterface cc = new Window.MyInterface() {

			@Override
			public void method1() {
				System.out.println("익명구현 class override");
			}
		};
		
		// 익명 구현 클래스를 만들고 즉시 실행
		(new Window.MyInterface() {

			@Override
			public void method1() {
				System.out.println("익명구현 class override");
			}
		}).method1();
	}

}
