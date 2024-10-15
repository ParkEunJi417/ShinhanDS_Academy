package com.shinhan.day08.hw;

import java.util.Arrays;

public class 경매낙찰금액 {
	public static void main(String[] args) {
		// testcast 2개로 TEST
		int[] n = { 4, 6 }; // 물품갯수
		int[][] amounts = { { 1000000, 490000, 700000, 290000 }, { 30000, 70000, 10000 } };// 참가자들의 자본
		경매낙찰금액 ex = new 경매낙찰금액();

		for (int i = 0; i < n.length; i++) {
			System.out.println("==========testcase " + i + "번째");
			int[] result = ex.solution(n[i], amounts[i]);
			System.out.println(Arrays.toString(result));
		}
	}

	// n:물품개수, m:참가자수, amounts:초기자본
	private int[] solution(int n, int[] amounts) {
		int m = amounts.length;
		int[] result = new int[n];
		int[][] person = new int[m][2];

		// 참가자 번호부여
		for (int i = 0; i < m; i++) {
			person[i][0] = i + 1;
			person[i][1] = amounts[i];
		}

		for (int i = 0; i < n; i++) {
			// 자본 많은순, 자본 같으면 번호순
			Arrays.sort(person, (a, b) -> b[1] - a[1] == 0 ? a[0] - b[0] : b[1] - a[1]);

			for (int j = 0; j < m; j++) {
				if (person[j][1] > person[j + 1][1]) {
					person[j][1] -= person[j + 1][1] + 10000;
					result[i] = person[j + 1][1] + 10000;
					break;
				}
				else if(person[j][1] == person[j+1][1]) {
					result[i] = person[j][1];
					person[j][1] = 0;
					break;
				}
			}
		}

		return result;
	}

}
