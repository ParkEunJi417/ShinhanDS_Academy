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
<script>
	window.onload = f_init;
	
	function f_init(){
		document.querySelector('#thisWeekGame').addEventListener('click', function() {
		      window.location.href = 'selectGameThisWeek.jsp';
		    });
		document.querySelector('#login').innerHTML="${result}";
	}
    
  </script>
</head>
<body>
<div class="all">
	<div>
		<a href="login.do" id="login">로그인</a>
	</div>
	<div class="header">
		<img id="kbo" src="images/KBO.png" alt="KBO">
		<label id="header">야구 직관 프로그램</label>
	</div>
	<div id="menu">
		<div id="thisWeekGame">이번주 경기일정</div>
		<div>직관등록</div>
		<div>직관기록</div>
		<div>직관삭제</div>
		<div>정보수정</div>
	</div>
</div>
</body>
</html>