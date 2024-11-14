package com.shinhan4.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
   Servlet : 클라이언트의 요청을 받아서 처리가능한 java server program → java + html 가능(권장안함)
   HttpServlet : HTTP프로토콜에서 실행가능한 서블릿
   요청 : http://localhost:9090/bananaShop/First
   @WebServlet("/First")이 수행됨
   servlet의 메서드들은 callbakck임. 개발자가 정의, WAS(Web Application Server)가 호출함
   최초요청시 생성자(), init() 실행됨
   요청에 따라 get방식이면 doGet(), post방식이면 doPost() 실행됨
   web browser에서 요청(request) → web server → WAS(Web Application Server:Tomcat) 
   → web browser 응답(response)
 */
/*
 기본경로(절대경로) ./ → http://localhost:9090/bananaShop 
 */
@WebServlet({"/first","/first2","/aa/first3"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstServlet() {
        System.out.println("FirstServlet 생성자 → 최초요청시 1회 생성");
    }
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet init → 최초요청시 1회 실행");
	}
	public void destroy() {
		System.out.println("FirstServlet destroy → 서버중지시 실행");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get요청시마다 발생→"+request.getRemoteAddr());
		
		display(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post요청시마다 발생→"+request.getRemoteAddr());
		
		display(request,response);
	}
	
	private void display(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// html 형태인데 utf-8이라고 notice
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<h1>"+request.getMethod()+"요청에 대한 응답</h1>");
		out.print("<hr>");
		out.print("<p>LocalAddr:"+request.getLocalAddr()+"</p>");
		out.print("<p>LocalName:"+request.getLocalName()+"</p>");
		out.print("<p>RemoteAddr:"+request.getRemoteAddr()+"</p>");
		out.print("<p>RemoteUser:"+request.getRemoteUser()+"</p>");
		out.print("<p>RemoteHost:"+request.getRemoteHost()+"</p>");
	}
}
