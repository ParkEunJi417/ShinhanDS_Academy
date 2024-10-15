package com.shinhan.day06.inheritence;

public class HankookTire extends Tire{
	@Override
	public void roll() {
		System.out.println("##################");
		System.out.println("HankookTire의 roll...");
		System.out.println("##################");
	}
	
	void display() {
		System.out.println("HankookTire만 가지는 기술");
	}
}
