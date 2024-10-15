package com.shinhan.day10;

import java.util.Arrays;
import java.util.HashSet;

class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}

	int play() {
		// 0 <= Math.random() < 1
		// 0 <= Math.random()*8 < 8
		// 1 <= (Math.random()*8)+1 < 9
		int number = (int) (Math.random() * size) + 1;
		return number;
	}
}

public class DiceGame {
	public static void main(String args[]) {
		// 1 <= Math.random() * 45 + 1 < 46
		// 0 <= Math.random() < 1
		// 중복없이 1~45인 6개 무작위수를 구하기
		// 1)HashSet 사용
//		HashSet<Integer> random = new HashSet<Integer>();
//
//		while (random.size() < 6) {
//			int su = (int) (Math.random() * 45) + 1;
//			random.add(su);
//		}
//
//		System.out.println(random);


		// 2)Array 사용
		int[] arr = new int[6];
		int index = 0;

		while (index < 6) {
			int su = (int) (Math.random() * 45) + 1;
			for (int i = 0; i < index; i++) {
				if(arr[i] == su)
					break;
			}
			arr[index] = su;
			index++;
		}
		System.out.println(Arrays.toString(arr));

//		DiceGame game = new DiceGame();
//
//		int result1 = game.countSameEye(10);
//		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);
//
//		int result2 = game.countSameEye(-10);
//		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);

	}

	int countSameEye(int n) {
		int noon = 8;
		int count = 0;

		try {
			if (n < 0)
				throw new IllegalArgumentException("던진 횟수는 음수 불가");
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			return 0;
		}

		Dice d1 = new Dice(noon);
		Dice d2 = new Dice(noon);

		for (int i = 1; i <= n; i++) {
			int n1 = d1.play();
			int n2 = d2.play();
			System.out.println("n1:" + n1 + "\tn2:" + n2);

			if (n1 == n2)
				count++;
		}

		return count;
	}
}
