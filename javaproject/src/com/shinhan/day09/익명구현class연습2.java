package com.shinhan.day09;

interface RemoteControl{
	public abstract void turnOn();
	void turnOff();
}

class ARemoteControl implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println(getClass().getSimpleName()+"turnOn");
	}

	@Override
	public void turnOff() {
		System.out.println(getClass().getSimpleName()+"turnOff");
	}
	
}

class BRemoteControl implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println(getClass().getSimpleName()+"turnOn");
	}

	@Override
	public void turnOff() {
		System.out.println(getClass().getSimpleName()+"turnOff");
	}
	
}

public class 익명구현class연습2 {
	public static void main(String[] args) {
		RemoteControl a1 = new ARemoteControl();
		RemoteControl a2 = new BRemoteControl();
		work(new ARemoteControl());
		work(new BRemoteControl());
		
		int score=100;
		System.out.println("score="+score);
		work(new RemoteControl() {
			// local class
			@Override
			public void turnOn() {
//				score++; → 주의! 지역변수 변경 불가
				System.out.println("익명구현class의 turnOn");
			}
			
			@Override
			public void turnOff() {
				System.out.println("익명구현class의 turnOff");
			}
		});
	}
	
	public static void work(RemoteControl remote) {
		System.out.println("-----------------");
		remote.turnOn();
		remote.turnOff();
	}
}
