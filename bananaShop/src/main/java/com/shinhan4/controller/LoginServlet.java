package com.shinhan4.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.member.MemberDTO;
import com.firstzone.member.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/auth/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		
		// 위임(받은 요청을 전달)
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		request.setCharacterEncoding("utf-8");
		
		// 1.각각의 파라미터 읽기
		String uid = request.getParameter("userid");
		String upass = request.getParameter("userpass");
		
		// 파라미터 읽기 연습
		String food = request.getParameter("food");		
		System.out.println(food);
		
		String[] food2 = request.getParameterValues("food2");
		System.out.println(Arrays.toString(food2));
		
		System.out.println("------getParameterNames()이용---------");		
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			
			if(name.equals("food2")) {
				String[] arr = request.getParameterValues(name);
				System.out.println(Arrays.toString(arr));
			} else {
				String value = request.getParameter(name);
				System.out.println(value);
			}
		}
		
		System.out.println("--------getParameterMap()이용---------");		
		Map<String,String[]> map = request.getParameterMap();
		for(String key:map.keySet()) {
			String[] arr2 = request.getParameterValues(key);
			
			System.out.println(Arrays.toString(arr2));
		}
		
		MemberService mService = new MemberService();
		MemberDTO member = mService.loginService(uid, upass);
		String message = "";
		
		if(member == null) {
			message = "아이디가 존재하지 않습니다.";
		} else if(member.getMember_id().equals("-1")) {
			message = "비밀번호가 틀렸습니다.";
		} else {
			message = member.getMember_name()+"님 환영합니다.";
		}
		
//		response.setContentType("text/html;charset=utf-8");
//		response.getWriter().append("<h1 style='color:green'>"+message+"</h1>");
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		request.setAttribute("result", message);
		rd.forward(request, response);
	}

}
