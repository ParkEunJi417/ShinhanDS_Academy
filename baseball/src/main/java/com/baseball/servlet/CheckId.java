package com.baseball.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baseball.service.BaseballService;

//기가입자 확인
@WebServlet("/id.check")
public class CheckId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseballService bService = new BaseballService();
		int CountVaildId = bService.selectPersonId(request.getParameter("person_id"));

		response.getWriter().write(String.valueOf(CountVaildId));
	}
}
