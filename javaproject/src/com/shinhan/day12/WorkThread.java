package com.shinhan.day12;

public class WorkThread extends Thread {
	boolean work=true;
	
	WorkThread(String name){
		super(name);
	}

	@Override
	public void run() {
		while(true) {
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(work) {
				System.out.println(getName()+" 작업처리");
			}else {
				Thread.yield(); // 양보
			}
		}
	}
	
	
}
