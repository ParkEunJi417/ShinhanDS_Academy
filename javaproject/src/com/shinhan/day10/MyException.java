package com.shinhan.day10;

// 예외로 사용하고자함
// Exception 를 상속받았으므로 일반 예외임
// ID는 5자리 이하여야함
public class MyException extends Exception {
	
	String message2;
	
	public MyException(String message){
		super(message); // getMessage()하면 message가 나옴
		this.message2=message;
	}
	
	void f1() {
		System.out.println(message2);
	}
}
