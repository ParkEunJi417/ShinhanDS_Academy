package com.shinhan.day05;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person(20,"홍길동");
		
		p1.selfIntroduce();
		p2.selfIntroduce();
		
		System.out.println(Person.getPopulation());
//		System.out.println(p1.getPopulation());
//		System.out.println(p2.getPopulation());

	}

}
