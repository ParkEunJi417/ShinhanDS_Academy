package com.shinhan.day12;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// 규격서 : 상수+추상메서드+ ...
interface MyInterface1{
	void print();
}

// 구현class
class MyClassImpl1 implements MyInterface1{

	@Override
	public void print() {
		System.out.println("구현class");
		
	}
	
}

public class LamdaTest {

	public static void main(String[] args) {
		// 1.구현class
		MyInterface1 a1 = new MyClassImpl1();
		
		// 2.익명구현class
		MyInterface1 a2 = new MyInterface1() {

			@Override
			public void print() {
				// TODO Auto-generated method stub
				
			}
		};
		
		// 3.람다표현식
		MyInterface1 a3 = ()->{
			System.out.println("람다표현식");
		};
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("익명구현class");
			}
		};
		
		Runnable r2 = ()->{
				System.out.println("람다");
			};
		
//		Thread t1 = new Thread(r2);
//		t1.start();
		
		ExecutorService service = Executors.newFixedThreadPool(5);
//		service.execute(r2);
		service.execute(()->{
			System.out.println("이렇게도 가능");
		});
		
		Future<Integer> f = service.submit(new Callable<>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});
		
		System.out.println("main끝");
		
//		a1.print();
//		a2.print();
//		a3.print();
	}
}
