package com.shinhan.day07;

import com.shinhan.day06.inheritence.*;

public class InheritenceTest {
	public static void main(String[] args) {
		//f1();
		//f2();
		f3();
	}

	private static void f3() {
		Tire[] t1 = new Tire[3];
		
		t1[0] = new Tire();
		t1[1] = new HankookTire();
		t1[2] = new KumhoTire();
		
		print(t1);
		
//		Tire t1 = new HankookTire();
//		System.out.println(t1.color);
	}

	private static void print(Tire[] t1) {
		// 1)부모=자식
		// 2)자식=(자식)부모
		for(Tire tire:t1) {
			System.out.println("----------");
			
			// field는 type을 따름
			System.out.println(tire.color);
			
			// method는 override 된 것을 수행
			tire.roll();
			
			if(tire instanceof HankookTire aa) {
//				HankookTire aa = (HankookTire) tire;
				System.out.println("한국:"+aa.color);
			}
			else if(tire instanceof KumhoTire aa) {
//				KumhoTire aa = (KumhoTire) tire;
				System.out.println("금호:"+aa.color);
			}
		}
		
	}

	private static void f2() {
//		Child a = new Child();
		
		// 1.자동 형 변환 : 부모 = 자식
		// field는 타입을 따름 → Parent
		Parent var1 = new Child();
		System.out.println(var1.a);
		
		// 메서드는 재정의되었다면 instance를 따름 → new한 값인 Child
		var1.method1();
		
		// 2.강제 형 변환 : 자식 = (자식)부모
		Child var2 = (Child) var1;
		System.out.println(var2.a);
		var2.method1();
	}

	private static void f1() {
		Child ch = new Child();
		ch.method1();
		ch.method2();
		
		System.out.println(ch.a);
	}
}
