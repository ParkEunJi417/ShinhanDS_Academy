package com.shinhan.day10.hw;

import java.util.Arrays;
import java.util.HashMap;

public class 계좌번호분석 {
	public static void main(String[] args) {
		// {"1-2-3-:3", "3-5-4-":4}
		// HashMap<String, Integer> map = new HashMap<>();
		// map.put("1-2-3-", map.getOrDefault("aa", 0));
		// int cnt = map.getOrDefault("aa", 0);
		// System.out.println(cnt);
	}
	
	public static void f(String[] args) {
		계좌번호분석 e = new 계좌번호분석();
		int[] result = e.solution(new String[] {"4514--234495-1","305-44-291501","1-2-34-495-8623","492134545151","623-421523-67-341","-5439-59639921","6235-7X3+47-7456","98-76-543-210","512-73-634901","000-999999-22-555","064-82-792561"
		,"1-2-3-456789012","582845-385823","48572-39485-89012","4-5-2-593328484","4958-39-2945123-","49582039415423","7-3-7-000000000","485723-693812","39482746582734","1-1-1-111111111","A4944-5095-4951","4851293412223"
		,"592356=5345", "49-694-4495-64", "5923565345%"});
		//int[] result = e.solution(new String[] {"1-2-3-456789012","582845-385823","48572-39485-89012","4-5-2-593328484","4958-39-2945123-","49582039415423","7-3-7-000000000","485723-693812","39482746582734","1-1-1-111111111","A4944-5095-4951","4851293412223"});
		//int[] result = e.solution(new String[] { "592356=5345", "49-694-4495-64", "5923565345%" });
		System.out.println(Arrays.toString(result));
	}

	private int[] solution(String[] accounts) {
		HashMap<String, Integer> map = new HashMap<>();
		
		for(String acc:accounts) {
			// 1.유효한지?
			if(!isVaild(acc)) continue;
			
			// 2. 같은 은행 계좌인지? 패턴이 같으면 같은 은행 → 개수
			String bankName = getBankName(acc);
			
			System.out.println(acc+"/"+bankName);
			
			map.put(bankName, map.getOrDefault(bankName, 0)+1);
		}
		return null;
	}

	private String getBankName(String acc) {
		StringBuilder sb = new StringBuilder();
		String[] arr = acc.split("-");
		for(String s:arr) {
			sb.append(s.length()+"-");
		}
		return sb.toString();
	}

	private boolean isVaild(String acc) {
		//
		if(!acc.matches("[0-9-]+")) return false;
		return true;
	}
}