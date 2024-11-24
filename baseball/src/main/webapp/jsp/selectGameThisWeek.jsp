<%@page import="com.baseball.service.RecordGameDTO"%>
<%@page import="com.baseball.service.BaseballService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../jsp/header.jsp"%>
<link href="${path}/css/selectGameThisWeek.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<div id="div-login">
		<a href="login.do" id="a-login">로그인</a>
	</div>
	<div id="div-logout">
		<span id="span-id"></span>
		<a href="logout.do" id="a-logout">로그아웃</a>
	</div>
	<div id="div-header">
			<img id="img-kbo" src="${path}/images/KBO.png" alt="KBO">
			<label id="label-header">야구 직관 프로그램</label>
	</div>
	<h2>이번주 야구일정</h2>
	<div class="container">
	 	<table class="table">
			<thead>
			    <tr>
			      <th scope="col">경기일정</th>
			      <th scope="col">매칭</th>
			    </tr>
			</thead>
			<tbody>
			<c:forEach items="${gameData}" var="game">
			<tr>
		  	  <td class="date">${game.game_date}</td>
			  <td>
				<div class="container">
					<div class="teamName">${game.team_name_a}</div>
					<div data-teamid="${game.team_id_a}"></div>
					<div class="score" style="color: ${game.team_color_a};">${game.team_score_a}</div>
					<div> vs </div>
					<div class="score" style="color: ${game.team_color_h};">${game.team_score_h}</div>
					<div data-teamid="${game.team_id_h}"></div>
					<div class="teamName">${game.team_name_h}</div>
				</div>
			  </td>
		    </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script>
	$('#img-kbo, #label-header').click(() => location.href = 'main');
	
	if ("${userid}" !== "" && "${userid}" !== null) {
        $('#div-login').css('display', 'none');
        $('#span-id').html("${userid}"+"님 환영합니다.");
    } else {
        $('#div-logout').css('display', 'none');
    }
</script>	
</body>
</html>