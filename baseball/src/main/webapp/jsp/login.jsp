<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link href="${path}/css/login.css" rel="stylesheet">
<script>
	$(init);

	function init(){
		$('#div-header').on('click', function() { window.location.href = 'main'; });
		setId();
	}
	
	function setId(){
		let urlParams = new URLSearchParams(window.location.search);
        let idParam = urlParams.get('id');
        console.log(idParam);

        if (idParam != null) {
            $('#input-id').val(urlParams.get('id'));
            $('#input-pw').focus();
        }
	}
</script>
</head>
<body>
<div>
	<div id="div-header">
			<img id="img-kbo" src="images/KBO.png" alt="KBO">
			<label id="label-header">야구 직관 프로그램</label>
	</div>
	<div class="container mt-3">
	  <h2>로그인</h2> 
	  <form action="login.do" method="post">
		  <div>
		  	<div class="input-group mb-3">
		      <span class="input-group-text">아이디</span>
		      <input type="text" required="required" class="form-control" name="person_id" id="input-id">
		    </div>
		  </div>
		  <div>
		  	<div class="input-group mb-3">
		      <span class="input-group-text">패스워드</span>
		      <input type="password" required="required" class="form-control" name="person_pw" id="input-pw">
		    </div>
		  </div>
		  <div>
		  	<button type="submit" class="btn btn-primary" id="btn-login">로그인</button>
		  </div>
		  <div>
			<span id="span-errorMessage">${param.message}</span>
		  </div>
	  </form>
	  <div id="div-new">
		  <div>
		  	<span>계정이 없으신가요?</span>
		    <a href="newPerson.insert" id="a-signUp">회원가입</a>
		  </div>
	  </div> 
	</div>
</div>
</body>
</html>