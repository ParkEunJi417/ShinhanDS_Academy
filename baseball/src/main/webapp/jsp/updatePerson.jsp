<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link href="${path}/css/updatePerson.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<div id="div-header">
			<img id="img-kbo" src="${path}/images/KBO.png" alt="KBO">
			<label id="label-header">야구 직관 프로그램</label>
	</div>
	<div class="container mt-3">
		<h2>정보수정</h2>  
		<form action="person.update" method="post" class="row g-3 needs-validation" novalidate>
		<div>
			<div class="input-group mb-2">
				<span class="input-group-text">아이디</span>
				<input type="text" class="form-control" name="person_id" id="input-id" 
				 value="${info.person_id}">
			</div>
		</div>
		<div>
			<div class="input-group mb-2">
				<span class="input-group-text">패스워드</span>
				<input type="password" required="required" class="form-control" name="person_pw"
				 maxlength="20" placeholder="최대 20자" id="input-pw">
				<div id="div-showPw">
				 	<input class="form-check-input" type="checkbox" id="input-showPw">
				 	<label for="input-showPw" id="label-showPw">패스워드 표시</label>
				</div>
				<div class="invalid-feedback">
		        	 패스워드를 입력해주세요
		        </div>
			</div>
		</div>
		<div>
			<div class="input-group mb-2">
				<span class="input-group-text">핸드폰번호</span>
				<input type="text" required="required" class="form-control" name="person_phone"
				 maxlength="13" placeholder="010-1234-5678" id="input-phone" value="${info.person_phone}">
				<div class="invalid-feedback">
		          핸드폰번호를 입력해주세요
		        </div>  
			</div>
		</div>
		<div>
			<div class="input-group mb-2">
				<input type="text" required="required" class="form-control" placeholder="이메일"
				 name="person_email" id="input-email">
				<span class="input-group-text span-at">@</span>
				<input type="text" class="form-control" id="input-domain" name="person_domain">
				<div class="invalid-feedback">
			      이메일을 입력해주세요
			    </div>
			    <div id="div-invalidDomain">
		          주소형식에 맞게 입력해주세요 ex)naver.com
		        </div>
			</div>
		</div>
		<div>
			<div class="input-group mb-2">
				<select required="required" class="form-select" id="select-domain" name="select-domain">
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
			<button type="submit" class="btn btn-primary" id="btn-update">정보수정</button>
		</div>
		</form>
	</div>
</div>
<script>
	let validDomain = true;
	
	$('#input-email').val('${info.person_email.split("@")[0]}');
	$('#select-domain').val('${info.person_email.split("@")[1]}');
	$('#input-domain').val($('#select-domain').val());
	
	$('#input-id').prop('disabled', true);
	$('#input-domain').prop('readonly', true);
	$('#div-invalidDomain').addClass('none');
	
	$('#img-kbo, #label-header').click(() => location.href = 'main');
	$('#btn-update').click(checkValidation); // 회원가입시 값 입력됐는지 확인
	
	$('#input-phone').on('input', () => formatPhoneNumber($('#input-phone'))); // 핸드폰 번호 형식 세팅
	
	$('#select-domain').on('change', toggleInput); // 도메인에 따라 input 활성화/비활성화
	$('#input-showPw').on('change', showPw); // 패스워드 표시
	
	// 회원가입시 값 입력됐는지 확인
	function checkValidation() {
	    $('.needs-validation').each(function () {
	        
	        $(this).on('submit', function (event) {
	        	
	            if (!this.checkValidity() || !validDomain) {
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
	
	// 사용자가 선택한 도메인에 따라 input 활성화/비활성화
	function toggleInput(event) {
		let $inputDomain = $('#input-domain');
		// option에 있는 도메인 선택 시
	    if ($(event.target).val() !== "custom") {
	    	// 선택한 도메인을 input에 입력하고 disabled
	        $inputDomain.val($(event.target).val()).prop('readonly', true).prop('required', false);
	        $('#div-invalidDomain').addClass('none');
	    } else {
	    	// input 내용 초기화 & 입력 가능하도록 변경
	        $inputDomain.val('').prop('readonly', false).prop('required', true);
	        $inputDomain.on('input', function () { checkDomain($inputDomain); });
	    }
	}
	
	function checkDomain($input){
		let value = $input.val();
		
		const emailRegex = /[^\s@]+\.[^\s@]+$/;
		let result = emailRegex.test(value);
        if (emailRegex.test(value)) {
        	validDomain = true;
            $('#div-invalidDomain').removeClass('block');
			$('#div-invalidDomain').addClass('none');
        } else {
            validDomain = false;
            $('#div-invalidDomain').removeClass('none');
			$('#div-invalidDomain').addClass('block');
        }
	}
	
	// 패스워드 표시 체크시 입력한 값 보여줌
	function showPw(){
		if ($('#input-showPw').is(':checked')) {
			$('#input-pw').attr('type', 'text'); // 체크되었을 때 type을 text로 변경
	    } else {
	    	$('#input-pw').attr('type', 'password'); // 체크 해제 시 type을 password로 변경
	    }
	}
</script>
</body>
</html>