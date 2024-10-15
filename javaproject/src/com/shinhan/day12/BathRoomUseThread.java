package com.shinhan.day12;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BathRoomUseThread extends Thread {
	BathRoom room;
	String name;
	
	@Override
	public void run() {
		System.out.println(currentThread().getName());
		for(int i=1;i<=3;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			room.use(name);
		}
	}
	
	
}
