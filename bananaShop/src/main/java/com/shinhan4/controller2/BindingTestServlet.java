package com.shinhan4.controller2;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/jsp/bind1.go")
public class BindingTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();
		
		String aa = "local변수"; // 다른 페이지에서 가져갈 수 없음
		request.setAttribute("myName", "Request영역에 저장");
		session.setAttribute("myName2", "Session영역에 저장");
		application.setAttribute("myName3", "ServletContext(app)영역에 저장");
		
		//String realPath = application.getRealPath("."); // → 현재 프로젝트 실제 경로
		String realPath = application.getRealPath("/auth/login.jsp");
		System.out.println(realPath);
		
		request.getRequestDispatcher("bind1.jsp").forward(request, response);
	}
}
