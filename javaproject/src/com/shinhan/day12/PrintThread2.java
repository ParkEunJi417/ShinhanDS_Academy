package com.shinhan.day12;

import lombok.Setter;

@Setter
public class PrintThread2 extends Thread {

	boolean stop;

	@Override
	public void run() {
		/* 1번 방법
		while (!stop) {
			System.out.println("실행중▶" + stop);
		}
		*/
		
		// 2번 방법
		try {
			while (!stop) {
				System.out.println("실행중▶" + stop);
				sleep(1);
			}
		} catch (InterruptedException ex) {

		}

		System.out.println("자원정리");
		System.out.println("안전하게 Thread 종료");
	}
}
