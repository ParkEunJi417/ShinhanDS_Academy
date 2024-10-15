package com.shinhan.day11;

import java.util.ArrayList;

public class GenericTest {
	public static void main(String[] args) {
//		method1();
//		method2();
//		method3();
		Box<String, String> result1 = boxing("AA","BB");
		Box<String, Integer> result2 = boxing("AA",100);
		Box<Integer, Integer> result3 = boxing(1,100);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}

	public static <T, A> Box<T, A> boxing(T content, A size) {
		Box<T, A> aa = new Box<>(content, size);
		return aa;
	}

	private static void method3() {
		ArrayList<String> alist = new ArrayList<>();
		alist.add("java1");
		alist.add("java2");
		alist.add("java3");
		alist.add("java4");

		for (String s : alist) {
			System.out.println(s);
		}

		/*
		 * ▼ java에서 선호하지 않는 코드 ArrayList alist = new ArrayList(); alist.add(100);
		 * alist.add("java"); alist.add(new CellPhone("ABC"));
		 * 
		 * int a = (Integer) alist.get(0); String a2 = (String) alist.get(1); CellPhone
		 * a3 = (CellPhone) alist.get(2);
		 */
	}

	private static void method2() {
		Product<CellPhone, String> product1 = new Product<>();
		CellPhone phone = new CellPhone("ABC");
		Product<CellPhone, String> product2 = new Product<>(phone, "A", "large", 100);

		System.out.println(product2);
	}

	private static void method1() {
//		Box<String, String> box1 = new Box<String, String>();
		Box<String, String> box1 = new Box<>();
		box1.content = "문자";
		box1.size = "large";

		Box<String, String> box2 = new Box<>("커피", "A");
		Box<String, Integer> box3 = new Box<>("커피", 200);
	}
}
