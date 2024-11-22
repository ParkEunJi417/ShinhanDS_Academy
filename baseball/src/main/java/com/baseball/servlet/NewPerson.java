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

//회원가입
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
		int insertPerson = bService.insertPerson(person);
		boolean isInsert = insertPerson==1?true:false;
		
		request.setAttribute("result", isInsert);
		request.setAttribute("newPersonId", request.getParameter("person_id"));
		RequestDispatcher rd = request.getRequestDispatcher("jsp/newPersonRegister.jsp");
		rd.forward(request, response);
	}

	private PersonDTO makePerson(HttpServletRequest request) {
		PersonDTO person = null;
		
		String id = request.getParameter("person_id");
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
