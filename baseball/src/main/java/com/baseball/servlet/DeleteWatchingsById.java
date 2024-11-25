package com.baseball.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baseball.service.BaseballService;

//해당 id의 직관 1건 이상 삭제
@WebServlet("/watchingsById.delete")
public class DeleteWatchingsById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String watchNo = request.getParameter("watch_no");
		
		BaseballService bService = new BaseballService();
		bService.deleteWatchingsById(watchNo);

		response.sendRedirect("watchingById.select");
	}
}
