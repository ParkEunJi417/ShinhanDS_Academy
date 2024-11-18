package com.shinhan4.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.dept.DeptDTO;
import com.firstzone.dept.DeptService;
import com.firstzone.emp.EmpDTO;
import com.firstzone.emp.EmpService;
import com.firstzone.emp.JobDTO;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class EmpUpdateServlet
 */
@WebServlet("/emp/detail.do")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str_empid = request.getParameter("empid");
		DeptService dService = new DeptService();
		EmpService eService = new EmpService();
		
		EmpDTO emp = eService.selectByIdService(Integer.parseInt(str_empid));
		List<DeptDTO> deptlist = dService.selectAllService();
		List<JobDTO> joblist = eService.selectAllJobService();
		List<EmpDTO> managerlist = eService.selectAllService();
		
		request.setAttribute("deptlist", deptlist);
		request.setAttribute("joblist", joblist);
		request.setAttribute("managerlist", managerlist);
		request.setAttribute("empInfo", emp);
		
		request.getRequestDispatcher("empDetail.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDTO emp = makeEmp(request);
		
		EmpService eService = new EmpService();
		int result = eService.updateService(emp);
		System.out.println(result+"건 수정됨");
		
		response.sendRedirect("emplist.do");
	}
	
	private EmpDTO makeEmp(HttpServletRequest request) {
		EmpDTO emp = null;
		
		
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		String h_date = request.getParameter("hire_date");
		String job_id = request.getParameter("job_id");
		
		String str_empid = request.getParameter("employee_id");
		Integer employee_id = Integer.parseInt(str_empid);
		
		String str_mid = request.getParameter("manager_id");
		Integer manager_id = Integer.parseInt(str_mid);
		
		String str_deptid = request.getParameter("department_id");
		Integer department_id = Integer.parseInt(str_deptid);
		
		String str_sal = request.getParameter("salary");
		Double salary = 0.0;
		if(str_sal!="" && str_sal != null) {
			salary = Double.parseDouble(str_sal);
		}
		
		String str_comm = request.getParameter("commission_pct");
		Double commission_pct = 0.0;
		if(str_comm != "" && str_comm != null) {
			commission_pct = Double.parseDouble(str_comm);
		}
		
		Date hire_date = DateUtil.convertSqlDate(DateUtil.convertDate(h_date));
		
		emp = EmpDTO.builder()
				.employee_id(employee_id)
				.first_name(first_name)
				.last_name(last_name)
				.email(email)
				.phone_number(phone_number)
				.hire_date(hire_date)
				.job_id(job_id)
				.salary(salary)
				.commission_pct(commission_pct)
				.manager_id(manager_id)
				.department_id(department_id)
				.build();
		
		return emp;
	}
}
