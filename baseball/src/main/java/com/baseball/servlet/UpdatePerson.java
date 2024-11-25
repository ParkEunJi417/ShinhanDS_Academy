package com.baseball.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baseball.service.BaseballService;
import com.baseball.service.PersonDTO;

/**
 * Servlet implementation class UpdatePerson
 */
@WebServlet("/person.update")
public class UpdatePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("userid");
		
		BaseballService bService = new BaseballService();
		PersonDTO person = bService.selectPersonInfo(id);
		
		request.setAttribute("info", person);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/updatePerson.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("userid");
		
		BaseballService bService = new BaseballService();

		PersonDTO person = makePerson(request, sessionId);
		int updatePerson = bService.updatePerson(person);
		
		response.sendRedirect("main");
	}

	private PersonDTO makePerson(HttpServletRequest request, String sessionId) {
		PersonDTO person = null;
		
		String id = sessionId;
		String pw = request.getParameter("person_pw");
		String phone = request.getParameter("person_phone");
		String email = request.getParameter("person_email")+"@"+request.getParameter("person_domain");
		
		person = PersonDTO.builder()
						  .person_id(id)
						  .person_pw(pw)
						  .person_phone(phone)
						  .person_email(email)
						  .build();
		
		return person;
	}

}
