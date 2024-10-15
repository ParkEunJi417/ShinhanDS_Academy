package com.shinhan.day12;

// 1. thread 만들기 : Tread 상속받기
public class AlphabetUpperCaseThread extends Thread {

	@Override
	public void run() {
		// A~Z 출력
		for(char ch='A';ch<='Z';ch++) {
			System.out.println(currentThread().getName()+"/"+ch);
		}
	}
	
}
