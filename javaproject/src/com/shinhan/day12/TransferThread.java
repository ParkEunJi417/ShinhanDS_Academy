package com.shinhan.day12;

// 계좌이체 Thread : 공유영역의 lee계좌에서 sung계좌로 12번 이체
public class TransferThread extends Thread {

	ShareArea shareArea;

	TransferThread(String threadName, ShareArea shareArea) {
		super(threadName);
		this.shareArea = shareArea;
	}

	// 동기화 블록 : 공유영역을 사용중일때 다른 thread가 접근 금지
	@Override
	synchronized public void run() {
		shareArea.transfer();
		shareArea.print();
//		for (int i = 1; i <= 12; i++) {
//			int amount = shareArea.lee.withdraw(100);
//			System.out.println(amount + "만원 lee계좌에서 출금");
//
//			shareArea.sung.deposit(amount);
//			System.out.println(amount + "만원 sung계좌에 입금");
//			System.out.println(currentThread().getName()+"--------------------------");
//		}
	}
	
}
