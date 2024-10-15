package com.shinhan.day12;

public class ThreadB extends Thread {
	WorkObject workObject;
	
	public ThreadB(WorkObject workObject) {
		super(currentThread().getName());
		this.workObject=workObject;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			workObject.methodB();
		}
	}
}
