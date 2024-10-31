<%@page import="com.baseball.RecordGameDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.baseball.BaseballService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구⚾</title>
<style>
 table {margin: 0 auto;}
 table, td {border-collapse: collapse; padding: 10px; text-align: center;}
 caption {font-size: 35px;}
</style>
</head>
<body>
	<table border="1">
		<caption>이번주 야구일정</caption>
		<thead>
			<tr>
				<td>경기일정</td>
				<td>매칭팀</td>
				<td>점수</td>
			</tr>
		</thead>
		<tbody>
		<%
		BaseballService bService = new BaseballService();
		List<RecordGameDTO> gamelist = bService.selectGameThisWeek();
		for(RecordGameDTO game:gamelist){%> 
			<tr>
				<td><%= game.getGame_date() %></td>
				<td><%= game.getTeam_name_a() %> vs <%= game.getTeam_name_h() %></td>
				<td><%= game.getTeam_score_a() %> : <%= game.getTeam_score_h() %></td>
			</tr>
		<%} %>
		</tbody>
		
	</table>
</body>
</html>