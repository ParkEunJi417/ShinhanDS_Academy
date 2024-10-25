package com.firstzone.dept_teacher;

import java.util.List;

public class DeptView {

	
	public static void display(List<DeptDTO> deptlist) {
		System.out.println("=====여러건의 부서정보=======");
		for(DeptDTO dept:deptlist) {
			display(dept);
		}
	}
	
	public static void display(DeptDTO dept) {
		if(dept==null) {
			System.out.println("해당부서가 존재하지않는다.");
			return;
		}
		System.out.println("부서번호:" + dept.getDepartment_id());
		System.out.println("부서이름:" + dept.getDepartment_name());
		System.out.println("부서장:" + dept.getManager_id());
		System.out.println("지역:" + dept.getLocation_id());
		System.out.println("---------------------------------------");
	}
	
	public static void display(String message) {
		System.out.println("[알림]" + message);
	}
	
}








