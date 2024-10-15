package com.shinhan.day06;

import java.util.Arrays;

public class 멤버쉽VIP {
	public static void main(String[] args) {
//		int[] periods = {8, 23,24 };
//		int[][] payments = {{100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  100000, 100000, 100000, 100000}, 
//				{100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000},
//		        {350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}};
//		int[] estimates = { 100000, 100000, 100000};
		
		// 가입기간(4명의 정보)
		int[] periods = {24, 59, 59, 60};
		
		// 12개월의 납부요금
		int[][] payments = {{50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000,50000, 50000, 50000}, 
				            {50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}, 
				            {350000, 50000,50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
				            {50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}};
		// 다음달 납부 예정 금액
		int[] estimates = {350000,50000,40000,50000}; 
		
		int[] result = new 멤버쉽VIP().solution(periods, payments, estimates);
		System.out.println(Arrays.toString(result));
	}

	private int[] solution(int[] periods, int[][] payments, int[] estimates) {
		// [0]:이번달에 VIP아닌데 다음달에 VIP 선정, [1]:이번달에 VIP인데 다음달에 VIP 탈락 고객수
		int[] result = new int[2]; // 자동 초기화됨 {0,0}
		
		for(int i=0;i<periods.length;i++) {
			// 이번달
			int thisMonthTotal = 0;
			for(int j=0;j<payments[i].length;j++) {
				thisMonthTotal += payments[i][j];
			}
			
			boolean isVip1 = isVip(periods[i], thisMonthTotal);
						
			// 다음달
			int nextMonthTotal = 0;
			nextMonthTotal = thisMonthTotal + estimates[i] - payments[i][0];
			boolean isVip2 = isVip(periods[i]+1, nextMonthTotal);
			
			if(!isVip1 && isVip2) result[0]++;
			else if(isVip1 && !isVip2) result[1]++;
		}
		
		return result;
	}

	private boolean isVip(int periods, int total) {
		if(periods >= 5*12) {
			if(total >= 600000) {
				return true;
			}
		}
		else if(periods >= 2*12) {
			if(total >= 900000) {
				return true;
			}
		}
		
		return false;
	}
}
