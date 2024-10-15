package com.shinhan.day05;

// cmd>java CarTest
// class load → static은 method 영역으로 올라감

public class CarTest {

	public static void main(String[] args) {
		System.out.println(Car.company);
		Car.print();
		
		// instance field와 method는 객체 생성 후 사용 가능
		Car c1 = new Car();
		Car c2 = new Car();
//		System.out.println(c1.company); // static 변수이기 때문에 권장하지 않음
//		System.out.println(c2.company); // static 변수이기 때문에 권장하지 않음
//		c1.print(); // static method이기 때문에 권장하지 않음
//		c2.print(); // static method이기 때문에 권장하지 않음
		
		System.out.println(c1.gas);
//		System.out.println(c1.speed);
		
		c1.gas = 10;
//		c1.speed = 100;
		c1.setSpeed(200);
		
		System.out.println(c1.gas);
//		System.out.println(c1.speed);
		System.out.println(c1.getSpeed());
	}

}
