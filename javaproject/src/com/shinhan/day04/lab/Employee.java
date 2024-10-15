package com.shinhan.day04.lab;

// Object class의 toString() 메서드는 구현되어 있음
// 객체 출력시 자동으로 toString()메서드 호출됨
// 재정의가 가능(Override) : 이름 & 매개변수 & returnType 같고, 접근지정자는 같거나 더 넓어져야함
// 접근지정자 : public > protected > 생략 > private
// public : 모든 패키지에서 접근 가능
// protected : 같은 패키지이면 접근 가능, 다른 패키지이면 상속 받으면 가능
// 생략 : 같은 패키지에서만 접근 가능
// private : 같은 클래스 안에서만 접근 가능

public class Employee extends Object{
	private String id;
	private String name;
	private int baseSalary;
	
	// 일반적으로 생성자의 접근지정자는 class의 접근지정자와 같음
	public Employee(String id, String name, int baseSalary){
		this.id=id;
		this.name=name;
		this.baseSalary=baseSalary;
	}
	
	public double getSalary(double bonus) {
		return baseSalary + baseSalary * bonus;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName(String name) {
		return this.name;
	}
	
	public void setBaseSalary(int baseSalary) {
		this.baseSalary=baseSalary;
	}
	public int getBaseSalary() {
		return this.baseSalary;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public String getId(String id) {
		return id;
	}
	
	public String toString() {
		return name
				+"("
				+ id
				+") 사원의 기본급은 "
				+ baseSalary
				+"원 입니다.";
	}
}
