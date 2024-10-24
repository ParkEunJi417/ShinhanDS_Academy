package com.firstzone.dept;

import java.util.List;

import com.firstzone.dbtest.EmpDTO;

public class DeptView {

	// Overloading
	public static void display(List<DeptDTO> deptlist) {
		System.out.println("=========여러건의 부서정보=========");

		for (DeptDTO dept : deptlist) {
			System.out.println(dept);
		}
	}

	public static void display(DeptDTO dept) {
		System.out.println("=========1건 부서조회=========");

		System.out.println(dept==null?"부서없음":dept);
	}

	public static void display(String message) {
		System.out.println("[알림]"+message);
	}
}
