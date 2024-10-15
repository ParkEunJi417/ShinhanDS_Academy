package com.shinhan.day04;

public class Employee {
	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;
	
	public Employee(String name, String title, int baseSalary) {
		this.name=name;
		this.title=title+"님";
		this.baseSalary=baseSalary;
		getTotalSalary();
	}
	
	public void getTotalSalary() {
		// 문자열 비교 주의, ==는 주소비교, 값비교는 equals() 사용
		if(title.equals("부장님"))
			totalSalary = (int)(baseSalary + baseSalary* 0.25);
		else if(title.equals("과장님"))
			totalSalary = (int)(baseSalary + baseSalary * 0.15);
		else
			totalSalary = (int)(baseSalary + baseSalary * 0.05);
		
		// 내가 쓴 구문
//		switch(title) {
//		case "부장"->{totalSalary = (int)(baseSalary + baseSalary* 0.25);}
//		case "과장"->{totalSalary = (int)(baseSalary + baseSalary * 0.15);}
//		default->{totalSalary = (int)(baseSalary + baseSalary * 0.05);}
//		}
	}
	
	public void print() {
		System.out.printf("%s 직급의 %s 씨의 본봉은 %d 원이고 총급여는 %d 원입니다.\n",title,name,baseSalary,totalSalary);
	}
}
