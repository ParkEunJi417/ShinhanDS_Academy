package com.shinhan.day12;

public class MultiThreadTest2 {
	public static void main(String[] args) {
		WorkThread t1 = new WorkThread("A쓰레드");
		WorkThread t2 = new WorkThread("B쓰레드");
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t1.work=false;
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t1.work=true;
	}
	
	public static void main3(String[] args) {
		BathRoom room = new BathRoom();
		Thread thread1 = new BathRoomUseThread(room,"김");
		Thread thread2 = new BathRoomUseThread(room,"박");
		Thread thread3 = new BathRoomUseThread(room,"양");
		Thread thread4 = new BathRoomUseThread(room,"윤");
		
		thread1.setName("김 스레드");
		thread2.setName("박 스레드");
		thread3.setName("양 스레드");
		thread4.setName("윤 스레드");
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

	public static void main2(String[] args) {
		System.out.println(Thread.currentThread().getName()+" 쓰레드 시작");
		
		Account lee = new Account("123", "이몽룡", 2000);
		Account sung = new Account("124", "성춘향", 1000);
		
		ShareArea shareArea = new ShareArea(lee,sung);
		
		Thread thread1 = new TransferThread("이체Tread",shareArea);
		Thread thread2 = new PrintThread("출력Tread",shareArea);
		thread1.start();
		thread2.start();
		
		System.out.println(Thread.currentThread().getName()+" 쓰레드 끝");
		
	}

}
