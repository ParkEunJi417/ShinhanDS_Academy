package com.shinhan.day10;

import java.util.Scanner;

public class MyExceptionTest2 {
	public static void main(String[] args) {
		try {
			f1();
		} catch (MyException e) {
			e.printStackTrace();
		}
		System.out.println("정상 종료");
	}

	private static void f1() throws MyException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ID>>");
		String id = sc.next();
		
		sc.close();
		
		if(id.length() > 5) {
			// 강제로 Exception 발생하기 (throw)
			throw new MyException("ID는 5자리 이하여야함");
		}
	}

}

// Exception 발생에는 자동과 강제(throw)가 있음
// 1)checked : 일반 Exception
// 2)unchecked : RuntimeException

// Exception 처리
// 1)처리 : try~catch
// 2)떠넘기기 : throws