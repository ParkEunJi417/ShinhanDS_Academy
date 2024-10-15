package com.shinhan.day06.exercise;

// class : template, 틀
public class Account {
	// 1.field : 값 저장(정보은닉, 캡슐화), 일반적으로 외부에서 직접 수정, 접근 불가하도록
	private String accNo;
	private String owner;
	private int balance;

	// 2.생성자 : 값 초기화시 setter 이용하거나 생성자 이용
	public Account(String accNo, String owner, int balance) {
		this.accNo=accNo;
		this.owner=owner;
		this.balance=balance;
	}

	// 3. 일반 매서드중에 값 제공, 값 변경 메서드 구현 getter/setter
	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
