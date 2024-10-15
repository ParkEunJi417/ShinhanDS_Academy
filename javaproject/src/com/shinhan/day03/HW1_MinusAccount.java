package com.shinhan.day03;

public class HW1_MinusAccount {
	public static void main(String[] args) {
		int balance; // 마이너스통장 잔고액

		balance=5000;
		int[] request1= {10000, -13000, -4000, -2000, 6500, -20000};
		System.out.println("첫번째 요청 처리 후 잔고:"+solution(balance,request1));
		
		balance=34151;
		int[] request2= {-34152, -40000, -50000};
		System.out.println("두번째 요청 처리 후 잔고:"+solution(balance,request2));
	}

	private static int solution(int m, int[] ledger) {
		int result=0; // 결과값
		
		for(int money:ledger) {
				if(result+money >= -m) {
					result += money;
					System.out.println(result);
				}
		}
			return result;
	}
}
