package com.shinhan.day12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

// Collection : List, Set, Map
// List : 순서 있음, 중복 가능 → ArrayList, Vector, LinkedList
//Set : 순서 없음, 중복 없음 → HashSet, TreeSet
public class CollectionTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();
	}
	
	private static void f6() {
		// String class 중복 check : hashcode(), equals() 재정의됨
		// 같은 값은 저장되지 않음
		HashSet<Account> data = new HashSet<>();
		data.add(new Account("123","aaa",100));
		data.add(new Account("123","aaa",200));
		data.add(new Account("123","aaa",300));

		for(Account s:data) {
			System.out.println(s);
		}
	}
	
	private static void f5() {
		// String class 중복 check : hashcode(), equals() 재정의됨
		HashSet<String> data = new HashSet<>();
		data.add("월");
		data.add("월");
		data.add("토");
		data.add("토");
		for(String s:data) {
			System.out.println(s);
		}
	}

	private static void f4() {
		List<String> alist = new Vector<>();
		alist.add("월");
		alist.add("토");
		alist.add("토");
		alist.add("일");
//		print(alist);
		System.out.println(alist.contains("토"));
		System.out.println(alist.size()+" size");
		
		/*
		alist.sort(new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				// TODO Auto-generated method stub
				return a.compareTo(b);
			}
			
		});
		*/
		alist.sort((a,b)->b.compareTo(a));
		print(alist);
	}

	private static void f3() {
		List<String> alist = new LinkedList<>();
		alist.add("월");
		alist.add("토");
		alist.add("토");
		alist.add("일");
		print(alist);
	}
	
	private static void f2() {
		ArrayList<String> alist = new ArrayList<>();
		alist.add("월");
		alist.add("토");
		alist.add("토");
		alist.add("일");
		print(alist);
	}

	private static void print(List<String> alist) {
		for(String s:alist) {
			System.out.println(s);
		}
		
	}

	private static void f1() {
		ArrayList alist = new ArrayList();
		alist.add(100);
		alist.add("자바");
		alist.add(new Account("123","aaa",0));
		
		int a = (Integer) alist.get(0);
		String a2 = (String) alist.get(1);
		Account a3 = (Account) alist.get(2);
	}
}
