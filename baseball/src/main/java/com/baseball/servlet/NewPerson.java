package com.baseball.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baseball.service.BaseballService;
import com.baseball.service.PersonDTO;

@WebServlet("/newPerson.insert")
public class NewPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/newPerson.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BaseballService bService = new BaseballService();

		PersonDTO person = makePerson(request);
		int result = bService.insertPerson(person);
				
		response.sendRedirect("main.jsp");
	}

	private PersonDTO makePerson(HttpServletRequest request) {
		PersonDTO person = null;
		
		String person_id = request.getParameter("person_id");
		String person_pw = request.getParameter("person_pw");
		String person_phone = request.getParameter("person_phone");
		String person_email = request.getParameter("person_email");
		
		person = PersonDTO.builder()
						  .person_id(person_id)
						  .person_pw(person_pw)
						  .person_phone(person_phone)
						  .person_email(person_email)
						  .build();
		
		return person;
	}
}
