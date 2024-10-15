package com.shinhan.day07;

public class Computer extends Machine {
	public void work() {
		System.out.println("Computer class가 구현함");
	}
	public static void main(String[] args) {
		Computer c1 = new Computer();
		c1.powerOn();
		c1.powerOff();
		c1.work();
	}
}
