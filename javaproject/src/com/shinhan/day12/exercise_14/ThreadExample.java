package com.shinhan.day12.exercise_14;

public class ThreadExample {
	public static void main(String[] args) {
		Thread thread = new MovieThread();
		thread.setDaemon(true);
		thread.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
	}

	public static void f2(String[] args) {
		Thread thread = new MovieThread();
		thread.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		thread.interrupt();
	}

	public static void f1(String[] args) {
		Thread thread1 = new MovieThread();
		thread1.start();

		Thread thread2 = new Thread(new MusicRunnable());
		thread2.start();
	}
}
