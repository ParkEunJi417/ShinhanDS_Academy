<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link href="${path}/css/newPersonRegister.css" rel="stylesheet">
</head>
<body>
<div>
	<div id="div-header">
			<img id="img-kbo" src="${path}/images/KBO.png" alt="KBO">
			<label id="label-header">야구 직관 프로그램</label>
	</div>
	<div class="container mt-3">
	  <h2>회원가입</h2>
	  <div id="div-success">
		  <div class="input-group mb-3">
				<span class="input-group-text">
					회원가입 성공!<br>
					가입한 ID : ${newPersonId}
				</span>
		  </div>
	  </div>
	  <div id="div-fail">
		  <div class="input-group mb-3">
				<span class="input-group-text">
					회원가입 실패..<br>
					다시 가입해주세요
				</span>
				
		  </div>
	  </div>
	  <div>
			<button class="btn btn-primary" id="btn-home">홈으로</button>
			<button class="btn btn-primary" id="btn-login">로그인</button>
			<button class="btn btn-primary" id="btn-new">회원가입</button>
	  </div>  
	</div>
</div>
<script>
	$('#div-success').addClass('none');
	$('#div-fail').addClass('none');
	$('#btn-login').addClass('none');
	$('#btn-new').addClass('none');
	
	$('#img-kbo, #label-header, #btn-home').click(() => location.href = 'main');
	$('#btn-login').click(() => location.href = 'login.do');
	$('#btn-new').click(() => location.href = 'newPerson.insert');
	
	if(${result}){
		$('#div-success').removeClass('none');
		$('#btn-login').removeClass('none');
	} else {
		$('#div-fail').removeClass('none');
		$('#btn-new').removeClass('none');
	}
</script>
</body>
</html>