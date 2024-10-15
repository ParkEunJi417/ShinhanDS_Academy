package com.shinhan.day05.hw;

import java.util.Arrays;

public class membershipVip {
	final static int YEAR = 12; // 1년을 상수로 선언

	public int[] solution(int[] periods, int[][] payments, int[] estimates) {
		int[] result = new int[2];

		for (int i = 0; i < periods.length; i++) {
			int period = periods[i]; // i번째 고객의 현재 가입기간
			int totalPay = 0; // i번째 고객의 현재 납부내역
			
			// i번째 고객의 연간 납부 금액
			totalPay = totalPay + Arrays.stream(payments[i]).sum();

//			for (int j = 0; j < payments[i].length; j++) {
//				totalPay += payments[i][j];
//			}

			// 이번달은 아니지만 다음달에 vip
			if (!isVip(period, totalPay)) {
				period++;
				totalPay = totalPay + estimates[i] - payments[i][0];

				if (isVip(period, totalPay))
					result[0]++;
			}
			// 이번달은 vip지만 다음달에 아님
			else {
				if (isVip(period, totalPay)) {
					period++;
					totalPay = totalPay + estimates[i] - payments[i][0];

					if (!isVip(period, totalPay))
						result[1]++;
				}
			}
		}
		return result;
	}

	// 기간과 연간 납부 금액으로 vip인지 아닌지 확인
	private boolean isVip(int period, int totalPay) {
		if (totalPay >= 900000) {
			if (period >= 2 * YEAR)
				return true;
		}

		else if (totalPay >= 600000) {
			if (period >= 5 * YEAR)
				return true;
		}
		
		return false;
	}
}
