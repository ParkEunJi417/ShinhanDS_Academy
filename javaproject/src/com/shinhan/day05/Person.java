package com.shinhan.day05;

public class Person {
	// field : instance 변수(non-static 변수), class 변수(static 변수)
	// 전체 인구수, Person 객체가 생성될 때마다 증가, class 변수로 선언되어야함(instance들이 공유)
	static int numberOfPersons=0;
	int age;
	String name;
	
	public Person(){
		this(12,"Anonymous");
	}
	
	public Person(int age, String name){
		this.age = age;
		this.name = name;
		numberOfPersons++;
	}

	void selfIntroduce() {
//		System.out.printf("내 이름은 %s이며, 나이는 %d살 입니다.\n",name,age);
		System.out.println("내 이름은 "
				+ name
				+ "이며, 나이는 "
				+ age
				+ "살입니다.");
	}
	
	static int getPopulation() {
		return numberOfPersons;
	}
	
/*
  public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person(20,"홍길동");
		
		p1.selfIntroduce();
		p2.selfIntroduce();
		
		System.out.println(Person.getPopulation());
//		System.out.println(p1.getPopulation());
//		System.out.println(p2.getPopulation());
	}
*/
}
