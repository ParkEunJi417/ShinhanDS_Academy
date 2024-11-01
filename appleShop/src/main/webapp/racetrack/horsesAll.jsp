<%@page import="racetrack.Horse_DTO"%>
<%@page import="java.util.List"%>
<%@page import="racetrack.RaceTrack_DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 
    JSP 주석임
    이 문서는 JSP이다 → JAVA + HTML → JAVA가 서버에서 실행후 동적으로 HTML 생성함
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<h1>경마장 말들의 LIST</h1>
	<thead>
		<tr>
			<th>ID</th>
			<th>NAME</th>
		</tr>
	</thead>
	<tbody>
		<%
		RaceTrack_DAO dao = new RaceTrack_DAO();
		List<Horse_DTO> horseList = dao.getAllHorses();
		
		for(Horse_DTO dto:horseList){
		%>
		<tr>
			<td><%= dto.getHorse_id() %>
			<td><%= dto.getHorse_name() %>
		</tr>
		<%} %>
	</tbody>
</table>
</body>
</html>