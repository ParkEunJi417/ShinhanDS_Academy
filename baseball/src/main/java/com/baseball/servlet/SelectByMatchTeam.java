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

//해당 경기 팀
@WebServlet("/matchTeam.select")
public class SelectByMatchTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strDate = (String)request.getParameter("date");
		Date selectedDate = DateUtil.convertSqlDate(DateUtil.convertDate(strDate));
		int gameno = Integer.parseInt(request.getParameter("no"));
		
		BaseballService bService = new BaseballService();
		RecordGameDTO game = bService.selectByMatchTeam(gameno, selectedDate);
		
		if(game.getTeam_id_a() < game.getTeam_id_h()) {
			request.setAttribute("teamId1", game.getTeam_id_a());
			request.setAttribute("teamName1", game.getTeam_name_a());
			request.setAttribute("teamId2", game.getTeam_id_h());
			request.setAttribute("teamName2", game.getTeam_name_h());
		} else {
			request.setAttribute("teamId1", game.getTeam_id_h());
			request.setAttribute("teamName1", game.getTeam_name_h());
			request.setAttribute("teamId2", game.getTeam_id_a());
			request.setAttribute("teamName2", game.getTeam_name_a());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/selectByMatchTeam.jsp");
		rd.forward(request, response);
	}
}
