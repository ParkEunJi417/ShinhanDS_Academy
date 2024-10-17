package com.shinhan.day14;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

// 1.Array : 연속공간, 같은타입, 고정개수
// 2.Collection interface : 연속공간 | 연속공간X, 같은타입 | 같은타입X, 동적
// 3.List interface : 넣는 순서 있음(index가 있음), 중복허용 → ArrayList, LinkedList, Vector
// 4.Set interface : - 넣는 순서 없음(index가 없음), 중복허용X(add시 check ▶ hashcode(), equals()로 check, 같으면 넣지 않음)
//					 - HashSet, TreeSet(add시 비교해서 순서대로 넣음 ▶ Comparable or Comparator의 compare() 구현 필수)
// 5.Map interface : Key, Value의 쌍으로 이루어짐, Key는 Set임(Key가 같으면 덮어쓰기)

// 함수가 1개인 인터페이스는 람다표현식 사용 가능
interface MyInterface{
	void method();
}

// 1.구현class
class MyClass implements MyInterface{
	public void method() {
		System.out.println("1.구현class");
	}
}

class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("구현class");
	}
	
}

public class Review {

	public static void main(String[] args) {
//		f1_ListTest();
//		f1_SetTest();
//		f2();
//		f3();
		f4();
	}

	private static void f4() {
		Thread thread = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("익명구현class");
			}
		});
		thread.start();
		
		Thread thread2 = new Thread(()->{});
		thread2.start();
	}

	private static void f3() {
		// 2.익명 구현 및 즉시 실행
		(new MyInterface() {
			
			@Override
			public void method() {
				System.out.println("2.익명 구현 및 즉시 실행");
			}
		}).method();
		
		
		MyInterface a = new MyInterface() {
			
			@Override
			public void method() {
				System.out.println("2.익명 구현");
			}
		};
		
		MyInterface b = ()-> {System.out.println("3.람다");};
		b.method();
	}

	private static void f2() {
//		List<Person> a = new ArrayList<>();
//		Set<Person> a = new HashSet<>();
//		Map<Person,Integer> a = new HashMap<>();
		Map<Person,Integer> a = new TreeMap<>(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.age-o1.age;
			}
			
		});
		a.put(new Person("A",10),100);
		a.put(new Person("D",20),100);
		a.put(new Person("C",40),100);
		a.put(new Person("E",30),100);
		a.put(new Person("B",50),100);
		
		System.out.println(a.size());
		
		for(Person p:a.keySet()) {
			System.out.println(p+" "+a.get(p));
		}
	}

	private static void f1_SetTest() {
//		Set<Integer> a = new HashSet<>();
//		Set<Integer> a = new TreeSet<>();
		Set<Integer> a = new TreeSet<>();
		a.add(10);
		a.add(30);
		a.add(50);
		a.add(40);
		a.add(20);
		a.add(20);
		
		System.out.println(a);
	}

	private static void f1_ListTest() {
//		List<Integer> a = new ArrayList<>();
//		List<Integer> a = new LinkedList<>();
		List<Integer> a = new Vector<>();
		a.add(10);
		a.add(0,30);
		a.add(50);
		a.add(40);
		a.add(20);
		
		System.out.println(a);
	}
}
