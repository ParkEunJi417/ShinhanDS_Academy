package com.shinhan.day08;

interface Z4{
	void f4();
}

interface Z3{
	void f3();
}

// 인터페이스는 다중 상속 가능
interface Z2 extends Z3,Z4{
	void f2();
}

interface Z{
	void f1();
}

class Student implements Z,Z2{
	public void f1() {}
	public void f2() {}
	public void f3() {}
	public void f4() {}
}

public class InterfaceTest2 {
	public static void main(String[] args) {
		
	}
}
