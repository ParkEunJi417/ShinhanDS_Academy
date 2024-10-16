package com.shinhan.day12;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(of= {"accountNo","ownerName"})
@ToString
public class Account {
	String accountNo; // 계좌번호
	String ownerName; // 예금주 이름
	int balance; // 잔액

	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public void deposit(int amount) {
		balance += amount;
	}

	int withdraw(int amount) {
		if (balance < amount)
			return 0;
		balance -= amount;
		return amount;
	}

	public char[] getBalance() {
		// TODO Auto-generated method stub
		return null;
	}
}
