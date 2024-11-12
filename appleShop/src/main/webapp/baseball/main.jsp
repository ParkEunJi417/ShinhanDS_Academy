<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구 직관 프로그램</title>
<style>
  label {
	width: 30px;
	height: 26px;
	display: inline-block;
	text-align: right;
	margin-right: 5px;
	padding: 3px;
  }
  a { text-decoration: none;}
  .div_form, h1, div a, .insert {
  	display: flex;
  	align-items: center;
  	justify-content: center;
  }
  .info, .login {
  	height: 65px;
  	display: inline-block;
  }
  .login{
	margin-left: 5px;
	align-content: center;
  } 
  .input { height: 20px; }
  
  #login { height: 60px; }
</style>
</head>
<body>
<a href="main.jsp">홈으로</a>
<div class="all">
	<h1>야구 직관 프로그램</h1>
	<form>
	<div class="div_form">
		<div class="info">
			<label>ID:</label><input class="input" type="text" id="person_id"><br>
			<label>PW:</label><input class="input" type="password" id="person_pw">
		</div>
		<div class="login">
			<input type="submit" value="로그인" id="login">
		</div>
	</div>
	</form>
	<div class="insert">
		<a href="newMember.jsp">회원가입</a>
	</div>
	<div class="game">
		<a href="selectGameThisWeek.jsp">이번주 경기일정</a>
	</div>
</div>
</body>
</html>