package com.shinhan.day04;

// cmd>java CarTest
// class load
// 검증
// main 시작
public class CarTest {

	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		Car c1, c2 = new Car("B모델","red",6000); 
		Car c3 = new Car("C모델");
		Car c4 = new Car("D모델","black");
		c1 = new Car();
		
		c1.model="모델";
		c1.color="white";
		c1.price=5000;
		
		System.out.println(c1.model+"-"+c1.color+"-"+c1.price);
		System.out.println(c2.model+"-"+c2.color+"-"+c2.price);
		System.out.println(c3.model+"-"+c3.color+"-"+c3.price);
		System.out.println(c4.model+"-"+c4.color+"-"+c4.price);
	}

}
