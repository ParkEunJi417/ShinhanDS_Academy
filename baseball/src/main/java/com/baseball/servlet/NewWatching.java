package com.baseball.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baseball.service.BaseballService;

// 직관등록
@WebServlet("/newWatching.insert")
public class NewWatching extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("result");
		int no = Integer.parseInt(request.getParameter("game_no"));
		int teamId = Integer.parseInt(request.getParameter("watch_team_id"));
		
		BaseballService bService = new BaseballService();
		bService.insertWatching(id, no, teamId);
		response.sendRedirect("watchingById.select");
	}
}
