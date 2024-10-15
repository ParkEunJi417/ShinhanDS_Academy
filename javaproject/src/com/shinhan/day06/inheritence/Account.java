package com.shinhan.day06.inheritence;

// public : 모든 패키지의 모든 class 접근 가능
// protected : 같은 패키지의 모든 class 접근 가능, 다른 패키지이면 상속받으면 가능
// 생략 : 같은 패키지의 모든 class 접근 가능
// private : 해당 class에서만 접근 가능

// 부모 == 상위 class == super class
public class Account extends Object {
	public String accountNo;
	public String ownerName;
	public int balance;

	public Account(){
//		System.out.println("1.CheckingAccount 생성자(부모)");
	}
	
	public Account(String accountNo, String ownerName, int balance) {
		//super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public void deposit(int amount) {
		balance += amount;
	}

	public int withdraw(int amount) {
		if (balance < amount) {
			System.out.println("잔액이 부족합니다.");
			return 0;
		}
		balance -= amount;
		return amount;
	}
	
	void print() {
		System.out.println("==================");
		System.out.println("Account에 추가됨");
		System.out.println("==================");
	}

//	public String getAccountNo() {
//		return accountNo;
//	}
//
//	public void setAccountNo(String accountNo) {
//		this.accountNo = accountNo;
//	}
//
//	public String getOwnerName() {
//		return ownerName;
//	}
//
//	public void setOwnerName(String ownerName) {
//		this.ownerName = ownerName;
//	}
//
//	public int getBalance() {
//		return balance;
//	}
//
//	public void setBalance(int balance) {
//		this.balance = balance;
//	}
}
