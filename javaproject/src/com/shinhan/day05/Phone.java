package com.shinhan.day05;

//class ModifierTest{
//	void test() {
//		Phone p1 = new Phone();
//		System.out.println(p1.a+p1.b+p1.c);
//		p1.print1();
//		p1.print2();
//		p1.print3();
//	}
//}

// final : 최종, 변경 불가
// 1.field에 사용하면 값 변경 불가
// 2.method에 사용하면 재정의 불가
// 3.class에 사용하면 상속 불가

public class Phone {
	public String model;
	public int price;
	
	// 값 할당 후 수정불가 → instance 변수이므로 선언시 혹은 생성시 값을 반드시 할당!
	public final String company = "aa";
	public final String company2;
	
	// 선언시 반드시 초기화 → 상수, 관례상 이름은 대문자 사용
	public final static String COMPANY3 = "cc";
	
	// 생성자 접근권한 : public, 생략, private
	public Phone(){
		company2 = "bb";
	}
	
	private Phone(String s){
		company2 = s;
	}
	
	// 접근 제한자 Test
	// public > protected > 생략(default) > private
	// 모든 패키지는 모든 class에서 접근 가능
	public int a=10;
	
	// 같은 패키지는 모든 class에서 접근 가능, 다른 패키지면 상속받아 사용
	protected int b=20;
	
	// default, modifier생략, 같은 패키지에서만 접근 가능
	int c=30;
	
	// private : class 내부에서만 접근 가능
	private int d=40;
	
	void test() {
		System.out.println(a+b+c+d); 
		print1();
		print2();
		print3();
		print4();
	}
	
	public void print1() {
		System.out.println("Phone class의 public method");
	}
	
	protected void print2() {
		System.out.println("Phone class의 protected method");
	}
	
	void print3() {
		System.out.println("Phone class의 default method");
	}
	
	private void print4() {
		System.out.println("Phone class의 private method");
	}
}
