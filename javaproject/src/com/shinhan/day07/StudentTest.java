package com.shinhan.day07;

public class StudentTest {
	public static void main(String[] args) {
		//f1();
		f2();
	}

	private static void f2() {
		// 0.객체생성없이 사용
//		System.out.println(HighSchool.company1);
//		System.out.println(HighSchool.company5);
//		System.out.println(HighSchool.COMPANY6);
//		System.out.println(HighSchool.COMPANY7);
//		HighSchool.company1="변경";
//		System.out.println(HighSchool.company1);
		
		// 1.객체 참조 변수 선언(instance)
		HighSchool s1;
		
		// 2.객체 생성
		s1 = new HighSchool("고딩1",18,100000);
		
		// 3.객체 사용
		System.out.println(s1.getName());
		System.out.println(s1.getAge());
		System.out.println(s1.getPocketMoney());
	}

	private static void f1() {
		// 0.객체 생성 없이 사용
		System.out.println(Student.company1);
		System.out.println(Student.company5);
		System.out.println(Student.COMPANY6);
		System.out.println(Student.COMPANY7);
		
		// 1.객체 참조 변수 선언
		Student st1,st2;
		
		// 2.객체 생성
		st1 = new Student();
		st2 = new Student();
		
		// 3.객체 사용
//		st1.name="홍길동";
//		st1.age=20;
//		st1.company2="dsa"; → 값 변경 불가
//		System.out.println(st1.name);
//		System.out.println(st1.age);
//		System.out.println(st2.name);
//		System.out.println(st2.age);
		System.out.println(st2.company2);
		System.out.println(st2.company3);
		System.out.println(st2.company4);
		System.out.println(Student.company5);
		System.out.println(Student.COMPANY6);
		System.out.println(Student.COMPANY7);
	}
}
