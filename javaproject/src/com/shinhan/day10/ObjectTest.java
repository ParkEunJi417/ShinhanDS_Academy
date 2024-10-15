package com.shinhan.day10;

import java.util.HashSet;

public class ObjectTest {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
		f7();
	}

	private static void f7() {
		BookDTO2 book = BookDTO2.builder()
				.title("자바")
				.price(50000)
				.build();
		System.out.println(book);
	}

	private static void f6() {
		BookDTO book = new BookDTO("자바다",30000);
		BookDTO book2 = new BookDTO("자바다",30000);
		System.out.println(book.price());
		System.out.println(book.title());
		System.out.println(book.toString());
		
		System.out.println(book.equals(book2));
	}

	private static void f5() {
		HashSet<Student> set = new HashSet<Student>();
		set.add(new Student("홍길동1",100,"컴공"));
		set.add(new Student("홍길동2",100,"컴공"));
		set.add(new Student("홍길동3",100,"컴공"));
		set.add(new Student("홍길동4",100,"컴공"));
		set.add(new Student("홍길동5",200,"컴공"));
		
		System.out.println(set);
	}

	private static void f4() {
		Student obj1 = new Student("홍길동1",100,"컴공");
		Student obj2 = new Student("홍길동2",100,"컴공");
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(System.identityHashCode(obj2));
		
		System.out.println(obj1==obj2?"주소같음":"주소다름");
		System.out.println(obj1.equals(obj2)?"내용같음":"내용다름");
	}
	
	private static void f3() {
		Integer obj1 = new Integer(100);
		Integer obj2 = new Integer(100);
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(System.identityHashCode(obj2));
		
		System.out.println(obj1==obj2?"주소같음":"주소다름");
		System.out.println(obj1.equals(obj2)?"내용같음":"내용다름");
	}
	
	private static void f2() {
		String obj1 = new String("Java");
		String obj2 = new String("Java");
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(System.identityHashCode(obj2));
		
		System.out.println(obj1==obj2?"주소같음":"주소다름");
		System.out.println(obj1.equals(obj2)?"내용같음":"내용다름");
	}
	
	private static void f1() {
		Object obj1 = new Object();
		Object obj2 = new Object();
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(System.identityHashCode(obj2));
		
		System.out.println(obj1==obj2?"주소같음":"주소다름");
		System.out.println(obj1.equals(obj2)?"내용같음":"내용다름");
	}
}
