<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.servletContext.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>야구 직관</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${path}/css/newMember.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
	window.onload = f_init;
	
	function f_init(){
		document.querySelector('#log-in').addEventListener('click', function() {
		      window.location.href = 'login.jsp';
		    });
		document.querySelector('.header').addEventListener('click', function() {
		      window.location.href = 'main.jsp';
		    });
	}
	
	function formatPhoneNumber(input) {
		  // 입력된 값에서 숫자만 추출
		  let value = input.value.replace(/\D/g, '');

		  // 길이에 따라 자동으로 하이픈 추가
		  if (value.length <= 3) {
		    input.value = value;
		  } else if (value.length <= 7) {
		    input.value = value.slice(0, 3) + '-' + value.slice(3);
		  } else {
		    input.value = value.slice(0, 3) + '-' + value.slice(3, 7) + '-' + value.slice(7, 11);
		  }
	}
	
	function toggleInput(event){
		// option에 있는 도메인 선택 시
		if(event.target.value !== "custom") {
		  // 선택한 도메인을 input에 입력하고 disabled
		  document.querySelector('#domainTxt').value = event.target.value;
		  document.querySelector('#domainTxt').disabled = true;
		} else { // 직접 입력 시
		  // input 내용 초기화 & 입력 가능하도록 변경
		  document.querySelector('#domainTxt').value = "";
		  document.querySelector('#domainTxt').disabled = false;
		}
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
  <h2>회원가입</h2>  
  <form action="" method="post">
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
		<div class="input-group mb-3">
			<span class="input-group-text">핸드폰번호</span>
			<input type="text" required="required" class="form-control" name="person_phone"
			  placeholder="010-1234-5678" maxlength="13" oninput="formatPhoneNumber(this)">
		</div>
	</div>
	<div>
		<div class="input-group mb-3">
			<input type="text" class="form-control" placeholder="이메일">
			<span class="input-group-text span-at">@</span>
			<input type="text" class="form-control" id="domainTxt" name="person_email">
			<select class="form-select" id="domainList" onchange="toggleInput(event)">
			    <option value="naver.com">naver.com</option>
			    <option value="gmail.com">gmail.com</option>
			    <option selected value="custom">직접입력</option>
			</select>
			
		</div>
	</div>
	<div>
		<button type="submit" class="btn btn-primary">회원가입</button>
	</div>
  </form>
  <div class="new">
  	<div>
  		<span class="">계정이 있으신가요?</span>
  		<a class="" id="log-in">로그인</a>
  	</div>
  </div> 
</div>
</div>
</body>
</html>