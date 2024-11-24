package com.baseball.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter(urlPatterns = {"*.select", "*.check", "*.do", "*.insert", "*.update", "*.delete", "/main"})
public class EncodingFilter extends HttpFilter implements Filter {

    public EncodingFilter() {
        System.out.println("EncodingFilter 생성");
    }

	public void destroy() {
		System.out.println("EncodingFilter 소멸");
	}

	// *.do 요청시마다 수행
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 서블릿 요청 before
		//System.out.println("서블릿 요청 before");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		chain.doFilter(request, response); // 다른 필터를 수행하거나 서블릿을 수행하러감
		
		// 서블릿 수행 후 응답하러 가기 전
		//System.out.println("서블릿 요청after 응답하기전");
	}
}
