package com.shinhan.day15.exam2_teacher;

public class Prob2 {

	public static void main(String[] args) {
		System.out.println(leftPad("Samsung", 10, '#'));
		System.out.println(leftPad("SDS", 5, '*'));
		System.out.println(leftPad("Multicampus", 5, '@'));

	}

	public static String leftPad(String str, int size, char fillChar) {

		try {
			if (str.length() > size) {
				throw new IllegalSizeException("문자열의 길이보다 size가 큽니다.");
			}
		} catch (IllegalSizeException e) {
			return e.getMessage();
		}
		String result="";
		for(int i=0;i<=size-str.length();i++) {
			result += fillChar;
		}
		
		return result+str;
	}

}

class IllegalSizeException extends Exception {
	IllegalSizeException(String message) {
		super(message);
	}
}
