package com.shinhan.day15.exam2;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prob1 {
	public static void main(String[] args) {
		String[] array={"황남기85점","조성호89점","한인성88점","독고정진77점"};
		printMaxScore(array);
	}	
	
	private static void printMaxScore(String[] array){
		String maxName=null;
		int maxScore=-1;

		for(int i=0;i<array.length;i++) {
				int num1 = Integer.parseInt(array[i].replaceAll("[^0-9]", ""));
				if(maxScore < num1) {
					maxScore = num1;
					maxName = array[i].replaceAll("[0-9]", "").replace("점", "");
				}
		}
		System.out.println("최고점수는 " + maxName + "님 " + maxScore + "점 입니다.");
	}	
}
