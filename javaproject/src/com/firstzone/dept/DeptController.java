package com.firstzone.dept;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.shinhan.util.DateUtil;

public class DeptController {
	static Scanner sc = new Scanner(System.in);
	static DeptService deptService = new DeptService();
	
	public static void main(String[] args) {
		boolean isStop=false;
		while(!isStop) {
			menu();
			int job_select = Integer.parseInt(sc.nextLine());
			switch(job_select) {
			case 1->{f_select();}
			case 2->{f_insert();}
			case 3->{f_update();}
			case 4->{f_delete();}
			case 5->{f_selectById();}
			case 9->{isStop=true;}
			default->{System.out.println("작업선택 오류. 다시 선택");}
			}
		}
		sc.close();
		System.out.println("=========프로그램 종료=========");
	}

	private static void f_delete() {
		System.out.print("삭제할 부서번호>>");
		int empid = Integer.parseInt(sc.nextLine());
		
		int result=deptService.deleteService(empid);
		DeptView.display(result+"건 삭제됨");
	}

	private static void f_update() {
		int result=deptService.updateService(f_makeEmp());
		DeptView.display(result+"건 수정됨");
	}

	private static void f_insert() {
		int result=deptService.insertService(f_makeEmp());
		DeptView.display(result+"건 입력됨");
	}
	
	private static DeptDTO f_makeEmp() {
		System.out.print("1.DEPARTMENT_ID>>");
		int dept_id = Integer.parseInt(sc.nextLine());
		
		System.out.print("2.DEPARTMENT_NAME>>");
		String dept_name = sc.nextLine();
		
		System.out.print("3.MANAGER_ID>>");
		int mgr_id = Integer.parseInt(sc.nextLine());
		
		System.out.print("4.LOCATION_ID>>");
		int loc_id = Integer.parseInt(sc.nextLine());
		
		DeptDTO dept = new DeptDTO();
		
		
		dept.setDepartment_id(dept_id);
		dept.setDepartment_name(dept_name);
		dept.setManager_id(mgr_id);
		dept.setLocation_id(loc_id);
		
		return dept;
	}

	private static void f_selectById() {
		System.out.print("부서번호>>");
		int empid = Integer.parseInt(sc.nextLine());
		
		DeptDTO emp = deptService.selectByIdService(empid);
		DeptView.display(emp);
	}

	private static void f_select() {
		List<DeptDTO> emplist = deptService.selectAllService();
		DeptView.display(emplist);
	}

	private static void menu() {
		System.out.println("-----------------------");
		System.out.println("1.조회 2.입력 3.수정 4.삭제 5.상세보기 9.종료");
		System.out.println("-----------------------");
		System.out.print("작업선택>>");
	}
}
