package com.shinhan.day11.exercise_12;

public class StringBuilderExample {
	public static void main(String[] args) {
		StringBuilder str=new StringBuilder();
		for (int i = 1; i <= 100; i++) {
			str.append(i);
		}
		System.out.println(str);
	}
}
