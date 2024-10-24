package com.shinhan.day15.exam2;
import com.shinhan.day10.MyException;

public class Prob2 {

	public static void main(String[] args) {
			System.out.println(leftPad("Samsung", 10, '#'));
			System.out.println(leftPad("SDS", 5, '*'));
			System.out.println(leftPad("Multicampus", 5, '@'));

	}

	public static String leftPad(String str, int size, char fillChar) {
		String result="";
		StringBuilder sb = new StringBuilder();
		
		try {
			if(str.length() > size) {
				throw new IllegalSizeException("문자열의 길이보다 size가 큽니다.");
			}
			
			for(int i=1;i<=size-str.length();i++) {
				sb.append(fillChar);
			}
			sb.append(str);
			result = sb.toString();
			
		}catch(IllegalSizeException e){
			e.f1();
		}
		return result;
	}

}

class IllegalSizeException extends Exception {
	String message2;
	
	public IllegalSizeException(String message){
		super(message); // getMessage()하면 message가 나옴
		this.message2=message;
	}
	void f1() {
		System.out.println(message2);
	}
}