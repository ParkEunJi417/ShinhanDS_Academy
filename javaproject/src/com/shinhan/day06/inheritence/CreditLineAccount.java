package com.shinhan.day06.inheritence;

public class CreditLineAccount extends Account {
	int creditLine;
	
	CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
		// 명시적 호출
		super(accountNo, ownerName, balance);
		this.creditLine=creditLine;
	}
	
	// Overloading(추가) : 이름이 같고 매개변수 사양이 다름
	int withdraw(int a, int b){
		return a+b;
	}
	
	// 인출하다의 기능 재정의(Override)
	// 이름&매개변수 타입 및 개수& return 같고 modifier가 같거나 더 넓어야함
	public int withdraw(int amount2) {
		if (balance+creditLine < amount2) {
			System.out.println("잔액이 부족합니다.");
			return 0;
		}
		balance -= amount2;
		return amount2;
	}
}
