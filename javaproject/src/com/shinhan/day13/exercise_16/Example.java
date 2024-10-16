package com.shinhan.day13.exercise_16;

interface Function{
	double apply(double a, double b);
}

public class Example {
	public static double calc(Function fun) {
		double x = 10;
		double y = 4;
		return fun.apply(x, y);
	}

	public static void main(String[] args) {
		double result = calc((x, y) -> (x / y));
		System.out.println("result: " + result);
	}
}
