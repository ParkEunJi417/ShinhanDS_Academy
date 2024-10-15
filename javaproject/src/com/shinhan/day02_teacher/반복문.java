package com.shinhan.day02_teacher;

import java.util.Scanner;

public class 반복문 {

	public static void main(String[] args) {
		ex7();

	}

	private static void ex7() {
		// 7. while 문과 Scanner의 nextLine() 메소드를 이용해서 다음 실행 결과와 같이 키보드로부터
		// 입력된 데이터로 예금, 출금, 조회, 종료 기능을 제공하는 코드를 작성해보세요
		// CRUD(Create, Read, Update, Delete)프로그램 작성할 계획
		boolean isStop = false;
		Scanner sc = new Scanner(System.in);
		int balance = 0;
		while (!isStop) {
			menu();
			System.out.print("선택>");
			int jobSelect = sc.nextInt();
			switch (jobSelect) {
			case 1 -> {
				System.out.print("예금액>");
				int amount = sc.nextInt();
				balance += amount;
			}
			case 2 -> {
				System.out.print("출금액>");
				int amount = sc.nextInt();
				balance -= amount;
			}
			case 3 -> {
				System.out.println("잔고:" + balance);
			}
			case 4 -> {
				isStop = true;
			}
			default -> {
				System.out.println("지원되지않는 작업임. 다시입력하세요");
			}
			}
		}
		sc.close();
		System.out.println("프로그램 종료");
	}

	private static void menu() {
		System.out.println("----------------------------------");
		System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
		System.out.println("----------------------------------");

	}

	private static void ex6_1() {
		// 1줄 1칸~5칸
		// 2줄 1칸~4칸
		// 5줄 1칸~1칸
		int end = 5;
		for (int i = 1; i <= end; i++) {
			for (int j = 1; j <= end + 1 - i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}

	}

	private static void ex6() {
		// 1줄 1칸~1칸
		// 2줄 1칸~2칸
		// 5줄 1칸~5칸
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}

	}

	private static void ex5() {
		// 5. 중첩 for 문을 이용하여 방정식 4x + 5y = 60의 모든 해를 구해서 (x, y) 형태로 출력하는 코드
		// 를 작성해보세요. 단, x와 y는 10 이하의 자연수입니다
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60) {
					System.out.printf("%d, %d\n", x, y);
				}
			}
		}
	}

	private static void ex4() {
		while (true) {
			int su1 = (int) (Math.random() * 10) + 1;
			int su2 = (int) (Math.random() * 10) + 1;
			System.out.println(su1 + "---- " + su2);
			if (su1 + su2 == 5)
				break;
		}

	}

	private static void call11() {
		// 무작위 실수 : 0보다 크거나 같고~1보다 작다 0.????? 0<=??<1
		System.out.println(Math.PI);
		System.out.println(Math.ceil(10.1));
		System.out.println(Math.floor(10.9));
		System.out.println((int) (Math.random() * 6) + 1);

	}

	private static void call10() {
		int ans = 0;
		for (int i = 0; i <= 100; i += 3) {
			ans += i;

		}
		System.out.println(ans);
		System.out.println((3 + 99) * 33 / 2);
	}

	private static void call9() {
		String grade = "B";
		int score1 = 0;
		switch (grade) {
		case "A" -> {
			score1 = 100;
		}

		case "B" -> {
			int result = 100 - 20;
			score1 = result;
		}

		default -> {
			score1 = 60;
		}
		}
		System.out.println(score1);
	}

	private static void call8() {
		String grade = "B";
		int score1 = 0;
		switch (grade) {
		case "A":
			score1 = 100;
			break;
		case "B":
			int result = 100 - 20;
			score1 = result;

		default:
			score1 = 60;
		}
		System.out.println(score1);
	}

	// 4단은 제외한다.
	private static void call7() {
		aa: for (int gop = 1; gop <= 9; gop++) {
			for (int dan = 2; dan <= 9; dan++) {
				if (dan == 4)
					continue;
				// if(dan==4) break;
				// if(dan==4) continue aa;
				// if(dan==4) break aa;
				System.out.printf("%2d*%2d=%2d ", dan, gop, dan * gop);
			}
			System.out.println(); // 줄바꾸기
		}

	}

	private static void call6() {
		// 구구단 2~9
		for (int dan = 2; dan <= 9; dan++) {
			System.out.println("-----" + dan + "단-------");
			// if(dan==4) break; //4단부터 제외 (이후 : 포함?OK)
			if (dan == 4)
				continue; // 4단만 제외
			for (int gop = 1; gop <= 9; gop++) {
				System.out.printf("%2d * %2d = %2d\n", dan, gop, dan * gop);
			}

		}

	}

	private static void call5() {
		int i;
		for (i = 0; i <= 100; i += 5) {
			// if(i==15) break; //반복문 빠져나가기
			if (i == 15)
				continue; // 아래문장들은 무시하고 반복문은 계속
			System.out.println(i);

		}
		System.out.println("----------------------");
	}

	private static void call4() {
		// 1~5출력
		int su = 1;
		do {
			System.out.println(su);
			su++;

		} while (su <= 5);

	}

	private static void call3() {
		// 1~5출력
		int su = 1;
		while (su <= 5) {
			System.out.println(su);
			su++;

		}

	}

	private static void call2() {
		// 1~100까지 합
		int total = 0, total2 = 0;
		for (int su = 1, su2 = 5; su <= 100; su++, su2 += 5) {
			total += su;
			total2 += su2;

		}
		System.out.println(total);
		System.out.println(total2);
	}

	private static void call() {
		// 1.for문 : for(초기값;조건;증감)
		int i;
		for (i = 1; i <= 10; i++) {
			System.out.println("--------" + i);
		}
		System.out.println("i=" + i);
	}

}
