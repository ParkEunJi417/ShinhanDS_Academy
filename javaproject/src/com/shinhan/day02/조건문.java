package com.shinhan.day02;

import java.util.Scanner;

public class 조건문 {

	public static void main(String[] args) {
		// call();
		// call2();
		// call3();
		//call4();
		call5();

	}

	private static void call5() {
		String grade = "A"; // A:골드, B:실버, C:브론즈
		String result;
		
		switch (grade) {
			case "A" ->{
				result="골드";
			}
			case "B" ->{
				result="실버";
			}
			case "C" ->{
				result="브론즈";
			}
			default->{
				result="손님";
			}	
		}
		System.out.println("당신의 등급은 "+result);
	}

	private static void call4() {
		// 사용자의 점수를 입력받아서
		// A :90~, B:80~, C:70, F:나머지

		char grade = 'F';
		Scanner sc = new Scanner(System.in);

		System.out.print("점수 입력:");
		int score = sc.nextInt();

		// break는 switch문장에서 빠져나오게 함. 없으면 다음 문장으로 내려가 진행
		switch (score / 10) {
			case 10 -> {
			}
			case 9 -> {
				grade = 'A';
			}
			case 8 -> {
				grade = 'B';
			}
			case 7 -> {
				grade = 'C';
			}
			default -> {
				grade = 'F';
			}
		}
	}

	private static void call3() {
		// 사용자의 점수를 입력받아서
		// A :90~, B:80~, C:70, F:나머지

		char grade = 'F';
		Scanner sc = new Scanner(System.in);

		System.out.print("점수 입력:");
		int score = sc.nextInt();

		// break는 switch문장에서 빠져나오게 함. 없으면 다음 문장으로 내려가 진행
		switch (score / 10) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		default:
			grade = 'F';
			break;
		}

	}

	private static void call2() {
		// 사용자의 점수를 입력받아서
		// A :90~, B:80~, C:70, F:나머지

		char grade = 'F';
		Scanner sc = new Scanner(System.in);

		System.out.print("점수 입력:");
		int score = sc.nextInt();

		if (score >= 90)
			grade = 'A';
		else if (score >= 80)
			grade = 'B';
		else if (score >= 70)
			grade = 'C';

		System.out.println("학점:" + grade);

	}

	private static void call() {
		// if
		int data = 10;
		if (data % 3 == 0) {
			System.out.println("3의 배수");
		} else {
			System.out.println("3의 배수가 아니다");
		}
		System.out.println("END");
	}

}
