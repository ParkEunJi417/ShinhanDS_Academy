package com.shinhan.day10;

// extends Object 생략되어있음
class Parent {

}

// 규격서
interface MyInterface{
	// 상수 + 추상메서드 + default메서드 + static메서드 + private 메서드
}

class Child extends Parent implements MyInterface, Comparable<Child>{
	// Class의 구성요소 5가지
	// 1.field
	// 2.constructor
	// 3.method
	@Override
	public int compareTo(Child o) {
		// TODO Auto-generated method stub
		return 0;
	}
	// 4.block
	// 5.inner class
	//	1)instance inner class
		class InnerClass{}
	//	2)static inner class
		static class StaticInnerClass{}
	//	3)local inner class
		void call(int param) {
			// 지역변수가 local inner class에서 사용되면 modifier가 final 특성을 가지게 되어서 수정 불가능
			int score=100;
			
			class LocalInnerClass{
				void method1() {
					int score2 = score;
					System.out.println(score);
					System.out.println(score2++);
					System.out.println(param);
				}
			}
			class LocalInnerClass2{}
		}
	
	// 부모의 field, method를 상속받아서 private 제외하고 모두 사용 가능
	// 수정 가능(final 제외하고 Override 가능)
	// 추가 가능(만약, 이름&return 같고 매개변수 다름 - Overloading)
}

public class Review {
	public static void main(String[] args) {
		
	}
}
