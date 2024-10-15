package com.shinhan.day12;

import lombok.Setter;

@Setter
public class PrintThread2 extends Thread {
	
	boolean stop;
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println("실행중▶"+stop);
		}
		System.out.println("자원정리");
		System.out.println("안전하게 Thread 종료");
	}
}
