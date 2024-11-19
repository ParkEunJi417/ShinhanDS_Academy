<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.servletContext.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>⚾야구 직관🥎</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${path}/css/login.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(f_init);

	function f_init(){
		$('#sign-up').on('click', function() { window.location.href = 'newMember.jsp'; });
		$('.header').on('click', function() { window.location.href = 'main.jsp'; });
	}
</script>
</head>
<body>
<div class="all">
	<div class="header">
			<img id="kbo" src="images/KBO.png" alt="KBO">
			<label id="header">야구 직관 프로그램</label>
	</div>
	<div class="container mt-3">
	  <h2>로그인</h2> 
	  <form action="login.do" method="post">
		  <div>
		  	<div class="input-group mb-3">
		      <span class="input-group-text">아이디</span>
		      <input type="text" required="required" class="form-control" name="person_id" >
		    </div>
		  </div>
		  <div>
		  	<div class="input-group mb-3">
		      <span class="input-group-text">패스워드</span>
		      <input type="password" required="required" class="form-control" name="person_pw" >
		    </div>
		  </div>
		  <div>
		  	<button type="submit" class="btn btn-primary" id="login">로그인</button>
		  </div>
		  <div>
			<span id="error-message">${param.message}</span>
		  </div>
	  </form>
	  <div class="new">
		  <div>
		  	<span class="">계정이 없으신가요?</span>
		    <a class="" id="sign-up">회원가입</a>
		  </div>
	  </div> 
	</div>
</div>
</body>
</html>