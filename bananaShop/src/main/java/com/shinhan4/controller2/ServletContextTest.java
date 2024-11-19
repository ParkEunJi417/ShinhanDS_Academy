package com.shinhan4.controller2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextServlet
 */
@WebServlet(urlPatterns = {"/ServletContextTest","/servlet/config"},
			initParams = {@WebInitParam(name="email", value="test@naver.com")})
public class ServletContextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext app = getServletContext();
		
		String id = app.getInitParameter("username");
		String pass = app.getInitParameter("userpass");
		
		System.out.println(id+":"+pass);
		
		// 실행환경 default → http://localhost:9090/bananaShop
		// 개발환경 default → src/webapp
		InputStream is = app.getResourceAsStream("/WEB-INF/resource/menu.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		
		while((line = br.readLine())!=null) {
			System.out.println(line);
		}
	}
}
