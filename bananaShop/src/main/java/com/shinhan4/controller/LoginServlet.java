package com.shinhan4.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstzone.member.MemberDTO;
import com.firstzone.member.MemberService;

/**
 * default경로:http://localhost:9090/bananaShop
 * 요청주소 : @WebServlet("/auth/login.do")
 * 주소패턴 : 1. 이름까지 일치하는 경우 ▶ @WebServlet("/auth/login.do")
 * 			2. 디렉토리까지만 일치하는 경우 ▶ @WebServlet("/auth/*")
 * 			3. 확장자만 일치하는 경우 ▶ @WebServlet("*.do")
 * 			4. 모든 요청 ▶ @WebServlet("/*")
 */
@WebServlet("/auth/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		
		System.out.println(request.getContextPath());	// ▶ /bananaShop
		System.out.println(request.getRequestURL());	// ▶ http://localhost:9090/bananaShop/auth/login.do
		System.out.println(request.getRequestURI());	// ▶ /bananaShop/auth/login.do
		System.out.println();
		
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
		
//		// 파라미터 읽기 연습
//		String food = request.getParameter("food");		
//		System.out.println(food);
//		
//		String[] food2 = request.getParameterValues("food2");
//		System.out.println(Arrays.toString(food2));
//		
//		System.out.println("------getParameterNames()이용---------");		
//		Enumeration<String> names = request.getParameterNames();
//		while(names.hasMoreElements()) {
//			String name = names.nextElement();
//			
//			if(name.equals("food2")) {
//				String[] arr = request.getParameterValues(name);
//				System.out.println(Arrays.toString(arr));
//			} else {
//				String value = request.getParameter(name);
//				System.out.println(value);
//			}
//		}
//		
//		System.out.println("--------getParameterMap()이용---------");		
//		Map<String,String[]> map = request.getParameterMap();
//		for(String key:map.keySet()) {
//			String[] arr2 = request.getParameterValues(key);
//			
//			System.out.println(Arrays.toString(arr2));
//		}
		
		MemberService mService = new MemberService();
		MemberDTO member = mService.loginService(uid, upass);
		String message = "";
		
		if(member == null) {
			message = "아이디가 존재하지 않습니다.";
			response.sendRedirect("login.do?message="+message);
			return;
		} else if(member.getMember_id().equals("-1")) {
			message = "비밀번호가 틀렸습니다.";
			response.sendRedirect("login.do?message="+message);
			return;
		} else {
			message = member.getMember_name()+"님 환영합니다.";
			
			// 로그인 성공시 로그인한 Member정보를 저장
			// 1.context
			ServletContext app = getServletContext();
			app.setAttribute("loginMember3", member);
			
			// 2.session
			HttpSession session = request.getSession();
			session.setAttribute("loginMember2", member);
			session.setAttribute("loginMember", member);
			
			// 3.request
			request.setAttribute("loginMember1", member);
			
			// 쿠키에 저장하기
			Cookie cookie_id = new Cookie("loginId",member.getMember_id());
			Cookie cookie_name = new Cookie("loginName",member.getMember_name());
			Cookie cookie_email = new Cookie("loginEmail",member.getMember_email());
			
			response.addCookie(cookie_id);
			response.addCookie(cookie_name);
			response.addCookie(cookie_email);
		}
		
//		response.setContentType("text/html;charset=utf-8");
//		response.getWriter().append("<h1 style='color:green'>"+message+"</h1>");
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		request.setAttribute("result", message);
		rd.forward(request, response);
	}

}
