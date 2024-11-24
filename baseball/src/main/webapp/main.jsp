<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../jsp/header.jsp"%>
<link href="${path}/css/main.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<div id="div-login">
		<a href="login.do" id="a-login">로그인/회원가입</a>
	</div>
	<div id="div-logout">
		<span id="span-id"></span>
		<a href="logout.do" id="a-logout">로그아웃</a>
	</div>
	<div id="div-header">
		<img id="img-kbo" src="${path}/images/KBO.png" alt="KBO">
		<label id="label-header">야구 직관 프로그램</label>
	</div>

	<div id="div-menu">
		<div id="thisWeekGame">이번주 경기일정</div>
		<div id="selectWatching">직관기록</div>
		<div id="updateInfo">정보수정</div>
	</div>

</div>
<script>
	$('#img-kbo, #label-header').click(() => location.href = 'main');
	$('#thisWeekGame').click(() => location.href = 'gameThisWeek.select');
	$('#selectWatching').click(() => location.href = 'watchingById.select');
	$('#updateInfo').click(() => location.href = 'person.update');
	
	if ("${userid}" !== "" && "${userid}" !== null) {
        $('#div-login').css('display', 'none');
        $('#span-id').html("${userid}"+"님 환영합니다.");
    } else {
        $('#div-logout, #selectWatching, #updateInfo').css('display', 'none');
    }
</script>
</body>
</html>