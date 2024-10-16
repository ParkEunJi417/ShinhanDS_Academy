package com.shinhan.day13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.shinhan.day12.Account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Thread : 하나의 process내의 프로그램 흐름, run() 구현
// 1)java.lang.Thread 상속 → new MyThread1()
class MyThread1 extends Thread {

	MyThread1() {
		super("MyThread1"); // Thread의 이름 부여
	}

	@Override
	public void run() {
		System.out.println(currentThread().getName() + " / MyThread1 구현한다");
	}
}

// 2)Runnable interface 구현 → Thread 만듬, new Thread(new MyRunnable())
class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " / MyRunnable 구현한다");
	}
}

// Generic : 사용시 타입을 결정
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Product<T, A> {
	T model;
	A size;
}

class ChildProduct<T, A, B> extends Product<T, A> {
	B color;

	ChildProduct(T model, A size, B color) {
		super(model, size);
		this.color = color;
	}
}

@ToString
class Shopping {
	static void f1(Goods<?> g) { // 매개변수 : 모두
		System.out.println("f1");
	}

	static <T,A> void f2(Goods<? extends Product<T,A>> g) { // 매개변수 : Product 상속받은 타입만 가능
		System.out.println("f2");
	}
	
	static <T, A, B> void f3(Goods<? super ChildProduct<T, A, B>> g) { // 매개변수 : ChildProduct 상위 타입만 가능
		System.out.println("f3");
	}

	static <T, A> Product<T, A> makeProduct(T model, A size) {
		return new Product<>(model, size);
	}

	static <T, A, B> ChildProduct<T, A, B> makeChildProduct(T model, A size, B color) {
		return new ChildProduct<>(model, size, color);
	}
}

@AllArgsConstructor
@ToString
class Goods<T> {
	T aa;
}

public class Review {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
		f5();
		System.out.println(Thread.currentThread().getName() + "END");
	}

	private static void f5() {
		Product<String, Integer> p1 = Shopping.makeProduct("ABC", 100);
		Product<Integer, Account> p2 = Shopping.makeProduct(100, new Account("123", "홍길동", 1000));
		ChildProduct<String, String, String> p3 = Shopping.makeChildProduct("AA", "big", "red");
		
		Goods<String> g1 = new Goods<>("TEST");
		Goods<Product<String, Integer>> g2 = new Goods<>(p1);
		Goods<ChildProduct<String, String, String>> g3 = new Goods<>(p3);
		
		Shopping.f1(g1);
		
		Shopping.f2(g2);
		Shopping.f2(g3);
		
		Shopping.f3(g2);
		Shopping.f3(g3);
	}

	private static void f4() {
		Product<String, Integer> p1 = Shopping.makeProduct("ABC", 100);
		Product<Integer, Account> p2 = Shopping.makeProduct(100, new Account("123", "홍길동", 1000));

		ChildProduct<String, String, String> p3 = Shopping.makeChildProduct("AA", "big", "red");
		
	}

	private static void f3() {
		Product<String, Integer> p = new Product<>("TV", 1000);
		Product<Integer, Account> p2 = new Product<>(2000, new Account("123", "홍길동", 1000));
		System.out.println(p);
		System.out.println(p2);
	}

	private static void f2() {
		ExecutorService service = Executors.newFixedThreadPool(5);
		// return이 없으면 Runnable, 있으면 Callable
		Future<?> future = service.submit(new Runnable() {

			@Override
			public void run() {

			}

		});
	}

	private static void f1() {
		int a = 10;
		a++;
		final int score = a;
		Thread t1 = new MyThread1();

		// t2~t4는 모두 Runnable
		Thread t2 = new Thread(new MyRunnable());
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " / 익명 구현 class(score=" + score + ")");
			}
		});
		Thread t4 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + score + " / 람다표현식");
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
