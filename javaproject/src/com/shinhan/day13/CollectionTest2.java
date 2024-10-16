package com.shinhan.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
class Fruit{
	String name;
	int price;
}

@AllArgsConstructor
@Getter @Setter @ToString
class Person2 implements Comparable<Person2> {
	
	String name;
	int age;
	
	// Set은 같으면 add 불가
	// Map은 같으면 덮어쓰기

	@Override
	public int compareTo(Person2 o) {
		// 1은 크다, 0은 같다, -1은 작다
		// Ascending : 음수
		// Descending : 양수
		
		if(age == o.age) // 나이가 같으면 이름으로 Desc
			return o.name.compareTo(name);
		
		return age - o.age; // 나이가 같으면 안들어감 (Set으로 작용)
	}

}

@AllArgsConstructor
@ToString
class Coin{
	int value;
}

public class CollectionTest2 {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
//		f10();
//		f11();
//		f12();
		f13();
	}
	
	private static void f13() {
		String[] arr = {"자바","오라클","프레임워크"};
		List<String> data1 = Arrays.asList(arr);
		// data1.add("추가"); → 수정 불가
		
		System.out.println(Arrays.toString(arr));
		System.out.println(data1);
		
		System.out.println(arr[0]);
		System.out.println(data1.get(0));
	}
	
	private static void f12() {
		Map<String,Integer> data1 = new HashMap<>();
		data1.put("A",1);
		data1.put("B",2);
		data1.put("C",3);
		
		Map<String,Integer> data2 = Map.copyOf(data1);
		// data2.put("D",4); → 수정 불가
		System.out.println(data2);
	}
	
	private static void f11() {
		Set<String> data1 = new HashSet<String>();
		data1.add("A");
		data1.add("B");
		data1.add("C");
		
		Set<String> data2 = Set.copyOf(data1);
		// data2.add("D"); //→ 수정 불가
		System.out.println(data2);
	}
	
	private static void f10() {
		List<String> data1 = new ArrayList<String>();
		data1.add("A");
		data1.add("B");
		data1.add("C");
		
		List<String> data2 = List.copyOf(data1);
		// data2.add("D"); → 수정 불가
		System.out.println(data2);
	}

	private static void f9() {
		Map<String,Integer> data = Map.of("A",100,"B",200,"D",300,"C",400);
		// data.put("E", 555); → 수정 불가
		
		for(String key:data.keySet()) {
			System.out.println(key+" / "+data.get(key));
		}
	}

	private static void f8() {
		List<Integer> data = List.of(100,200,300);
		// data.add(200); → 수정 불가
		for(Integer i:data) {
			System.out.println(i);
		}
		
		// 중복불가
		Set<Integer> data2 = Set.of(400,100,200,300);
		// data2.add(500); → 수정 불가
		for(Integer i:data2) {
			System.out.println(i);
		}
		

	}

	private static void f7() {
		// ArrayList : 동기화 처리 안됨
		//				→ Collections.synchronizedList() 동기화 처리 가능
		// Vector : 멀티쓰레드에 안정적(동기화 처리됨)
		List<Integer> data = Collections.synchronizedList(new ArrayList<Integer>()); 
		
		Thread a = new Thread() {
			@Override
			public void run() {
				for(int i=1;i<=1000;i++) {
					data.add(i);
				}
			}
		};
		
		Thread b = new Thread() {
			@Override
			public void run() {
				for(int i=1001;i<=2000;i++) {
					data.add(i);
				}
			}
		};
		
		a.start();
		b.start();
		
		try {
			a.join();
			b.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("List에 저장된 data 갯수:"+data.size());
	}

	private static void f6() {
		// Queue interface : 구현class → LinkedList...
		Queue<Coin> data = new LinkedList<>();
		data.offer(new Coin(300));
		data.offer(new Coin(500));
		data.offer(new Coin(100));
		data.offer(new Coin(200));
		
		// while(data.size()>0) {
		while(!data.isEmpty()) {
			System.out.println(data.poll());
		}
		System.out.println("Stack 비어있음");
	}
	
	private static void f5() {
		// Stack class : LIFO
		Stack<Coin> data = new Stack<>();
		data.push(new Coin(100));
		data.push(new Coin(100));
		data.push(new Coin(100));
		
		// while(data.size()>0) {
		while(!data.isEmpty()) {
			System.out.println(data.pop());
		}
		System.out.println("Stack 비어있음");
	}
	
	private static void f4() {
		// Stack class : LIFO
		Stack<String> data = new Stack<>();
		data.push("월");
		data.push("화");
		data.push("수");
		
		while(data.size()>0) {
			System.out.println(data.pop());
		}
		System.out.println("Stack 비어있음");
	}

	private static void f3() {
//		TreeMap<Fruit,Integer> map = new TreeMap<>(new Comparator<Fruit>() {
//
//			@Override
//			public int compare(Fruit o1, Fruit o2) {
//				return o1.price-o2.price;
//			}
//			
//		});
		TreeMap<Fruit,Integer> map = new TreeMap<>((o1,o2)->o1.price-o2.price);
		
		map.put(new Fruit("A1",1000), 1);
		map.put(new Fruit("A3",2000), 2);
		map.put(new Fruit("A4",4000), 3);
		map.put(new Fruit("A5",3000), 4);
		map.put(new Fruit("A2",5000), 5);
		
		for(Fruit fruit:map.keySet()) {
			System.out.println(fruit+" / "+map.get(fruit));
		}
	}

	private static void f2() {
		// Map을 상속받아 TreeMap, HashMap..
		Map<Person2, Integer> map = new HashMap<>();
		TreeMap<Person2, Integer> data = new TreeMap<>();
		data.put(new Person2("A1",10), 100);
		data.put(new Person2("A4",20), 300);
		data.put(new Person2("A2",20), 400);
		data.put(new Person2("A3",30), 200);
		data.put(new Person2("A5",50), 2000);

		System.out.println(data.firstKey());
		System.out.println(data.firstEntry());
		System.out.println(data.lastKey());
		System.out.println(data.lastEntry());
		
		System.out.println("------------------------------------");

		NavigableMap<Person2, Integer> navi = data.descendingMap(); // key로 descending
		for (Entry<Person2, Integer> entry : navi.entrySet()) {
			System.out.println(entry.getKey() + " / " + entry.getValue());
		}
	}

	private static void f1() {
		// Map을 상속받아 TreeMap, HashMap..
		Map<String, Integer> map = new HashMap<>();
		TreeMap<String, Integer> data = new TreeMap<>();
		data.put("A1", 100);
		data.put("A2", 300);
		data.put("A3", 400);
		data.put("A4", 200);
		data.put("A4", 2000); // 같은 키가 있으면 Map은 덮어쓰기

		System.out.println(data.firstKey());
		System.out.println(data.firstEntry());
		System.out.println(data.lastKey());
		System.out.println(data.lastEntry());

		NavigableMap<String, Integer> navi = data.descendingMap(); // key로 descending
		for (Entry<String, Integer> entry : navi.entrySet()) {
			System.out.println(entry.getKey() + " / " + entry.getValue());
		}
	}
}
