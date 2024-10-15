package com.shinhan.day03_teacher;

import java.util.Scanner;
//.java ->.class(Byte code)
//cmd>java LAB2
//class load (JVM에 올라온다)

public class LAB2 {
	static Scanner sc;
	static final String 상수이름="100";
	LAB2(){
		
	}
	
    //cmd>java LAB2 10 20 30
	//Eclipse에서 설정하는 경우는 Run Configuration>arguments>Program argument에 입력
	//명령행 args[0] = 10, args[1] = 20, args[2] = 30
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		//q9(args[0]);
		q10();
		sc.close();
	}
	private static int abs(int i, int j) {
		int result = i - j;
		return result<0?result*-1:result;
		//return Math.abs(result);
		
	}
	private static void q10() {
		System.out.println(abs(10,20));
		System.out.println(abs(20,10));
		
		 
		/*
		 * 
		문제2. 두 개의 숫자를 매개 변수로 받아서 두 숫자 사이의 차를 구하되, 
		실행 결과가 음수일 경우 양의 정수로 변경하여 리턴하는 abs() 메서드를 구현하시오.
		(단, 주어진 메서드의 시그니쳐는 변경하지 않는다.)

		 */
		
	}

	

	private static void printSeason(int month) {
		String message = "";
		switch (month) {
			case 12, 1, 2 -> {
				message = "겨울";
			}
			case 3, 4, 5 -> {
				message = "봄";
			}
			case 6, 7, 8 -> {
				message = "여름";
			}
			case 9, 10, 11 -> {
				message = "가을";
			}
			default -> {
				message = "월 오류";
			}
			 
		}
		System.out.println(message + "에 태어나셨네요.");
	}

	private static void q9(String month) {
		//String->int 
		int mon = Integer.parseInt(month);
		printSeason(mon);

		/*
		 * cmd>java LAB2 10
		 * 
		 * 문제1. 자신이 태어난 달을 명령행 매개변수로 받아서 어떤 계절에 태어났는지를 출력하는 printSeason() 메서드를 구현하시오.
		 * (단, 반드시 switch 문을 사용해야 하며 1~12월이 아닌 달을 입력했을 경우 “1~12 사이의 숫자만 입력하셔야 합니다.” 라는
		 * 문자를 출력하도록 해야 한다. 그리고 주어진 메서드의 시그니쳐는 변경하지 않는다.) (봄: 3, 4, 5월, 여름: 6, 7, 8월,
		 * 가을: 9, 10, 11월, 겨울 12, 1, 2월)
		 * 
		 */

	}

	private static int gcd(int su1, int su2) {
		// int minSu = su1>su2?su2:su1;
		int minSu = Math.min(su1, su2);
		for (int i = minSu; i >= 1; i--) {
			if (su1 % i == 0 && su2 % i == 0) {
				return i;
			}
		}
		return 0;
	}

	private static void q8() {
		System.out.println(gcd(2, 5));
		System.out.println(gcd(5, 15));
		System.out.println(gcd(250, 30));

		/*
		 * 최대 공약수는 두 숫자를 공통된 숫자로 나누어도 나머지가 0이 되는 가장 큰 수를 의미합니다. 예를 들어 2와 5의 최대 공약수는
		 * 1입니다. 왜냐하면, 1부터 2까지의 숫자중 공통으로 나눌 수 있는 숫자는 1 뿐이기 때문입니다. 다른 예로, 5와 15의 최대 공약수는
		 * 5가 됩니다. 메소드의 이름은 gcd로 하며, 매개변수는 두개의 정수를 받으며, 리턴 하는 타입 역시 정수입니다.
		 * 
		 * [입력값] 2, 5 5,15 250,30
		 * 
		 * [실행결과] 1 5 10
		 */
	}

	private static void q7() {

		System.out.println("년도 입력 : ");
		int year = sc.nextInt();
		System.out.println("월 입력 : ");
		int month = sc.nextInt();

		// 함수호출(값)
		int day = numDay(year, month);
		System.out.println(year + "년도" + month + "월의 말일 :" + day);

	}

	// 함수정의(변수타입 변수이름)
	public static int numDay(int year, int month) {
		// 구현하세요.
		int day = 0;
		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12 -> {
			day = 31;
		}
		case 4, 6, 9, 11 -> {
			day = 30;
		}
		case 2 -> {
			if (year % 4 == 0 && year % 100 != 0 || year % 100 == 0 && year % 400 == 0) {
				day = 29;
			} else {
				day = 28;
			}
		}

		}
		return day;
	}

	private static void q6() {
		int year = 2025; // 4로 나누어떨어지고 100으로 나누어떨어지지않음 (윤년은 29, 즉,1년366일)
		int month = 2;
		int day = 0;

		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12 -> {
			day = 31;
		}
		case 4, 6, 9, 11 -> {
			day = 30;
		}
		case 2 -> {
			if (year % 4 == 0 && year % 100 != 0 || year % 100 == 0 && year % 400 == 0) {
				day = 29;
			} else {
				day = 28;
			}
		}
		default -> {
			System.out.println("잘못된 월입니다.");
		}
		}
		System.out.println(year + "년 " + month + "월 " + day + "일");

		/*
		 * 문제6 . 주어진 년도의 월에 해당하는 말일을 계산하는 프로그램을 완성하시오. 윤년인 경우에는 다음과 같은 조건에 의해 처리합니다.
		 * [윤년의 조건] 1) 4의 배수인 해는 윤년. 2) 4의 배수이면서 100의 배수인 해는 윤년이 아님. 3) 100의 배수이면서 400의
		 * 배수인 해는 윤년. 평년:2월28 윤년:2월29
		 */

	}

	private static void q5() {
		final int GOAL_NUM = 15; // 목표 값
		int i = 0; // 증가분
		int current_step = 0; // 현재 반복 횟수, GOAL_NUM까지 가기위함
		int result = 1; // 수열 + 증가분
		int total = 0; // 증가된 수열의 합
		while (current_step < GOAL_NUM) {
			result += i++;
			current_step++;
			total += result;
		}
		System.out.printf("%d번째까지의 합: %d", GOAL_NUM, total);

		/*
		 * • 수열 규칙 : 1부터 시작해서 두 항의 차이가 1씩 증가 • 예 시 : 1 + 2 + 4 + 7 + 11 + 16 + 22 + …………
		 * 위의 수열에서 15번째 항까지의 합을 구하는 프로그램을 작성하십시오
		 * 
		 * 
		 * [출력값] 15번째까지의 합 : 575
		 * 
		 */

	}

	private static void q4() {
		int count = 0, total = 0;
		System.out.print("양의 정수를 입력하세요 : "); // 7
		int num = sc.nextInt();
		for (int i = num; i <= 1000; i += num) {
			count++;
			total += i;

		}
		System.out.println();
		System.out.println(num + "의 배수 개수 = " + count);
		System.out.println(num + "의 배수 합 = " + total);

		int count2 = 1000 / num;
		int sum = ((num + count * num) * count2) / 2;
		System.out.println(num + "의 배수 개수 = " + count2);
		System.out.println(num + "의 배수 합 = " + sum);

		/*
		 * 문제4. 임의의 정수를 입력 받아서, 1부터 1,000까지의 수 중에서 입력 받은 정수의 배수의 개수와 배수들의 합을 계산하십시오.
		 */
	}

	// 함수끝나고 돌아갈때 int값을 가지고간다.
	// 5!
	// 5*4*3*2*1
	// 5*4!
	// 5*4*3!
	// 5*4*3*2!
	// 5*4*3*2*1!
	// 5*4*3*2*1*1
	/*
	 * 방법1 private static int factorial(int su) { int answer = 1; for(int
	 * i=1;i<=su;i++) { answer *= i; } return answer; }
	 */
	// 방법2
	private static int factorial(int su) {
		if (su == 1)
			return 1;
		else
			return su * factorial(su - 1);
	}

	private static void q3() {
		System.out.println("2~100사이 정수 : ");
		int num = sc.nextInt();
		if (num < 2 || num > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			return; // 함수빠지기
		}
		for (int i = 1; i <= num; i++) {
			System.out.printf("%d ! = %d \n", i, factorial(i));
		}

		/*
		 * 문제3. 임의의 숫자를 입력 받아 아래와 같은 실행 결과가 나타나는 프로그램을 작성하십시오. 정수 n의 팩토리얼(factorial)은
		 * 1부터 n까지의 모든 정수를 곱한 것으로 n!로 표시합니다. 단 2보다 작거나 9보다 큰 정수가 입력될 경우에는 “잘못된 숫자가
		 * 입력되었습니다.”라는 경고 메시지를 출력하고 프로그램을 종료합니다. 1보다 크고 10보다 작은 정수를 입력하세요. : 5 1 ! = 1 2
		 * ! = 2 3 ! = 6 4 ! = 24 5 ! = 120
		 * 
		 */

	}

	private static void q2_1() {
		System.out.println("2~100사이 정수 : ");
		int num = sc.nextInt();

		boolean isPrime = true;
		// 9->3
		// 4->2
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
		}
		System.out.println(isPrime ? "소수" : "소수아님");

	}

	private static void q2() {
		boolean isPrime = true;
		System.out.print("2 ~ 100사이의 정수를 입력하세요. :");
		int su = sc.nextInt();
		for (int i = 2; i < su; i++) {
			if (su != 2 && su % i == 0) {
				isPrime = false;
				break;
			}
		}
		System.out.println(isPrime ? "소수" : "소수아님");
		/*
		 * 문제2. 소수란 자신과 1외의 다른 수로는 나누어 떨어지지 않는 정수입니다. 아래와 같이 2~100 사이의 숫자를 입력하면 소수인지 여부를
		 * 판별하는 프로그램을 작성하십시오. 2 ~ 100사이의 정수를 입력하세요. : 47 47는(은) 소수입니다.
		 * 
		 */

	}

	// void는 return값이 없음을 의미
	private static void q1() {
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요.:");
		int su = sc.nextInt();
		if (su < 2 || su > 9) {
			System.err.println("잘못된 숫자가 입력되었습니다.");
			return; // 함수빠지기, 호출한곳으로 돌아간다.
		}

		for (int gop = 1; gop <= 9; gop++) {
			// System.out.println(su + "*" + gop + "=" + su*gop);
			System.out.printf("%2d * %2d = %2d\n", su, gop, su * gop);
		}

		/*
		 * 문제1. 1보다 크고 10보다 작은 정수를 입력 받아서 아래와 같은 실행 결과가 나타나도록 Prob1 클래스의 main 메소드를
		 * 완성하십시오. 입력 받은 숫자에 해당하는 구구단을 완성시키는 프로그램입니다. 2보다 작거나 9보다 큰 정수가 입력될 경우에는 “잘못된
		 * 숫자가 입력되었습니다.”라는 경고 메시지를 출력하고 프로그램을 종료합니다. 1보다 크고 10보다 작은 정수를 입력하세요. : 3 3 * 1
		 * = 3 3 * 2 = 6 3 * 3 = 9 ... 3 * 9 = 27
		 * 
		 */

	}

}
