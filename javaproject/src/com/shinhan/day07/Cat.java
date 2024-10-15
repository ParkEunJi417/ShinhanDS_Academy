package com.shinhan.day07;

public class Cat extends Animal{
	Cat(String name, int size){
		super(name, size);
	}
	
	@Override
	void sound() {
		System.out.println("야옹");		
	}
}
