<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<form action="memberRegister.jsp" method="post">
	<label>아이디:</label><input type="text" id="person_id">
	<button id="btn_checkId">중복확인</button>
	<label id="label_checkId"></label><br>
	<label>패스워드:</label><input type="text" id="person_pw"><br>
	<label>핸드폰번호:</label><input type="tel" id="person_phone"><br>
	<label>이메일:</label><input type="email" id="person_email"><br>
	<input type="submit" value="회원가입" id="insert">
</form>

</body>
</html>