package com.shinhan.day09;

abstract class Tire {
	public abstract void roll();
}

class KumhoTire extends Tire {
	@Override
	public void roll() {
		System.out.println("금호타이어가 굴러갑니다(재정의)");
	}
}

class Car {
//	Tire tire1 = new Tire(); → 추상 class는 인스턴스 생성 불가
	Tire tire2 = new KumhoTire();
	Tire tire3 = new Tire() {
		public void roll() {
			System.out.println("AA타이어가 굴러갑니다");
		}
	};

	void method() {
		Tire tire4 = new KumhoTire();
		Tire tire5 = new Tire() {
			public void roll() {
				System.out.println("BB타이어가 굴러갑니다");
			}
		};

		call(tire2);
		call(tire3);
		call(tire4);
		call(tire5);
	}

	private void call(Tire t) {
		t.roll();
	}
}

public class 익명구현class연습 {
	public static void main(String[] args) {
		Car c = new Car();
		c.method();
	}
}
