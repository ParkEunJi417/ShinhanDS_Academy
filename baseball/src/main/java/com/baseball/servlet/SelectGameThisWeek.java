package com.baseball.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baseball.service.BaseballService;
import com.baseball.service.RecordGameDTO;

// 이번주 야구일정
@WebServlet("/gameThisWeek.select")
public class SelectGameThisWeek extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseballService bService = new BaseballService();
		List<RecordGameDTO> gamelist = bService.selectGameThisWeek();

		for(RecordGameDTO game:gamelist) {
			if(game.getTeam_score_a() > game.getTeam_score_h()) {
				game.setTeam_color_a("rgb(68,114,196)");
				game.setTeam_color_h("gray");
			} else if (game.getTeam_score_a() < game.getTeam_score_h()) {
				game.setTeam_color_h("rgb(68,114,196)");
				game.setTeam_color_a("gray");
			}
		}
		
		request.setAttribute("gameData", gamelist);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/selectGameThisWeek.jsp");
		rd.forward(request, response);
	}
}
