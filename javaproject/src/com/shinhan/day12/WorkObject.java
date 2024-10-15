package com.shinhan.day12;

// 공유data
public class WorkObject {

	// synchronized일때만 wait()과 notify() 가능
	public synchronized void methodA() {
		System.out.println(Thread.currentThread().getName()+" methodA실행");
		notify(); // 일시정지상태에 있는 다른 Thread가 실행대기상태로 감
		try {
			wait(); // 나의 Thread가 일시정지상태로 감
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public synchronized void methodB() {
		System.out.println(Thread.currentThread().getName()+" methodB실행");
		notify(); // 일시정지상태에 있는 다른 Thread가 실행대기상태로 감
		try {
			wait(); // 나의 Thread가 일시정지상태로 감
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
