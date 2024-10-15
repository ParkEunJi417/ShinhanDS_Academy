package com.shinhan.day06;

import com.shinhan.day05.Phone;

public class ModifierTest2 extends Phone { // 부모에게 상속받으면 본인거로 판단하기에 객체참조변수 불필요
	
	public static void main(String[] args) {
		String s1="자바";
		String s2=new String("자바");
		byte[] bytes= {65,66,67};
		String s3=new String(bytes);
		
		System.out.println(s3);
		//f2();
	}
	
	public static void f2() {
		// static final
		System.out.println(Integer.MAX_VALUE);
		
		// static method
		System.out.println(Integer.bitCount(7));
		
		Integer a=new Integer(10); // 10
		Integer b=new Integer(1); // 1
		
		// instance method
		System.out.println(a.compareTo(b));
	}
	
	void test2() {
		Phone p1 = new Phone();
		System.out.println(a+b);
		
		print1();
		print2();
	}
	
	
}
/*
public class ModifierTest2{ 
	
	void test2() {
		Phone p1 = new Phone();
		System.out.println(p1.a+p1.b+p1.c);

		p1.print1();
		p1.print2();
		p1.print3();
	}
*/