package com.shinhan.day12;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShareArea {
	Account lee;
	Account sung;
	
	// 동기화 : synchronized
	// 공유영역을 사용중일때 다른 쓰레드가 접근 불가
	public synchronized void transfer() {
		int amount = lee.withdraw(100);
		System.out.println(amount + "만원 lee계좌에서 출금");

		sung.deposit(amount);
		System.out.println(amount + "만원 sung계좌에 입금");
		System.out.println(Thread.currentThread().getName()+"--------------------------");
	}
	
	public synchronized void print() {
		int amount = lee.balance + sung.balance;
		System.out.println("잔고는 " + amount);
		System.out.println(Thread.currentThread().getName()+"****************");
	}
}
