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

// 해당 id의 직관 기록
@WebServlet("/watchingById.select")
public class SelectWatchingById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("userid");
		int countWin = 0;
		int countDraw = 0;
		double winRate = 0;
		
		BaseballService bService = new BaseballService();
		List<RecordPerDTO> person = bService.selectById(id);
		
		for(RecordPerDTO per:person) {
			// 응원한 팀 승패에 따라 행에 color 부여
			if(per.getTeam_score_a() > per.getTeam_score_h()) {
				per.setColor(per.getTeamid() == per.getTeam_id_a() ? "table-primary" : "table-danger");
			} else if(per.getTeam_score_a() < per.getTeam_score_h()) {
				per.setColor(per.getTeamid() == per.getTeam_id_h() ? "table-primary" : "table-danger");
			} else {
				per.setColor("table-secondary");
			}
			
			// 직관 승률
			boolean isHomeTeam=per.getTeamid()==per.getTeam_id_h()?true:false;
			
			if(per.getTeam_score_h() == per.getTeam_score_a()) {
				countDraw++;
			} else {
				if(isHomeTeam) { // 응원하는 팀이 홈팀일 경우
					if(per.getTeam_score_h() > per.getTeam_score_a()) {
						countWin++;
					}
				} else { // 응원하는 팀이 원정팀일 경우
					if(per.getTeam_score_a() > per.getTeam_score_h()) {
						countWin++;
					}
				}
			}

		}
		if(person.size() != 0 && person.size()-countDraw != 0)
			winRate = (double)countWin/(person.size()-countDraw);
		
		request.setAttribute("winRate", String.format("%.2f",winRate * 100));
		request.setAttribute("watchingData", person);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/selectWatchingById.jsp");
		rd.forward(request, response);
	}
}
