package com.shinhan.day06;

public class PrinterTest {
	public static void main(String[] args) {
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();

		if (obj1 == obj2) {
			System.out.println("같은 ShopService 객체입니다.");
		} else {
			System.out.println("다른 ShopService 객체입니다.");
		}
	}

	public static void f1(String[] args) {
		Printer.println2(10);
		Printer.println2(true);
		System.out.println("static method");

		Printer printer = new Printer();

		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동");
		System.out.println("instance method");
	}
}
