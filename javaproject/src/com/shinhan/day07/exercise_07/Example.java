package com.shinhan.day07.exercise_07;

public class Example {
	public static void action(Parent3 a) {
		// type이 Parent3, 부모가 가진 field로 method 자식 것을 볼 수 없음
		// 매서드는 override 된 것이 수행됨
		a.method1();
		
		if (a instanceof Child4 c) {
			c.method2();
		}
	}

	public static void main(String[] args) {
		action(new Parent3());
		action(new Child3());
		action(new Child4());
	}
}
