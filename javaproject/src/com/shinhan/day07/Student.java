package com.shinhan.day07;

// class : object를 만들기 위한 틀, object들의 공통 속성 및 메서드 정의
// object : class를 이용해서 생성된(new) 독립된 개체 (= instance)
// Modifier:
// 1)접근권한 : public > protected > default(생략) > private
// 2)활용방법 : final, static, ...
// final : 마지막(변경불가), 선언 or 생성시 1회만 할당
// JAVA beans(object)기술 : private

public class Student {
	// 1.field(공통 속성, 변수) : instance 변수(non-static), class변수(static)
	private String name;
	private int age;
	static String company1="신한1";
	static String company5;
	final String company2="신한2";
	final String company3;
	final String company4;
	static final String COMPANY6="신한6"; // 상수 : 관례상 대문자로 작성, 선언 or static block에서 초기화
	static final String COMPANY7;
	
	// 2.constructor(생성자) : - new시에 자동으로 호출되는 함수
	//						  - 정의없으면 컴파일시 자동으로 삽입(default 생성자, param 없음), 초기화가 목적
	//						  - 정의있으면 컴파일시 삽입 안됨
	//						  - instance 변수가 자동 초기화
	//						  - 생성자의 Overloading → 이름 같고 매개변수 다름
	Student(){
		System.out.println("Student 생성시 실행(생성자)-arg없음");
		company3="신한3";
	}
	Student(String name, int age){
		System.out.println("Student 생성시 실행(생성자)-arg있음");
		company3="신한3";
	}
	// 3.block : instance block(생성시마다), static block
	{
		System.out.println("Student 생성시 실행(instance block)");
		company4="신한4";
	}
	static {
		System.out.println("Student load시 실행");
		company5="신한5";
		COMPANY7="신한7";
	}
	
	// 4.일반 method(기능)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// 5.inner class
}
