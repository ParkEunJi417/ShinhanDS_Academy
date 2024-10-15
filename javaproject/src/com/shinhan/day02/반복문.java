package com.shinhan.day02;

import java.util.Scanner;

public class 반복문 {

	public static void main(String[] args) {
		// callFor();
		// callFor2();
		// callWhile();
		// callDoWhile();
		// callFor3();
		// callFor4(); // 구구단
		// callFor5();
		//ex4_2();
		//ex4_3();
		//ex4_4();
		//ex4_5();
		//ex4_6();
		//ex4_6_1();
		//ex4_7();
		ex4_7_teacher();
		
	}

	private static void ex4_7_teacher() {
		Scanner sc = new Scanner(System.in);
		boolean isStop = false;
		int balance=0;
		
		while(!isStop) {
			menu();
			System.out.print("선택>");
			int jobSelect = sc.nextInt();
			sc.nextLine();
			
			switch (jobSelect) {
				case 1:{
					System.out.print("예금액>>");
					balance += sc.nextInt();
					sc.nextLine();
					break;
				}
				case 2:{
					System.out.print("출금액>>");
					balance -= sc.nextInt();
					sc.nextLine();
					break;
				}
				case 3:{
					System.out.println("잔금>>"+balance);
					break;
				}
				case 4:{
					isStop=true;
					break;
				}
				default:{
					System.out.println("지원되지 않는 작업! 다시 입력하세요.");
					break;
				}

			}
		}
	}

	private static void menu() {
		System.out.println("---------------");
		System.out.println("1.예금 2.출금 3.잔고 4.종료");
		System.out.println("---------------");
	}

	private static void ex4_7() {
		Scanner sc = new Scanner(System.in);
		String menu;
		boolean run=true;
		int balance=0;
		
		while(run) {
			System.out.println("---------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			System.out.println("---------------");
			
			System.out.print("선택>");
			menu = sc.nextLine();
			
				switch(menu) {
				case "1":{
					System.out.print("예금액>");
					balance += sc.nextInt();
					sc.nextLine();
					break;
				}
				case "2":{
					System.out.print("출금액>");
					balance -= sc.nextInt();
					sc.nextLine();
					break;
				}
				case "3":{
					System.out.println("잔고>"+balance);
					break;
				}
				case "4":{
					run = false;
					sc.close();
					break;
				}
			}
		}	
	}

	private static void ex4_6_1() {
		for(int i=10;i>=1;i--) {
			for(int j=1; j<=i;j++)
				System.out.print("★");
			System.out.println();
		}
	}

	private static void ex4_6() {
		for(int i=1;i<=5;i++) {
			for(int j=1; j<=i;j++)
				System.out.print("★");
			System.out.println();
		}

	}

	private static void ex4_5() {
		for(int i=1; i<=10;i++) {
			for(int j=1;j<=10;j++) {
                if (4*i + 5*j == 60){
                    System.out.printf("(%d, %d)\n", i, j);
                }
			}
		}
		
	}

	private static void ex4_4() {
		// 무작위 실수 : 0보다 크거나 같고 1보다 작다
		//System.out.println(Math.PI);
		//System.out.println(Math.ceil(10.1)); // 올림
		//System.out.println(Math.ceil(10.9)); // 내림
		//System.out.println(Math.random()*6);
		int num1, num2, sum;
		
		while(true) {
			num1 = (int)(Math.random()*6) +1;
			num2 = (int)(Math.random()*6) +1;
			
			sum = num1 + num2;
			System.out.printf("num1:%d, num2:%d\n", num1,num2);
			if(sum==5) {
				System.out.println("END");
				break;
			}
		}
	}

	private static void ex4_3() {
		int total=0;
		for(int i=0;i<=100;i+=3) {
			total += i;
		}
		System.out.println(total);
	}

	private static void ex4_2() {
		
		String grade = "B";
		int score1 = 0;
		switch (grade) {
			case "A"->{
				score1 = 100;
			}
			case "B"->{
				int result = 100 - 20;
				score1 = result;
			}

			default->{
				score1 = 60;
			}
			
		}
		System.out.println(score1);
		
		/*
		String grade = "B";
		int score1 = 0;
		switch (grade) {
		case "A":
			score1 = 100;
			break;
		case "B":
			int result = 100 - 20;
			score1 = result;
			break;
		default:
			score1 = 60;
		}
		System.out.println(score1);
		*/
	}

	private static void callFor5() {
		// 라벨링을 통해 가장 근처가 아닌 다른 반복문을 나가게 함
		aa: for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				// if(j==4) continue; // 4단만 X
				// if(j==4) continue aa;
				if (j == 4)
					break aa;
				System.out.printf("%d * %d = %2d  ", j, i, (j * i));
			}
			System.out.println();
		}
	}

	private static void callFor4() {
		// 구구단
		for (int dan = 2; dan < 10; dan++) {
			System.out.println("------" + dan + "단------");
			if (dan == 4)
				continue;

			for (int i = 1; i < 10; i++) {
				System.out.printf("%2d * %2d = %2d\n", dan, i, (dan * i));
			}
		}
	}

	private static void callFor3() {
		// 0부터 100까지 5의 배수만 출력

		/*
		 * for(int i=0;i<=100;i++) { if(i%5==0) System.out.println(i); }
		 */

		/*
		 * for(int i=0;i<=100;i+=5) { System.out.println(i); }
		 */

		// break : 반복문 빠져나가기
		/*
		 * for(int i=0;i<=100;i+=5) { if(i==15) break; System.out.println(i); }
		 */

		// continue : 아래 문장들은 무시하고 다음 반복문 계속
		for (int i = 0; i <= 100; i += 5) {
			if (i == 15)
				continue;
			System.out.println(i);
		}
	}

	private static void callDoWhile() {
		// 1~5 출력
		int i = 1;
		do {
			System.out.println(i);
			i++;
		} while (i <= 5);
	}

	private static void callWhile() {
		// 1~5 출력
		int i = 1;
		while (i <= 5) {
			System.out.println(i);
			i++;
		}

	}

	private static void callFor2() {
		int total = 0, total2 = 0;
		for (int i = 1, j = 5; i <= 100; i++, j += 5) {
			total += i;
			total2 += j;
		}
		System.out.println("total=" + total);
		System.out.println("total2=" + total2);

	}

	private static void callFor() {
		// 1.for문 : for(초기값;조건;증감)
		int i;

		for (i = 1; i <= 10; i++) {
			System.out.println("---------" + i);
		}
		System.out.println("i=" + i);
	}

}
