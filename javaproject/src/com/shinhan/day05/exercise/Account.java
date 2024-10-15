package com.shinhan.day05.exercise;
// 6강 19번 문제
public class Account {
	private int balance;
	final static int MIN_BALANCE=0;
	final static int MAX_BALANCE=1000000;
	
	void setBalance(int balance) {
		if(balance >= MIN_BALANCE && balance <= MAX_BALANCE) {
			this.balance = balance;
		}
	}
	
	int getBalance() {
		return balance;
	}
	
	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(10000);
		System.out.println("현재 잔고: " + account.getBalance()); //현재 잔고: 10000
		account.setBalance(-100);
		System.out.println("현재 잔고: " + account.getBalance()); //현재 잔고: 10000
		account.setBalance(2000000);
		System.out.println("현재 잔고: " + account.getBalance()); //현재 잔고: 10000
		account.setBalance(300000);
		System.out.println("현재 잔고: " + account.getBalance()); //현재 잔고: 300000
	}
}
