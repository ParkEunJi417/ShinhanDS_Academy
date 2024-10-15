package com.shinhan.day07;

public abstract class Machine extends Object {
	public void powerOn() {
		// new한 현재 class의 이름
		System.out.println(getClass().getSimpleName()+"전원켠다");
	}

	public void powerOff() {
		System.out.println(getClass().getSimpleName()+"전원끈다");
	}

	// 정의있고 구현은 없음. 구현은 자식이 함
	public abstract void work();
}
