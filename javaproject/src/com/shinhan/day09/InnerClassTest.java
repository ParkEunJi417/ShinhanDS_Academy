package com.shinhan.day09;

// .java를 컴파일하면 아래와같이 class 파일 생성됨
// OuterClass$InnerClass.class
// OuterClass$SInnerClass.class

class OuterClass {
	// 1.field
	int score1=10;
	String name="java";
	static int s_score=10;
	// 2.method
	// 3.constructor
	// 4.block
	// 5.inner class
	class InnerClass{
		int score2=20;
		boolean name=true;
		
		void method2() {
			// 이름충돌 : 내부에 있는 것이 우선
			System.out.println(score1+score2+OuterClass.this.name+name);
		}
	}
	
	// static은 객체 생성없이 접근 가능
	// non-static은 객체 생성을 해야 접근 가능
	static class SInnerClass{
		int score3=30;
		static int score4=40;
		
		void method3() {
			System.out.println(score3+score4+s_score);
		}
		
		static void method4() {
//			System.out.println(score3+score4); → score3는 static이 아니기 때문에 접근 불가
			System.out.println(score4+s_score);
		}
	}
}

public class InnerClassTest {
	public static void main(String[] args) {
		// 1.instance inner class 사용법
		OuterClass.InnerClass aa = new OuterClass().new InnerClass();
		
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass aa2 = outer.new InnerClass();
		
		aa.method2();
		
		// 2.static inner class 사용법
		//   1)static method
		OuterClass.SInnerClass.method4();
		
		//   2)instance method
		OuterClass.SInnerClass bb = new OuterClass.SInnerClass();
		bb.method3();
	}
}
