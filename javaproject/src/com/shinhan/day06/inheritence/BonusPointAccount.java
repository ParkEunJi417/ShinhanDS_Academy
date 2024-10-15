package com.shinhan.day06.inheritence;

public class BonusPointAccount extends Account{
	int bonusPoint;
	
	BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint){
		super(accountNo, ownerName, balance);
		this.bonusPoint=bonusPoint;
	}

	// 입금을 Override(시그니처가 같아야함)
	// annotation : 컴파일러가 해석하는 주석
	@Override
	public void deposit(int amount) {
		
		// 부모의 코드 호출
		super.deposit(amount);
		bonusPoint += amount * 0.001; // 복합연산자는 자동 형변환
	}
	
	// 출금을 그대로 물려받아 사용
}
