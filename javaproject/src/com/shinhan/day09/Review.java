package com.shinhan.day09;

// [Modifier] : public or 생략 / abstract, final(상속불가)
abstract class Parent1{
	// field의 modifier : public > protected > 생략 > private / final, static
	int field1 = 100;
	
	// method의 modifier : public > protected > 생략 > private / final, static
	void method1() {
		System.out.println("method1 - field1="+field1);
	}
	
	// constructor 추가되면 default 생성자가 자동으로 만들어지지 않음
	Parent1(String s){
		
	}
	
	// 규칙(정의)만 있고 구현은 없음 → 추상(abstract)
	abstract void work();
}

interface MyInterface1{
	// public abstract 가 항상 생략되어있음
	void action1();
	void action2();
}

interface MyInterface2{
	void action3();
}

// interface는 다중 상속 가능
interface MyInterface3 extends MyInterface1, MyInterface2{
	void action4();
}

// 구현 class : 여러개의 interface를 구현 가능
class Child1 extends Parent1 implements MyInterface1, MyInterface2{
	
	String childField2="java";
	
	Child1(){
		super("");
	}
	public void action1() { System.out.println("MyInterface1 action1"); }
	public void action2() { System.out.println("MyInterface2 action2"); }
	public void action3() { System.out.println("MyInterface3 action3"); }
	
	void work() {
		
	}
	
	// Override : 이름, 매개변수, 리턴 모두 같음
	@Override
	void method1() {
		System.out.println("method1 override - field1="+field1);
	}
	
	public void method1(int a) {
		System.out.println("method1 overloading- field1="+field1);
	}
	
	void method2() {
		System.out.println("부모의 field 접근:"+field1);
		method1();
	}
}

public class Review {
	public static void main(String[] args) {
		Child1 a = new Child1();
		
		// 자동형변환
		Parent1 b =a;
		MyInterface1 c = a;
		MyInterface1 d = a;
		
		new Review().display(a);
	}
	
	// instance method
	void display(Object aa) {
		// 강제 형변환시 반드시 instance를 체크
		((Parent1)aa).method1();
		
		MyInterface1 bb = (MyInterface1) aa;
		bb.action1();
		bb.action2();
		
	}
}
