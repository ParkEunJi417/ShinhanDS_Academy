<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>야구 직관</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <style>
    .mt-3 { width: 50%;}
    form div, h2, .new{
    	display: flex;
    	justify-content: center;
      	align-items: center;
    }
    .mb-3 {width: 300px;}
    .form-control { width: 200px;}
    #log-in {color: black;}
    .new a:hover {
      cursor: pointer; 
    }
  </style>
  <script>
	window.onload = f_init;
	
	function f_init(){
		document.querySelector('#log-in').addEventListener('click', function() {
		      window.location.href = 'login.jsp';
		    });
	}
  </script>
</head>
<body>

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
	      <input type="text" required="required" class="form-control" name="person_pw" >
	    </div>
	  </div>
	  <div>
	  	<div class="input-group mb-3">
	      <span class="input-group-text">핸드폰번호</span>
	      <input type="text" required="required" class="form-control" name="person_pw" >
	    </div>
	  </div>
	  <div>
	  	<div class="input-group mb-3">
	      <span class="input-group-text">이메일</span>
	      <input type="text" required="required" class="form-control" name="person_pw" >
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

</body>
</html>