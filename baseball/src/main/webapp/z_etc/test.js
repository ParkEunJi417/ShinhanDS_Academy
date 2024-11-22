let countUsingId = 0;
let validDomain = false;

$('#input-email').prop('readonly', true);
$('#div-usingId').addClass('none');
$('#div-invalidDomain').addClass('none');
$('#div-header').on('click', function() { window.location.href = 'main'; });
$('#btn-insert').on('click', checkValidation);
$('#input-phone').on('input', function () { formatPhoneNumber($(this)); });
$('#input-id').on('input', function () { checkId($(this)); });	
$('#select-domain').on('change', function (event) { toggleInput(event); });
$('#input-showPw').on('change', showPw);

if($('#input-email').is('[required]')){
	$('#input-email').on('input', function () { checkDomain($(this)); });
}

function checkDomain(){
	let value = $input.val();
	
	const emailRegex = /[^\s@]+\.[^\s@]+$/;
	let result = emailRegex.test(value);
	console.log(result);

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

function showPw(){
	if ($('#input-showPw').is(':checked')) {
		$('#input-pw').attr('type', 'text'); // 체크되었을 때 type을 text로 변경
    } else {
    	$('#input-pw').attr('type', 'password'); // 체크 해제 시 type을 password로 변경
    }
}

function checkId($input){
	let value = $input.val();
	
	$.ajax({
		url:"${path}/id.check",
		type:"get",
		data:{ "person_id":$('[name="person_id"]').val() },
		success:function(count){
			countUsingId = count;
			if(count != "0"){
				$('#div-usingId').removeClass('none');
				$('#div-usingId').addClass('block');
			} else {
				$('#div-usingId').removeClass('block');
				$('#div-usingId').addClass('none');
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
        	console.log("checkValidation:"+countUsingId);
            if (!this.checkValidity() || countUsingId != 0 || validDomain) {
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
        $inputEmail.val($(event.target).val()).prop('readonly', true).prop('required', false);
    } else {
    	// input 내용 초기화 & 입력 가능하도록 변경
        $inputEmail.val('').prop('readonly', false).prop('required', true);
		$inputEmail.on('input', function () { checkDomain($(this)); });
    }
}