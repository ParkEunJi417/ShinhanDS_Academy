// package 정의
package com.shinhan.day05;

// 상위 package명뒤에 *하면 하위 package까지 모두 포함
import com.shinhan.day04.*;

//import com.shinhan.day04.Employee; // 다른 package의 Employee를 사용하기 위해 import
//import com.shinhan.day04.Calculator;

public class PhoneTest {
	public static void main(String[] args) {
		
		Employee emp = new Employee("aa","부장",1000);
		emp.print();
		
		Calculator cal = new Calculator();
		System.out.println(cal.plus(1, 2));
		
		System.out.println(Phone.COMPANY3);
//		Phone.COMPANY3="dd"; final 변경 불가
		
		Phone p = new Phone();
		System.out.println(p.company);
		System.out.println(p.company2);
//		p.company="b"; final 변경 불가
//		p.company2="b"; final 변경 불가
		
		// Integer의 최대값
		// PI값
//		Integer.MAX_VALUE=100; 변경 불가
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Math.PI);
	}
}
