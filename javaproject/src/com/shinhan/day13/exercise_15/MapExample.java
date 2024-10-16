package com.shinhan.day13.exercise_15;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);

		String name = null; // 최고 점수를 받은 아이디를 저장하는 변수
		int maxScore = 0; // 최고 점수를 저장하는 변수
		int totalScore = 0; // 점수 합계를 저장하는 변수

		for(String key:map.keySet()) {
			int score = map.get(key);
			totalScore += score;
			if(score > maxScore) {
				maxScore = score;
				name = key;
			}
		}
		
		System.out.println("평균 점수:"+ (double)totalScore/map.size());
		System.out.println("최고 점수:"+maxScore);
		System.out.println("최고 점수를 받은 아이디:"+name);
	}
}
