package com.shinhan.day12;

public class MultiThreadTest {

	public static void main(String[] args) {
		// A~Z 출력
		Thread thread1 = new AlphabetUpperCaseThread();

		// a~z 출력
		Thread thread2 = new Thread(new AlphabetLowerCaseImpl());
		Thread thread3 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "Runnable interface 구현(익명)");
			}

		});
		Thread thread4 = new Thread(() -> {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "Runnable interface 구현(람다표현식)");
		});

		// Thread 구현 : run
		// Thread 시작 : start
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

		// 0~26 출력
		for (int n = 0; n <= 26; n++) {
			System.out.println(Thread.currentThread().getName() + "/" + n);
		}

		System.out.println("-----MAIN END-----");
	}

}
