package com.shinhan.day12;

public class MultiThreadTest3 {

	public static void main(String[] args) {
//		f1();
		f2();
	}

	private static void f2() {
		Calculator cal = new Calculator();
		User1Thread t1 = new User1Thread();
		User2Thread t2 = new User2Thread();
		
		t1.setCalculator(cal);
		t2.setCalculator(cal);
		
		t1.start();
		t2.start();
		
	}

	private static void f1() {
		SumThread t1 = new SumThread(100);
		SumThread t2 = new SumThread(10);
		
		t1.start();
		t2.start();
		
		try {
			t1.join(); // Thread가 끝날때까지 기다림
			System.out.println(t1.getSum());
			System.out.println(t2.getSum());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
