<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
  label {
	width: 100px;
	height: 26px;
	display: inline-block;
	text-align: right;
	margin-right: 5px;
	padding: 3px;
  }
  input { height: 20px; }
  a { text-decoration: none;}
  .div_form, h1, .insert, .check {
  	display: flex;
  	align-items: center; 
  	justify-content: center;
  }
  .info, .check { margin: 0px; }
  #check_err { 
  	width: 300px;
  	text-align: center;
  	color: gray;
  	}
  #input_insert { height: 40px; }
</style>
</head>
<body>
<a href="main.jsp">홈으로</a>
<h1>회원가입</h1>
<form action="memberRegister.jsp" method="post">
	<div class="div_form">
		<div class="info">
			<label>아이디:</label><input type="text" id="person_id"><br>
			<label>패스워드:</label><input type="text" id="person_pw"><br>
			<label>핸드폰번호:</label><input type="tel" id="person_phone"><br>
			<label>이메일:</label><input type="email" id="person_email">
		</div>
	</div>
	<div class="check">
		<label id="check_err">추후 회원가입 실패사유</label>
	</div>
	<div class="insert">
		<input type="submit" value="회원가입" id="input_insert">
	</div>
	
</form>

</body>
</html>