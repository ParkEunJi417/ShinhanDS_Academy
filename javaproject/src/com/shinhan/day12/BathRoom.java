package com.shinhan.day12;

public class BathRoom {
	boolean isFirst = true;

	public synchronized void use(String name) {
		if(isFirst && name.equals("김")) {
			try {
				wait(); // 깨워줄때까지 기다림
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} 
		}
		
//		System.out.println(Thread.currentThread().getName());
		System.out.println(name +"님이 입장");
		System.out.println(name +"님이 사용");
		System.out.println(name +"님이 퇴장");
		System.out.println("-----------");
		isFirst=false;
		
		notifyAll(); // 깨워주는 함수
	}
}
