package com.baseball.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baseball.service.BaseballService;

// 모든 경기 일정
@WebServlet("/allGameDate.select")
public class SelectAllGameDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseballService bService = new BaseballService();
		List<Date> datelist = bService.selectAllGameDate();
		
		request.setAttribute("datelist", datelist);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/selectAllGameDate.jsp");
		rd.forward(request, response);
	}
}
