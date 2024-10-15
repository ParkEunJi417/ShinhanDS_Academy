package com.shinhan.day07;

public class App {
	public static void main(String[] args) {
		Cat ani1 = new Cat("야옹이",10);
		Dog ani2 = new Dog();
		work(ani1);
		work(ani2);
		// 추상은 new 불가
//		Animal ani = new Dog();
//		ani.sound();
	}
	public static void work(Animal aa) {
		aa.sound();
	}
}
