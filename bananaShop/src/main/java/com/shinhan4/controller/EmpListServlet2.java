package com.shinhan4.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.emp.EmpDTO;
import com.firstzone.emp.EmpService;
import com.shinhan.util.DateUtil;

/**
 * Servlet : 사용자의 요청을 받아서 처리가능한 서버에서 실행되는 자바 class
 * HttpServlet : http프로토콜 처리가능
 * @WebServlet : 사용자의 요청 주소 정의 → ※주의:반드시 / 로 시작
 */
@WebServlet("/emp/emplist2.do")
public class EmpListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptid = request.getParameter("deptid");
		String jobid = request.getParameter("jobid");
		String salary = request.getParameter("salary");
		String hdate = request.getParameter("hdate");
		String chk = request.getParameter("chk");
		
		Map<String, Object> map = new HashMap<>();
		map.put("department_id", Integer.parseInt(deptid));
		map.put("job_id", jobid);
		map.put("salary", Double.parseDouble(salary));
		if(chk.equals("true") || hdate=="" || hdate == null) {
			hdate="1900-01-01";
		}
		map.put("hire_date", DateUtil.convertSqlDate(DateUtil.convertDate(hdate)));
		System.out.println(map);
		
		EmpService eService = new EmpService();
		List<EmpDTO> emplist = eService.selectByConditionService(map);
		//System.out.println(emplist.size());
		// 1.HTML 만들까? NO
		// 3.JSP로 forward 할까? YES
		request.setAttribute("empDatas", emplist);
		request.getRequestDispatcher("empListTable.jsp").forward(request, response);
	}

}
