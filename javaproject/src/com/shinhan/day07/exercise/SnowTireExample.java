package com.shinhan.day07.exercise;

public class SnowTireExample {
	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		
		// 1.자동 형 변환 : 부모 = 자식
		Tire tire = snowTire;

		// 메서드는 재정의된 것이 수행됨(instance를 따름)
		snowTire.run();
		tire.run();
	}
}