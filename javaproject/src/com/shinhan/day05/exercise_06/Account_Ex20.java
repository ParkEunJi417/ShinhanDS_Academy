package com.shinhan.day05.exercise_06;

public class Account_Ex20 {
	String account;
	String name;
	int balance;

	public Account_Ex20(String account, String name, int balance) {
		this.account=account;
		this.name=name;
		this.balance=balance;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
