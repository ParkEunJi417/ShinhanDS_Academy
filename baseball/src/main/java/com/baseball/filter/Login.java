package com.baseball.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"*.select", "*.insert", "*.delete", "*.update"})
public class Login extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // 세션에서 로그인 여부 확인
        HttpSession session = httpRequest.getSession(false);
        boolean isLoggedIn = (session != null && session.getAttribute("userid") != null);

        // 보호된 경로 확인
        String uri = httpRequest.getRequestURI();

        // 회원가입, 이번주 경기일정은 허용
        boolean isAllowPath = uri.contains("gameThisWeek.select") ||
        					  uri.contains("newPerson.insert");

        if (!isAllowPath && !isLoggedIn) {
            // 로그인되지 않았으면 경고 메시지 출력 및 리다이렉트
            httpResponse.setContentType("text/html; charset=UTF-8");
            PrintWriter out = httpResponse.getWriter();
            out.println("<script>");
            out.println("alert('로그인이 필요합니다. 로그인 페이지로 이동합니다.');");
            out.println("location.href='login.do';"); // 로그인 페이지로 리다이렉트
            out.println("</script>");
            out.close();
            return; // 요청 처리 중단
        }
        
		chain.doFilter(request, response);
	}
}
