package com.baseball.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baseball.service.BaseballService;
import com.baseball.service.RecordPerDTO;

//기등록 직관 경기 확인
@WebServlet("/gameNoById.select")
public class SelectGameNoById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("result");
		int gameno = Integer.parseInt(request.getParameter("no"));
		
		BaseballService bService = new BaseballService();
		int countWatching = bService.selectGameNo(id, gameno);
		
		response.getWriter().write(String.valueOf(countWatching));
	}
}
