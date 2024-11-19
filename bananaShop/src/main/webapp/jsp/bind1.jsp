<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Binding 연습1</title>
<script>
function f_local(){
	localStorage.setItem("myname","pej");
	localStorage.setItem("mymajor","computer");
	localStorage.setItem("myscore","95");
}
function f_session(){
	sessionStorage.setItem("myname2","pej2");
	sessionStorage.setItem("mymajor2","computer2");
	sessionStorage.setItem("myscore2","22");
}
</script>
</head>
<body>
	<h1>application/session/request에 Bind 연습</h1>
	<p>myName을 읽음 ▶ ${myName}</p>
	<p>myName2을 읽음 ▶ ${myName2}</p>
	<p>myName3을 읽음 ▶ ${myName3}</p>
	<hr>
	<h2>PC에 저장하기</h2>
	<button onclick="f_local()">Local Storage에 저장</button>
	<button onclick="f_session()">Session Storage에 저장</button>
</body>
</html>