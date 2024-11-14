package com.shinhan4.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.emp.EmpDTO;
import com.firstzone.emp.EmpService;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmpListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpService empService = new EmpService();
		List<EmpDTO> emplist = empService.selectAllService();
		System.out.println(emplist.size());
		
		// request영역에 empDatas 이름으로 emplist 정보를 저장
		request.setAttribute("empDatas", emplist);
		RequestDispatcher rd = request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);
		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print("<h1>직원목록</h1>");
//		
//		for(EmpDTO emp:emplist) {
//			out.print("<p>"+emp+"</p>");
//		}
	}

}
