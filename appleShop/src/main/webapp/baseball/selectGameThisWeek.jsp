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
* {
	font-family: "맑은 고딕";
}
table, td, th {
	border:1px solid black;
	border-collapse: collapse;
}
table {	margin: 0 auto; }
td { height: 32px; }
th { text-align: center; }
div {
	float:left;
	height: 32px;
	line-height: 32px;
}
.date {
	width: 100px;
	text-align: center;
}
.score {
	width: 25px;
	line-height: 32px;
	text-align: center;
	font-weight: bold;
}
.teamName {
 	width: 130px;
 	text-align: center;
 }
div[data-teamid="1"]{content: url("images/1.png");}
div[data-teamid="2"]{content: url("images/2.png");}
div[data-teamid="3"]{content: url("images/3.png");}
div[data-teamid="4"]{content: url("images/4.png");}
div[data-teamid="5"]{content: url("images/5.png");}
div[data-teamid="6"]{content: url("images/6.png");}
div[data-teamid="7"]{content: url("images/7.png");}
div[data-teamid="8"]{content: url("images/8.png");}
div[data-teamid="9"]{content: url("images/9.png");}
div[data-teamid="10"]{content: url("images/10.png");}
</style>
</head>
<body>
		<table>
			<caption>이번주 야구일정</caption>
			<tr>
				<th>경기일정</th>
				<th>매칭</th>
			</tr>
			<tbody>
			<%
			BaseballService bService = new BaseballService();
			List<RecordGameDTO> gamelist = bService.selectGameThisWeek();
			
			for(RecordGameDTO game:gamelist){
				int scoreA = game.getTeam_score_a();
		        int scoreH = game.getTeam_score_h();
		        String colorA = scoreA > scoreH?"rgb(68,114,196)":"gray";
		        String colorH = scoreA < scoreH?"rgb(68,114,196)":"gray";	        
			%>
			<tr>
				<td class="date"><%= game.getGame_date() %></td>
				<td> 
					<div class="teamName"><%= game.getTeam_name_a() %></div>
					<div data-teamid="<%= game.getTeam_id_a() %>">로고</div>
					<div class="score" style="color: <%= colorA %>;">
						<%= game.getTeam_score_a() %></div>
					<div> vs </div>
					<div class="score" style="color: <%= colorH %>;">
						<%= game.getTeam_score_h() %></div>
					<div data-teamid="<%= game.getTeam_id_h() %>">로고</div>
					<div class="teamName"><%= game.getTeam_name_h() %></div>
				</td>
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