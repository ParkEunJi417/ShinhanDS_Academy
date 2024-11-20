package com.shinhan4.controller2;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScopeTest
 */
@WebServlet("/jsp/scope")
public class ScopeTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.request가 유효한 동안 존재(request → response → 소멸)
		request.setAttribute("company", "신한DS");
		
		// 2.Browser 최초 접속시 생성 sessionId가 Browser에 쿠키로 저장
		// 쿠키에서 session id를 delete하거나 logout(session.invalidate())하면 제거
		HttpSession session = request.getSession();
		session.setAttribute("company", "기업은행");
		
		// 3.서버가 시작되면 생성, 종료되면 소멸
		ServletContext context = getServletContext();
		context.setAttribute("company", "국민은행");
		
		request.getRequestDispatcher("header.jsp").forward(request, response);
		//response.getWriter().append("<h1>ScopeTest setting</h1>");
		
	}
}
