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
  input {
  	margin: 0px;
  	height: 20px;
  	display: inline-block;
  	padding: 3px;
  }
  
  .div_form {
  	border: 1px solid gray;
  	display: flex;
  	align-items: center; 
  	justify-content: center;
  } 
  #input_insert {
  	height: 40px;
  }
</style>
</head>
<body>
<h1>회원가입</h1>
<form action="memberRegister.jsp" method="post">
	<div class="div_form">
		<div>
			<label>아이디:</label><input type="text" id="person_id">
			<button id="btn_checkId">중복확인</button>
			<label id="label_checkId">&nbsp;</label>
		</div>
		<div>
			<label>패스워드:</label><input type="text" id="person_pw">
		</div>	
		<div>
			<label>핸드폰번호:</label><input type="tel" id="person_phone">
		</div>	
		<div>
			<label>이메일:</label><input type="email" id="person_email">
		</div>	
	</div>
	<input type="submit" value="회원가입" id="input_insert">
</form>

</body>
</html>