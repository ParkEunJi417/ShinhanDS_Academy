package com.shinhan.day15.exam2_teacher;

public class Prob1 {
	public static void main(String[] args) {
		String[] array={"황남기85점","조성호89점","한인성88점","독고정진77점"};
		printMaxScore(array);
	}	
	
	private static void printMaxScore(String[] array){
		String maxName=null;
		int maxScore=0;
		
		for(String str:array) {
			String name="";
			String score="";
			char[] charArr = str.toCharArray();
			
			for(char ch:charArr) {
				if(Character.isDigit(ch)) {
					score+=ch;
				}else {
					name+=ch;
				}
			}
			name = name.substring(0,name.length()-1);
			int iscore = Integer.parseInt(score);
			
			if(iscore > maxScore) {
				maxScore = iscore;
				maxName = name;
			}
		}
		/* 강사님 답안1
		String maxName=null;
		int maxScore=0;
		String regExp="([ㄱ-힣]+)([0-9]+)점";
		
		Pattern pattern = Pattern.compile(regExp);
		
		for(String str:array) {
			Matcher matcher = pattern.matcher(str);
			if(matcher.find()) {
				String name = matcher.group(1);
				int score = Integer.parseInt(matcher.group(2));
				
				if(score > maxScore) {
					maxScore = score;
					maxName = name;
				}
			}
		}*/
		System.out.println("최고점수는 " + maxName + "님 " + maxScore + "점 입니다.");
	}	
}
