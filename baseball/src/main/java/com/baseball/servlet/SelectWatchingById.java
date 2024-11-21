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

/**
 * Servlet implementation class SelectWatchingById
 */
@WebServlet("/watchingById.select")
public class SelectWatchingById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("result");
		
		BaseballService bService = new BaseballService();
		List<RecordPerDTO> person = bService.selectById(id);
		
		request.setAttribute("watchingData", person);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/selectWatchingById.jsp");
		rd.forward(request, response);
	}
}
