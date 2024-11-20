package com.baseball.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baseball.service.BaseballService;

/**
 * Servlet implementation class CheckId
 */
@WebServlet("/id.check")
public class CheckId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BaseballService bService = new BaseballService();
		//System.out.println(request.getParameter("person_id"));
		int CountVaildId = bService.selectPersonId(request.getParameter("person_id"));
		//System.out.println("개수:"+CountVaildId);
		response.getWriter().write(String.valueOf(CountVaildId));
//		if(CountVaildId != 0) {
//			
//			return;
//		}
	}
}
