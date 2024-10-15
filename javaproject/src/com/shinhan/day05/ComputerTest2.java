package com.shinhan.day05;

public class ComputerTest2 {
	public static void main(String[] args) {
		Computer com = new Computer();
		
		com.sum();
		int result = com.sum(1, 2);
		System.out.println("result="+result);
		
		String result2 = com.sum(1, 2, 3);
		System.out.println(result2+4);
		
		int result3 = com.sum(1,2,3,4,5,6,7,8,9,10);
		System.out.println(result3);
		
		result3 = com.sum(new int[] {10,20});
		System.out.println(result3);
	}
}
