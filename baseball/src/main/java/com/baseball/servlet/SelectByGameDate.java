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
import com.baseball.service.RecordGameDTO;
import com.baseball.util.DateUtil;

// 해당 일자의 경기 일정
@WebServlet("/gameDate.select")
public class SelectByGameDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strDate = (String)request.getParameter("date");
		Date selectedDate = DateUtil.convertSqlDate(DateUtil.convertDate(strDate));
		
		BaseballService bService = new BaseballService();
		List<RecordGameDTO> gamelist = bService.selectByGameDate(selectedDate);
		
		request.setAttribute("gamelist", gamelist);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/selectByGameDate.jsp");
		rd.forward(request, response);
	}
}
