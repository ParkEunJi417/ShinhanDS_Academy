package com.shinhan.day05;

/*
 * class : 틀, template, object들을 만들기 위한 정의, object들의 공통 특성
 * object : class를 이용해서 만든 독립된 개체(멤버마다 field값이 다름), new로 생성
 */
public class Computer /* extends Object */{
	// 1.field(특징, 속성, 변수:멤버변수, static변수)
	String productName;
	String os;
	int price;
	static int count;
	
	// 2.constructor : - new시에 자동호출되는 함수(method)
	//				     → 이 때, 자동 초기화(정수:0, 실수:0.0, boolean:false, 객체는 null)
	//				   - 정의가 없으면 컴파일시에 자동으로 만들어줌. Computer(){}
	//				   - 정의하면 컴파일시에 자동으로 추가되지 않음
	//				   - 초기화가 목적
	//				   - Overloading : 이름 같고 매개변수 사양이 다름
	//				   - 생성자를 호출하는 문장은 반드시 첫주만 작성 가능
	Computer(){
		// super(); → 가 항상 생략되어있어서 무조건적으로 상속받음
		this(null,null,0);
		System.out.println("Computer의 default 생성자");
	}
	
	Computer(String productName, String os){
//		this.productName=productName;
//		this.os=os;
		this(productName,os,0);
	}
	
	Computer(String productName, String os, int price){
		// 구분을 하기 위해 객체 자신을 this 사용
		// productName=productName; → 매개변수 이름과 field 이름이 충돌
		this.productName=productName;
		this.os=os;
		this.price=price;
		count++;
		System.out.println("Computer 생성됨");
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	// 3.method : - 일반적으로 외부에 접근하기 위해 public으로 공개
	//			  - 함수는 반드시 returnType 정의해야함
	//			  - 이름과 returnType이 필수
	//			  - return이 없으면 void
	// 			  - {}은 block → 문장들의 묶음
	// 			  - method Overloading : 이름같고 매개변수 사양이 다름
	
	void sum() {
		System.out.println("argument가 없는 sum method");
	}
	
	int sum(int a, int b) {
		System.out.println("argument가 2개 sum method");
		
		return a+b;
	}
	
	// 가변길이 매개변수(배열)
	int sum(int...arr) {
		int total=0;
		
		for(int su:arr) {
			total += su;
		}
		return total;
	}
	
	String sum(int a, int b, int c) {
		System.out.println("argument가 3개 sum method");
		
		return a+b+c+"";
	}
	
	public void infoPrint() {
		System.out.println("----Computer 정보----");
		System.out.println(getProductName()+"/"+productName);
		System.out.println(getOs()+"/"+os);
		System.out.println(getPrice()+"/"+price);
	}
	
	// 4.block
	
	// 5.inner class
}
