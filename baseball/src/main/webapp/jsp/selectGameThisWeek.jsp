<%@page import="com.baseball.service.RecordGameDTO"%>
<%@page import="com.baseball.service.BaseballService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../jsp/header.jsp"%>
<link href="${path}/css/selectGameThisWeek.css" rel="stylesheet">
</head>
<body>
<div>
	<div id="div-header">
			<img id="img-kbo" src="${path}/images/KBO.png" alt="KBO">
			<label id="label-header">야구 직관 프로그램</label>
	</div>
	<h2>이번주 야구일정</h2>
 	<table>
		<tr>
			<th>경기일정</th>
			<th>매칭</th>
		</tr>
		<tbody>
		<c:forEach items="${gameData}" var="game">
			<c:set var="scoreA" value="${game.team_score_a}"/>
			<c:set var="scoreH" value="${game.team_score_h}"/>
			<c:choose>
				<c:when test="${scoreA > scoreH}">
					<c:set var="colorA" value="rgb(68,114,196)"/>
					<c:set var="colorH" value="gray"/>
				</c:when>
				<c:when test="${scoreA < scoreH}">
					<c:set var="colorA" value="gray"/>
					<c:set var="colorH" value="rgb(68,114,196)"/>
				</c:when>
			</c:choose>
			<tr>
				<td class="date">${game.game_date}</td>
				<td> 
					<div class="teamName">${game.team_name_a}</div>
					<div data-teamid="${game.team_id_a}"></div>
					<div class="score" style="color: ${colorA};">${game.team_score_a}</div>
					<div> vs </div>
					<div class="score" style="color: ${colorH};">${game.team_score_h}</div>
					<div data-teamid="${game.team_id_h}"></div>
					<div class="teamName">${game.team_name_h}</div>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<script>
	$('#div-header').on('click', function() { window.location.href = 'main'; });
</script>	
</body>
</html>

<!-- 
insert into game values (seq_gameNo.nextval,10,9,4,5,'2024-11-18');
insert into game values (seq_gameNo.nextval,3,5,14,5,'2024-11-18');
insert into game values (seq_gameNo.nextval,7,2,1,5,'2024-11-18');
insert into game values (seq_gameNo.nextval,4,6,5,10,'2024-11-18');
insert into game values (seq_gameNo.nextval,8,1,1,7,'2024-11-18');
 -->