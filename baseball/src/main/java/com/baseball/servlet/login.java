package com.baseball.servlet;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baseball.service.BaseballService;
import com.baseball.service.PersonDTO;

/**
 * Servlet implementation class login
 */
@WebServlet("/login.do")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		BaseballService bService = new BaseballService();
		String id = request.getParameter("person_id");
		String pw = request.getParameter("person_pw");
		PersonDTO person = bService.loginMember(id, pw);
		String message = "";
		
		if(person == null) {
			message = URLEncoder.encode("아이디가 존재하지 않습니다.","utf-8");
			response.sendRedirect("login.do?message="+message);
			return;
		} else if(person.getPerson_pw().equals("-1")) {
			message = URLEncoder.encode("비밀번호가 틀렸습니다.","utf-8");
			response.sendRedirect("login.do?message="+message);
			return;
		} else {
			message = person.getPerson_id()+"님 환영합니다.";
		}

		session.setAttribute("result", message);
		response.sendRedirect("main.jsp");
	}
}
