<%@page import="com.baseball.BaseballService"%>
<%@page import="com.baseball.PersonDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%
request.setCharacterEncoding("utf-8");

String person_id = request.getParameter("person_id");
String person_pw = request.getParameter("person_pw");
String person_phone = request.getParameter("person_phone");
String person_email = request.getParameter("person_email");

PersonDTO person = PersonDTO.builder()
					.person_id(person_id)
					.person_pw(person_pw)
					.person_phone(person_phone)
					.person_email(person_email)
					.build();

BaseballService bService = new BaseballService();
int result = bService.insertMember(person);
%>
</head>
<body>
<%
if(result > 0){%>
	<h1>회원가입 성공!</h1>
	<%} else { %>
	<h1>회원가입 실패</h1>
	<%} %>
<a href="main.jsp">메인으로 돌아가기</a>
</body>
</html>