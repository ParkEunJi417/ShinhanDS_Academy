<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Binding 연습2</title>
<script>
function f_local(){
	let a = localStorage.getItem("myname","pej");
	let b = localStorage.getItem("mymajor","computer");
	let c = localStorage.getItem("myscore","95");
	document.querySelector("#here").innerHTML = a + "<br>" + b + "<br>" + c + "<br>";
}
function f_session(){
	let a = sessionStorage.getItem("myname2","pej2");
	let b = sessionStorage.getItem("mymajor2","computer2");
	let c = sessionStorage.getItem("myscore2","22");
	document.querySelector("#here").innerHTML = a + "<br>" + b + "<br>" + c + "<br>";
}
</script>
</head>
<body>
	<h1>application/session/request에 Bind 연습2</h1>
	<p>myName을 읽음 ▶ ${myName}</p>
	<p>myName2을 읽음 ▶ ${myName2}</p>
	<p>myName3을 읽음 ▶ ${myName3}</p>
	<hr>
	<h2>PC에 저장하기</h2>
	<button onclick="f_local()">Local Storage에서 읽기</button>
	<button onclick="f_session()">Session Storage에서 읽기</button>
	<hr>
	<div id="here"></div>
</body>
</html>