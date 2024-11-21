<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link href="${path}/css/selectWatchingById.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<div id="div-header">
			<img id="img-kbo" src="${path}/images/KBO.png" alt="KBO">
			<label id="label-header">야구 직관 프로그램</label>
	</div>
	<h2>직관기록</h2>
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">No</th>
	      <th scope="col">경기일정</th>
	      <th scope="col">매칭</th>
	      <th scope="col">응원한 팀</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <c:forEach items="${watchingData}" var="wt" varStatus="status">
		      <td>${status.index+1}</td>
		      <td class="date">${wt.game_date}</td>
		      <td>
			      <div class="container">
			        <div class="teamName">${wt.team_name_a}</div>
					<div data-teamid="${wt.team_id_a}"></div>
					<div class="score" style="color: ${colorA};">${wt.team_score_a}</div>
					<div> vs </div>
					<div class="score" style="color: ${colorH};">${wt.team_score_h}</div>
					<div data-teamid="${wt.team_id_h}"></div>
					<div class="teamName">${wt.team_name_h}</div>
			      </div>
		      </td>
		      <td>${wt.teamname}</td>
		  </c:forEach>
	    </tr>
	  </tbody>
	</table>
</div>
<script>
	$('#div-header').on('click', function() { window.location.href = 'main'; });
</script>
</body>
</html>