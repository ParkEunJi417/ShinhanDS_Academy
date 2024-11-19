<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.servletContext.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>⚾야구 직관🥎</title>
<meta charset="UTF-8">
<link href="${path}/css/main.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(f_init);

function f_init(){
	$('#thisWeekGame').click(()=>{ $(location).attr('href','selectGameThisWeek.jsp'); });
	$('#a-logout').click(()=>{ alert('개발필요'); });
	
	if ("${result}" !== "" && "${result}" !== null) {
        $('#div-login').css('display', 'none');
        $('#div-logout label').html("${result}");
        $('#div-logout').css('display', 'flex');
    } else {
        $('#div-login').css('display', 'flex');
        $('#div-logout').css('display', 'none');
    }
}
  </script>
</head>
<body>
<div class="div-all">
	<div id="div-login">
		<a href="login.do" id="a-login">로그인</a>
	</div>
	<div id="div-logout">
		<label id="label-id"></label>
		<a href="" id="a-logout">로그아웃</a>
	</div>
	<div class="div-header">
		<img id="img-kbo" src="images/KBO.png" alt="KBO">
		<label id="label-header">야구 직관 프로그램</label>
	</div>
	<div id="div-menu">
		<div id="thisWeekGame">이번주 경기일정</div>
		<div id="insertWatching">직관등록</div>
		<div id="selectWatching">직관기록</div>
		<div id="deleteWatching">직관삭제</div>
		<div id="updateInfo">정보수정</div>
	</div>
</div>
</body>
</html>