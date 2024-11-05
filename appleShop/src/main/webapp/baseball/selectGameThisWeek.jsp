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
 table, tr {border-collapse: collapse; padding: 10px; text-align: center;}
 caption {font-size: 35px;}
 .test[data-teamid = '10'] {
		content: url("images/10.png");
		border: 1px solid gray;
	}
 div>div {
 	display: inline-block;
 	text-align: center;
 	height: 32px;
 	
 }
 div[data-teamid="10"]{
 	content: url("images/10.png");
 	width: 32px;
 }
</style>
</head>
<body>
	<table border="1">
		<caption>이번주 야구일정</caption>
		<thead>
			<tr>
				<td>경기일정</td>
				<td colspan="3">매칭팀</td>
			</tr>
		</thead>
		<tbody>
		<%
		BaseballService bService = new BaseballService();
		List<RecordGameDTO> gamelist = bService.selectGameThisWeek();
		for(RecordGameDTO game:gamelist){%> 
			<tr>
				<td><%= game.getGame_date() %></td>
				
				<td>
					<div>
						<div><%= game.getTeam_name_a() %></div>
						<div data-teamid="<%= game.getTeam_id_a() %>">한화로고</div>
					</div>
				</td>
				<td>vs</td>
				<td data-teamid="<%= game.getTeam_id_h() %>">
					<%= game.getTeam_name_h() %></td>
				<!-- <td><%= game.getTeam_score_a() %> : <%= game.getTeam_score_h() %></td> -->
			</tr>
		<%} %>
		</tbody>
		
	</table>	
	
</body>
</html>

<!-- 
insert into game values (seq_gameNo.nextval,10,9,4,5,'2024-11-04');
insert into game values (seq_gameNo.nextval,3,5,14,5,'2024-11-04');
insert into game values (seq_gameNo.nextval,7,2,1,5,'2024-11-04');
insert into game values (seq_gameNo.nextval,4,6,5,10,'2024-11-04');
insert into game values (seq_gameNo.nextval,8,1,1,7,'2024-11-04');
 -->