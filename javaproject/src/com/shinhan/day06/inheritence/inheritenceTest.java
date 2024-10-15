package com.shinhan.day06.inheritence;

public class inheritenceTest {

	public static void main(String[] args) {
		// f1();
		// f2();
		// f3();
		// f4();
		// f5();
		// f6();
		// f7();
		// f8();
		call();
	}

	private static void call2(Tire[] arr){
		for(Tire t:arr) {
			// 다형성 : 사용법은 같지만 결과가 다름
			t.roll();
			
			// t instanceof HankookTire 변수명 → 12버전부터 가능
			if(t instanceof HankookTire hankook) {
				hankook.display();
			}
		}
	}
	
	private static void call() {
		Tire[] arr = new Tire[2];
		arr[0] = new KumhoTire();
		arr[1] = new HankookTire();
		
		call2(arr);
	}

	private static void f9(Object aa) {
		System.out.println(aa);
		if (aa instanceof String s) { // aa가 String이면 s에 aa를 형변환에서 값 할당
//			String s = (String) aa;
			int len = s.length();
			System.out.println("길이:" + len);
		}
	}

	private static void f8() {
		String s1 = "이것이 자바다";
		Integer i = 100;

		f9(s1);
		f9(i);

//		System.out.println("문자열의 길이:" + s1.length());
	}

	private static void f7() {
		// 형 변환(자동, 강제)
		int a;
		char ch = 'A';

		// 1.기본형 자동 형변환 : 큰방 = 작은값
		a = ch;

		System.out.println(a);

		// 2.기본형 강제 형변환 : 작은방 = (작은방 타입)큰값
		ch = (char) a;
		System.out.println(ch);

		// 객체의 형변환
		// 1.자동 형변환 : 부모 = 자식
		// 2.강제 형변환 : 자식 = (자식)부모

		Dog animal1 = new Dog();
		Cat animal2 = new Cat();

		useAnimal(animal1);
		useAnimal(animal2);

//		animal1.sing();
//		animal1.fly();
//		
//		animal2.sing();
//		animal2.fly();

	}

	private static void useAnimal(Animal aa) {
		// 다형성 : 사용법은 같지만 결과가 다름
		aa.sing();
		aa.fly();

//		Cat cat = (Cat)aa; → 컴파일시 오류 없음, 실행시 aa가 Cat이 아니면 오류
		if (aa instanceof Cat) {
			Cat cat = (Cat) aa;
			cat.play();
		}
	}

	private static void f6() {
		Account acc1 = new Account();
		BonusPointAccount acc2 = new BonusPointAccount(null, null, 1000, 0);
		CheckingAccount acc3 = new CheckingAccount(null, null, 2000, null);
		CreditLineAccount acc4 = new CreditLineAccount(null, null, 3000, 0);

		acc1.deposit(100);
		acc2.deposit(100);
		acc3.deposit(100);
		acc4.deposit(100);

		acc1.print();
		acc2.print();
		acc3.print();
		acc4.print();

		System.out.println(acc1.balance);
		System.out.println(acc2.balance);
		System.out.println(acc3.balance);
		System.out.println(acc4.balance);
	}

	private static void f5() {
		BonusPointAccount acc1 = new BonusPointAccount("123", "aa", 1000, 1);
		acc1.deposit(5000);
		System.out.println("잔고:" + acc1.balance);
		System.out.println("포인트:" + acc1.bonusPoint);
	}

	private static void f4() {
		CreditLineAccount acc1 = new CreditLineAccount("123", "aa", 1000, 500);
		acc1.deposit(2000);
		System.out.println(acc1.balance);

		int amount = acc1.withdraw(3600);
		System.out.println("잔고:" + acc1.balance);
		System.out.println("출금:" + amount);
	}

	private static void f2() {
		CheckingAccount acc = new CheckingAccount();
		acc.accountNo = "12345";
		acc.ownerName = "홍길동";
		acc.balance = 1000;
		acc.cardNo = "777";

		acc.deposit(200);
		System.out.println(acc.balance);
		acc.withdraw(2000);
	}

	private static void f1() {
		CheckingAccount acc = new CheckingAccount("12345", "홍길동", 1000, "777");

	}

	private static void f3() {
		Child ch = new Child();
		ch.f1();
		// ch.f2();
	}

}
