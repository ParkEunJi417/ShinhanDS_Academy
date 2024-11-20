<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link href="${path}/css/newPerson.css" rel="stylesheet">
<script>
	window.onload = f_init;
	
	function f_init(){
		$('#input-email').prop('disabled', true);
		$('#div-header').on('click', function() { window.location.href = 'main'; });
		$('#btn-insert').on('click', checkValidation);
		$('#input-phone').on('input', function () { formatPhoneNumber($(this)); });
		$('#input-id').on('input', function () { checkId($(this)); });
		$('#select-domain').on('change', function (event) { toggleInput(event); });
	}
	
	function checkId($input){
		let value = $input.val();
		
		$.ajax({
			url:"${path}/id.check",
			type:"get",
			data:{ "person_id":$('[name="person_id"]').val() },
			success:function(count){

				if(count === "1"){
					console.log("이미 존재하는 ID");
				} else {
					console.log("사용 가능한 ID");
				}
				
			},
			error:function(err){
				alert(err);
			}
		});
	}
	
	function checkValidation() {
	    $('.needs-validation').each(function () {
	        
	        $(this).on('submit', function (event) {
	            if (!this.checkValidity()) {
	                event.preventDefault();
	                event.stopPropagation();
	            }
	            $(this).addClass('was-validated');
	        });
	    });
	}
	
	// 사용자가 입력하면 핸드폰 번호 형식으로 자동 세팅
	function formatPhoneNumber($input) {
		// 입력 필드 값에서 숫자가 아닌 모든 문자를 제거
	    let value = $input.val().replace(/\D/g, '');

	    if (value.length <= 3) {
	        $input.val(value);
	    } else if (value.length <= 7) {
	        $input.val(value.slice(0, 3) + '-' + value.slice(3));
	    } else {
	        $input.val(value.slice(0, 3) + '-' + value.slice(3, 7) + '-' + value.slice(7, 11));
	    }
	}
	
	function toggleInput(event) {
		let $inputEmail = $('#input-email');
		// option에 있는 도메인 선택 시
	    if ($(event.target).val() !== "custom") {
	    	// 선택한 도메인을 input에 입력하고 disabled
	        $inputEmail.val($(event.target).val()).prop('disabled', true);
	    } else {
	    	// input 내용 초기화 & 입력 가능하도록 변경
	        $inputEmail.val('').prop('disabled', false).prop('required', true);
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
  <h2>회원가입</h2>  
  <form action="" method="post" class="row g-3 needs-validation" novalidate>
	<div>
		<div class="input-group mb-3">
			<span class="input-group-text">아이디</span>
			<input type="text" required="required" class="form-control" name="person_id"
			 maxlength="20" placeholder="최대 20자" id="input-id">
			<div class="invalid-feedback">
	          아이디를 입력해주세요
	        </div>
	        <div id="span-usingId" style="display: block; width: 100%; color:#dc3545; font-size: 14px;">사용중인 아이디입니다</div>
		</div>
	</div>
	<div>
		<div class="input-group mb-3">
			<span class="input-group-text">패스워드</span>
			<input type="password" required="required" class="form-control" name="person_pw"
			 maxlength="20" placeholder="최대 20자">
			<div class="invalid-feedback">
	          패스워드를 입력해주세요
	        </div>
		</div>
	</div>
	<div>
		<div class="input-group mb-3">
			<span class="input-group-text">핸드폰번호</span>
			<input type="text" required="required" class="form-control" name="person_phone"
			  maxlength="13" id="input-phone">
			<div class="invalid-feedback">
	          핸드폰번호를 입력해주세요
	        </div>  
		</div>
	</div>
	<div>
		<div class="input-group mb-3">
			<input type="text" required="required" class="form-control" placeholder="이메일">
			<span class="input-group-text span-at">@</span>
			<input type="text" class="form-control" id="input-email" name="person_email">
			<div class="invalid-feedback">
		      이메일을 입력해주세요
		    </div>
		</div>
	</div>
	<div>
		<div class="input-group mb-3">
			<select required="required" class="form-select" id="select-domain">
			    <option value="" selected disabled>주소선택</option>
			    <option value="naver.com">naver.com</option>
			    <option value="gmail.com">gmail.com</option>
			    <option value="custom">직접입력</option>
			</select>
			<div class="invalid-feedback">
		      이메일 주소를 선택해주세요
		    </div>
		</div>
	</div>
	<div>
		<button type="submit" class="btn btn-primary" id="btn-insert">회원가입</button>
	</div>
  </form>
  <div id="div-new">
  	<div>
  		<span>계정이 있으신가요?</span>
  		<a href="login.do" id="a-login">로그인</a>
  	</div>
  </div> 
</div>
</div>
</body>
</html>