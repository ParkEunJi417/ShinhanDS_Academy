package com.shinhan.day04;

public class Phone {
	// 1.field
	// private : 정보은닉, 캡슐화함
	// this : 객체 자신을 의미
	//		  1) 매개변수 이름과 field 이름이 같은 경우 구분을 위해
	//		  2) 생성자의 Overlaoding에서 하나의 생성자가 다른 생성자 호출시
	private String model, company;
	private int price;
	
	Phone(){
		model="AA";
		company="Samsung";
		price=100;
	}
	
	Phone(String model){
		this(model,"S",0);
	}
	
	Phone(String model, String company){
		this(model,company,0);
	}
	
	Phone(String model, String company, int price){
		this.model=model;
		this.company=company;
		this.price=price;
	}
	
	void print() {
		System.out.println("----Phone정보----");
		System.out.println("model→"+model);
		System.out.println("company→"+company);
		System.out.println("price→"+price);
	}
}
