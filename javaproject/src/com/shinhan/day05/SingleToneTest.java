package com.shinhan.day05;

public class SingleToneTest {
	public static void main(String[] args) {
		SingleTone a = SingleTone.getInstance();
		SingleTone b = SingleTone.getInstance();
		
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
	}
}
