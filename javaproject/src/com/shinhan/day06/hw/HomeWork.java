package com.shinhan.day06.hw;

public class HomeWork {

	public static void main(String[] args) {
//		int n = 2;
		int n = 3;

		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int result = 0;
		
		// i를 나머지로 생각해서 풀이
		for(int i=1; i<n; i++) {
			result += i*n + i;
		}
		
		/* 첫번째로 문제를 직관적으로만 풀이한 결과
		int i=n+1;
		
		while(true) {
			if(i/n == i%n) { 
				result += i;
			}
			
			if(++i/n >= n)
				break;
		}*/
		
		return result;
	}
}
