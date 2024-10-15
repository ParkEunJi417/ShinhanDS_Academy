package com.shinhan.day12;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExample {
	public static void main(String[] args) {

		// 작업이 많은 경우 무한정의 Thread를 사용하면 성능 저하 우려 있음
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		for(int i=1;i<=100;i++) {
			int end = i;
			Future<Integer> result = service.submit(()->{
				System.out.println(Thread.currentThread().getName());
				int total = 0;
				for(int j=1;j<=end;j++) {
					total += j;
				}
				return total;
			});
			try {
				System.out.println("받은 값 sum="+result.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void f(String[] args) {
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


