package com.shinhan.day07.exercise_07;

public class Example2 {
	public static void action(A2 a) {
		a.method1();
		if(a instanceof C2 c) {
			c.method2();
		}
	}
	
	public static void main(String[] args) {
		action(new A2());
		action(new B2());
		action(new C2());
	}
}