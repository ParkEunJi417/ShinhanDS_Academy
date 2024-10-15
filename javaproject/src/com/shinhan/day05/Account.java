package com.shinhan.day05;

public class Account {
	public static int count; // load시 자동 초기화
	String accNo; // new로 생성시 자동초기화
	int balance;
	
	Account(String accNo, int balance){
		this.accNo=accNo;
		this.balance=balance;
		count++;
		print(" 계좌가 개설");
	}
	
	void print(String message) {
		System.out.println(accNo+message+"되었습니다.");
		System.out.println(accNo+" 계좌의 잔고는 "+balance+"원입니다.");
	}

	void deposit(int amount) {
		balance += amount;
		print(" 계좌에 "+amount+"원이 입금");
	}
	
	void withdraw(int amount) {
		balance -= amount;
		print(" 계좌에 "+amount+"원이 출금");
	}

	int getBalance() {
		return balance;
	}
	
	String getAccNo() {
		return accNo;
	}
}
