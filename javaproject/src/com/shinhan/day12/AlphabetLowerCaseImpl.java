package com.shinhan.day12;

// 2. 이미 다른 class를 상속받고 있다면 Runnable Interface를 구현함 → Thread로 만들기 가능함
public class AlphabetLowerCaseImpl extends Object implements Runnable {

	@Override
	public void run() {
		// a~z 출력
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.println(Thread.currentThread().getName() + "/" + ch);
		}
	}

}
