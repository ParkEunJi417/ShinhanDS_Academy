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
	height: 20px;
	display: inline-block;
	text-align: right;
	margin-right: 5px;
  }
  .div_form, h1, a, .insert {
  	display: flex;
  	align-items: center;
  	justify-content: center;
  }
  .info, .login {
  	margin: 0px;
  	height: 52px;
  	display: inline-block;
  }
  .login{ margin-left: 5px; } 
  .input { height: 20px; }
  
  #login { height: 52px; }
</style>
</head>
<body>
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
</div>
</body>
</html>