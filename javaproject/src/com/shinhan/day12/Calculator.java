package com.shinhan.day12;

import lombok.Getter;

@Getter
public class Calculator {

	private int memory;

	synchronized void setMemory(int memory) {
		this.memory = memory;

		try {
			Thread.sleep(1000); // 2초간 일시정지, 2초후 실행대기상태로 갔다가 차례가 되면 실행함
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ":" + this.memory);
	}

}
