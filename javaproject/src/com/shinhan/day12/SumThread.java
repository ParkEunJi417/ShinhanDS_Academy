package com.shinhan.day12;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter @Setter
public class SumThread extends Thread {
	
	private final long end;
	
	private long sum;
	
	@Override
	public void run() {
		for(int i = 1;i<=end;i++) {
			sum += i;
		}
	}
}
