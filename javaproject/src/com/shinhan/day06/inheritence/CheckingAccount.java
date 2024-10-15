package com.shinhan.day06.inheritence;

// class 정의시 상속의 정의가 없으면 자바의 모든 class는 무조건 Object를 상속받음
// 자바는 다중상속 없음
// 자식은 부모의 private 제외한 모든 field와 method 사용 가능

public class CheckingAccount extends Account{
	// 부모를 물려받고 추가요소가 있음
	String cardNo;
	
	int pay(String cardNo, int amount) {
		if(cardNo.equals(this.cardNo)) {
			return withdraw(amount);
		}
		System.out.println("카드번호가 다르면 지불불가");
		return 0;
	}
	
	// Java 관련 기술들은 JavaBeans 기술 사용 : default 생성자가 있어야함
	// Jsp, Servlet, Sping, Mybatis, JPA ...
	CheckingAccount(){
		super(); // 항상 생략되어있음, 첫줄에서만 사용 가능
//		System.out.println("2.CheckingAccount 생성자(자식)");
	}
	
	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		// 명시적으로 생성자를 호출
		super(accountNo, ownerName, balance);
		
		// 부모 변수가 private이기 때문에 setter만 사용 가능 → 이렇게 사용하면 불편하기에 위 코드사용
//		setAccountNo(accountNo);
//		setOwnerName(ownerName);
//		setBalance(balance);
		this.cardNo=cardNo;
	}

	// 부모class 접근 가능한지 점검
//	void test() {
//		// 자식은 부모의 private 접근불가
//		System.out.println(getAccountNo());
//		System.out.println(getOwnerName());
//		System.out.println(getBalance());
//		deposit(1000);
//		withdraw(2000);
//	}
}
