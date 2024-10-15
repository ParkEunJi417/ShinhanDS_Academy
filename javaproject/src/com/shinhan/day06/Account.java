package com.shinhan.day06;
// 6강 19번 문제

// modifier
// 1)접근권한 : public > protected > default(생략) > private
// private는 외부에서 접근 불가이므로 외부에서 접근하려면 반드시 접근하는 기능을 제공해야함(setter, getter)
// 2)활용방법 : static, final, abstract, synchronized, sealed, ...
public class Account {
	// 변수
	private int balance;

	// 상수 : static → class소유, final → 최종(값 변경불가)
	// 선언시 또는 static block에서 반드시 초기화
	final static int MIN_BALANCE = 0;
	final static int MAX_BALANCE = 1000000;

	void setBalance(int balance) {
		if (balance >= MIN_BALANCE && balance <= MAX_BALANCE) {
			this.balance = balance;
		}
	}

	int getBalance() {
		return balance;
	}

	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(10000);
		System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 10000
		account.setBalance(-100);
		System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 10000
		account.setBalance(2000000);
		System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 10000
		account.setBalance(300000);
		System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 300000
	}
}
