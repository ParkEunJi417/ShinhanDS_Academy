<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구 직관</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap');

  body {
   font-family: "Open Sans", sans-serif;
   color: #23004d;
  }
  label {
	width: 30px;
	height: 26px;
	display: inline-block;
	text-align: right;
	margin-right: 5px;
	padding: 3px;
  }
  a { text-decoration: none;}
  .header, div a, #menu {
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
  #menu div {
  	display: inline-block;
  	border: 2px solid #23004d;
  	margin: 5px;
  }
  #kbo {
  	width: 200px;
	height: auto; 
  }
  #header {
  	width: 300px;
  	text-align: left;
  	font-family: "Black Han Sans", sans-serif;
  	font-size: 2rem;
  	font-style: normal;
  }
  #login { height: 60px; }
</style>
<script>
	window.onload = f_init;
	
	function f_init(){
		document.querySelector('#thisWeekGame').addEventListener('click', function() {
		      window.location.href = 'selectGameThisWeek.jsp';
		    });
	}
    
  </script>
</head>
<body>
<div class="all">
	<div>
		<a href="login.jsp">로그인</a>
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