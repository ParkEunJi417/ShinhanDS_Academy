package com.shinhan.day12;

// 계좌이체 Thread : 공유영역의 lee계좌+sung계좌 3번 print
public class PrintThread extends Thread {

	ShareArea shareArea;

	PrintThread(String threadName, ShareArea shareArea) {
		super(threadName);
		this.shareArea = shareArea;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			int amount = shareArea.lee.balance + shareArea.sung.balance;
			System.out.println("잔고는 " + amount);
			System.out.println(currentThread().getName()+"****************");
		}
	}
}
