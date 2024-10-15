package com.shinhan.day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExecuteExample {

	public static void main(String[] args) {
		String[][] mails = new String[1000][3];
		
		for(int i=0;i<mails.length;i++) {
			mails[i][0]="admin@my.com";
			mails[i][1]="member"+i+"@my.com";
			mails[i][2]="신상입고";
		}
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		for(int i=0; i<mails.length;i++) {
			int cnt = i;
			service.execute(()-> {
				System.out.println(Thread.currentThread().getName());
				System.out.println("보낸 사람:"+mails[cnt][0]);
				System.out.println("보낸 사람:"+mails[cnt][1]);
				System.out.println("보낸 사람:"+mails[cnt][2]);
			});
		}
		service.shutdown();
	}
}
