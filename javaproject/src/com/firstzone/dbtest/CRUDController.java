package com.firstzone.dbtest;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.shinhan.util.DateUtil;

public class CRUDController {
	static Scanner sc = new Scanner(System.in);
	static EmpService empService = new EmpService();
	
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
			
			case 6->{f_selectByDept();}
			case 7->{f_selectByJob();}
			case 8->{f_selectBySal();}
			case 9->{f_selectByCondition();}
			case 99->{isStop=true;}
			default->{System.out.println("작업선택 오류. 다시 선택");}
			}
		}
		sc.close();
		System.out.println("=========프로그램 종료=========");
	}

	private static void f_selectByCondition() {
		System.out.print("조회할 department_id>>");
		int deptid = Integer.parseInt(sc.nextLine());
		
		System.out.print("조회할 job_id>>");
		String jobid = sc.nextLine();
				
		System.out.print("얼마이상의 salary>>");
		double salary = Double.parseDouble(sc.nextLine());
		
		System.out.print("입사일 hire_date(yyyy-MM-dd)>>");
		String hdate = sc.nextLine();
		Date hire_date = DateUtil.convertSqlDate(DateUtil.convertDate(hdate));
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("department_id", deptid);
		map.put("job_id", jobid);
		map.put("salary", salary);
		map.put("hire_date", hire_date);
		
		List<EmpDTO> emplist = empService.selectByConditionService(map);
		EmpView.display(emplist);
	}

	private static void f_selectBySal() {
		System.out.print("조회할 salary>>");
		double salary = Double.parseDouble(sc.nextLine());
		
		List<EmpDTO> emplist = empService.selectBySalaryService(salary);
		EmpView.display(emplist);
	}

	private static void f_selectByJob() {
		System.out.print("조회할 job_id>>");
		String jobid = sc.nextLine();
		
		List<EmpDTO> emplist = empService.selectByJobIdService(jobid);
		EmpView.display(emplist);
	}

	private static void f_selectByDept() {
		System.out.print("조회할 department_id>>");
		int deptid = Integer.parseInt(sc.nextLine());
		
		List<EmpDTO> emplist = empService.selectByDeptIdService(deptid);
		EmpView.display(emplist);
	}

	private static void f_delete() {
		System.out.print("삭제할 직원번호>>");
		int empid = Integer.parseInt(sc.nextLine());
		
		int result=empService.deleteService(empid);
		EmpView.display(result+"건 삭제됨");
	}

	private static void f_update() {
		int result=empService.updateService(f_makeEmp());
		EmpView.display(result+"건 수정됨");
	}

	private static void f_insert() {
		int result=empService.insertService(f_makeEmp());
		EmpView.display(result+"건 입력됨");
	}
	
	private static EmpDTO f_makeEmp() {
		System.out.print("1.직원번호>>");
		int emp_id = Integer.parseInt(sc.nextLine());
		
		System.out.print("2.first_name>>");
		String fname = sc.nextLine();
		
		System.out.print("3.last_name>>");
		String lname = sc.nextLine();
		
		System.out.print("4.email>>");
		String email = sc.nextLine();
		
		System.out.print("5.phone_number>>");
		String phone = sc.nextLine();
		
		System.out.print("6.hire_date(yyyy-MM-dd)>>");
		String hdate = sc.nextLine();
		Date hire_date = DateUtil.convertSqlDate(DateUtil.convertDate(hdate));
		
		System.out.print("7.job_id(예:IT_PROG)>>");
		String job_id = sc.nextLine();
		
		System.out.print("8.salary>>");
		double salary = Double.parseDouble(sc.nextLine());
		
		System.out.print("9.commission_pct(0.??)>>");
		double commission = Double.parseDouble(sc.nextLine());
		
		System.out.print("10.manager_id(100~206)>>");
		int mid = Integer.parseInt(sc.nextLine());
		
		System.out.print("11.department_id(10~270)>>");
		int did = Integer.parseInt(sc.nextLine());
		
		EmpDTO emp = new EmpDTO();
		emp.setCommission_pct(commission);
		emp.setDepartment_id(did);
		emp.setEmail(email);
		emp.setEmployee_id(emp_id);
		emp.setFirst_name(fname);
		emp.setHire_date(hire_date);
		emp.setJob_id(job_id);
		emp.setLast_name(lname);
		emp.setManager_id(mid);
		emp.setPhone_number(phone);
		emp.setSalary(salary);
		
		return emp;
	}

	private static void f_selectById() {
		System.out.print("직원번호>>");
		int empid = Integer.parseInt(sc.nextLine());
		
		EmpDTO emp = empService.selectByIdService(empid);
		EmpView.display(emp);
	}

	private static void f_select() {
		List<EmpDTO> emplist = empService.selectAllService();
		EmpView.display(emplist);
	}

	private static void menu() {
		System.out.println("----------------------------------------------");
		System.out.println("1.조회 2.입력 3.수정 4.삭제 5.상세보기 6.부서직원 조회");
		System.out.println("7.직책조회 8.급여조회 9.부서&직책&급여&급여일 조회 99.종료");
		System.out.println("----------------------------------------------");
		System.out.print("작업선택>>");
	}
}
