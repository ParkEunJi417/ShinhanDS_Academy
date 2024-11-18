package com.shinhan4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.dept.DeptService;
import com.firstzone.emp.EmpService;

/**
 * Servlet implementation class EmpDeleteServlet
 */
@WebServlet("/emp/delete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpDeleteServlet() {
        super();
    }

    // service()메서드가 존재하면 먼저 선택되어 service()만 수행함
    // service()메서드가 존재하지 않으면 요청방식에 따라 doGet() 또는 doPost()만 수행함
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청방식:"+request.getMethod());
		
		request.setCharacterEncoding("utf-8");
		
		String str_empid = request.getParameter("empid");
		int emp_id = 0;
		if(str_empid != null) {
			emp_id = Integer.parseInt(str_empid);
		}
		EmpService eService = new EmpService();
		int result = eService.deleteService(emp_id);
		System.out.println(result+"건 삭제됨");
		
		response.sendRedirect("emplist.do");
	}

}
