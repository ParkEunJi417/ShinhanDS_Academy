package com.shinhan4.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.dept.DeptDTO;
import com.firstzone.dept.DeptService;

@WebServlet("/dept/insert.do")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeptInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// 요청은 servlet이 받고 응답은 jsp에게 위임함
		RequestDispatcher rd = request.getRequestDispatcher("deptInsert.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post방식은 parameter가 URI로 오지않고 요청문서의 body로 옴. encoding되지 않아 한글깨짐
		request.setCharacterEncoding("utf-8");
		
		String phone = request.getParameter("phone");
		System.out.println("hiddenTest:"+phone);
		
		DeptDTO dept = null;
		
		int department_id = Integer.parseInt(request.getParameter("department_id"));
		String department_name = request.getParameter("department_name");
		int location_id = Integer.parseInt(request.getParameter("location_id"));
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		
		//dept = new DeptDTO(department_id,department_name,manager_id,location_id);
		dept = DeptDTO.builder()
				.department_id(department_id)
				.department_name(department_name)
				.location_id(location_id)
				.manager_id(manager_id)
				.build();
		
		DeptService dService = new DeptService();
		int result = dService.insertService(dept);
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("deptInsertResult.jsp");
		rd.forward(request, response);
	}

}
