package com.shinhan.day12;

public class ThreadA extends Thread {
	WorkObject workObject;
	
	public ThreadA(WorkObject workObject) {
		super(currentThread().getName());
		this.workObject=workObject;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			workObject.methodA();
		}
	}
}
