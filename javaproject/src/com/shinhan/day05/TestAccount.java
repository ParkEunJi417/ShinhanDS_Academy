package com.shinhan.day05;

public class TestAccount {
	public static void main(String[] args) {
		Account acc = new Account("078-3762-293", 1000000);
		acc.deposit(2000000);
		acc.withdraw(500000);
		
		System.out.println("--------------");
		Account acc2 = new Account("078-3762-293",1000);
		acc2.deposit(200);
		acc2.withdraw(50);
		
		System.out.println("계좌 개수:"+Account.count);
	}
}
