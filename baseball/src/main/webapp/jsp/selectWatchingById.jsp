<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link href="${path}/css/selectWatchingById.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<div id="div-header">
			<img id="img-kbo" src="${path}/images/KBO.png" alt="KBO">
			<label id="label-header">야구 직관 프로그램</label>
	</div>
	<h2>직관기록</h2>
	<div id="div-title">
		<label>직관승률:50%</label>
		<div id="div-button">
			<button type="button" class="btn btn-primary" data-bs-toggle="modal"
					data-bs-target="#div-insertModal" data-bs-whatever="@mdo" id="btn-insertModal">
					직관등록
			</button>
			<button type="button" class="btn btn-danger" data-bs-toggle="modal"
					data-bs-target="#div-deleteModal" data-bs-whatever="@mdo" id="btn-deleteModal">
					직관삭제
			</button>
		</div>
	</div>
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col"><input class="form-check-input" type="checkbox" id="input-selectAll"></th>
	      <th scope="col">No</th>
	      <th scope="col">경기일정</th>
	      <th scope="col">매칭</th>
	      <th scope="col">응원한 팀</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${watchingData}" var="wt" varStatus="status">
	  <tr class="${wt.color}">
	  	  <td><input class="form-check-input" type="checkbox" value="${wt.watch_no}"></td>
		  <td>${status.index+1}</td>
		  <td class="date">${wt.game_date}</td>
		  <td>
			<div class="container">
			       <div class="teamName">${wt.team_name_a}</div>
					<div data-teamid="${wt.team_id_a}"></div>
					<div class="score" >${wt.team_score_a}</div>
					<div> vs </div>
					<div class="score">${wt.team_score_h}</div>
					<div data-teamid="${wt.team_id_h}"></div>
					<div class="teamName">${wt.team_name_h}</div>
			  </div>
		   </td>
		   <td>${wt.teamname}</td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	<div class="modal fade" id="div-insertModal" tabindex="-1" style="display: none;">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5">직관등록</h1>
          </div>
          <div class="modal-body">
            <form id="form-insertModal" action="newWatching.insert">
            <div class="input-group mb-2">
				<span class="input-group-text">경기일정</span>
 				<select class="form-select" id="select-date"></select>
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">경기목록</span>
				<select class="form-select" id="select-game" name="game_no">
					<option value="" selected disabled>경기선택</option>
				</select>
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">응원한 팀</span>
				<select class="form-select" id="select-team" name="watch_team_id">
                	<option value="" selected disabled>팀선택</option>
                </select>
			</div>
			<div id='div-validWatching'>
                	이미 등록된 직관 경기입니다.
            </div>
            </form>
          </div>
           <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
            <button type="button" form="form-watching" class="btn btn-primary" id="btn-insert">등록</button>
          </div> 
        </div>
      </div>
    </div>
	<div class="modal fade" id="div-deleteModal" tabindex="-1" style="display: none;">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5">직관삭제</h1>
          </div>
          <div class="modal-body">
            <div class="input-group mb-2" id="div-deleteModalMessage"></div>
          </div>
           <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
            <form id="form-deleteModal" action="watchingsById.delete" method="post">
            	<input type="hidden" name="watch_no" id="input-watchno">
            	<button type="button" form="form-watching" class="btn btn-danger" id="btn-delete">삭제</button>
            </form>
          </div> 
        </div>
      </div>
    </div>
</div>
<script>
	let isInvalidWatching = false;
	let isSelectDate = false;
	let isSelectGame = false;
	let isSelectTeam = false;
	
	$('#img-kbo, #label-header').click(() => location.href = 'main');
	$('#btn-delete').click(deleteWatching); // 선택된 직관 삭제
	$('#btn-deleteModal').click(checkDeleteRows); // 직관삭제 모달
	$('#btn-insert').click(checkValidation); // 직관등록 모달 값 모두 입력됐는지 확인
	$('#btn-insertModal').click(() => { // 직관등록 모달
	    $('#div-validWatching').addClass('none');
	    selectAllGameDate(); // 경기일정 ajax로 받아오기
	});
	$('tbody tr').click(function(event) { toggleCheckbox(event, this); }); // 행 클릭시 체크
	
	$('#select-date').change(selectByGameDate); // 해당 일자의 경기 일정 받아서 경기목록 option 부여
	$('#select-game').change(() => { 
	    selectByMatchTeam(); // 해당 날짜의 경기한 팀 받아서 응원한 팀 option 부여
	    selectGameNoById(); // 기등록 직관 경기 확인
	});
	$('#input-selectAll').change(function() {
	    $('tbody input[type="checkbox"]').prop('checked', this.checked); // 전체 체크 및 해제
	});
	
	function deleteWatching(){
        // 체크된 행의 input value를 수집
        let inputValues = [];
        $("table tr").each(function () {
            // 행의 체크박스가 체크된 경우
            if ($(this).find("input").is(":checked")) {
                // input 값을 가져와 배열에 추가
                let inputValue = $(this).find("input").val();
                
                if(inputValue != 'on'){
                	inputValues.push(inputValue);
                }
            }
        });
        let valuesString = inputValues.join(',');
        $('#input-watchno').val(valuesString);
        $('#form-deleteModal').submit();
	}
	
	// 직관삭제 모달 내용 보여주기
	function checkDeleteRows(){
		let cntCheckedRows = $('tbody input[type="checkbox"]:checked').length;

		$('#div-deleteModalMessage').html(cntCheckedRows+'개의 직관기록을 삭제하시겠습니까?');
	}
	
	// 행 클릭시 체크
	function toggleCheckbox(event, row) {
		if (!$(event.target).is('input[type="checkbox"]')) {
			$(row).find('input[type="checkbox"]').prop('checked', function(_, checked) {
		      return !checked;
		    });
		}
	}
	
	// 직관등록 모달 값 모두 입력됐는지 확인
	function checkValidation(event){
		let selectedDate = $('#select-date').val();
		let selectedGame = $('#select-game').val();
		let selectedTeam = $('#select-team').val();
		
 		if (selectedDate) { isSelectDate = true; }
		else { isSelectDate = false; }
		if (selectedGame) { isSelectGame = true; }
		else { isSelectGame = false; }
		if (selectedTeam) { isSelectTeam = true; }
		else { isSelectTeam = false; }

		if (isInvalidWatching && isSelectDate && isSelectGame & isSelectTeam) {
			$('#form-insertModal').submit();
        }
	}
	
	// 기등록 직관 경기 확인
	function selectGameNoById(){
		$.ajax({
			url:"${path}/gameNoById.select",
			type:"get",
			data:{ "no":$('#select-game').val() },
			success:function(cnt){
				if(Number(cnt) != 0){
					$('#div-validWatching').removeClass('none').addClass('block');
					isInvalidWatching = false;
				} else {
					$('#div-validWatching').removeClass('block').addClass('none');
					isInvalidWatching = true;
				}
			},
			error:function(){}
		});
	}
	
	// 해당 날짜의 경기한 팀 받아서 응원한 팀 option 부여
	function selectByMatchTeam(){
		$.ajax({
			url:"${path}/matchTeam.select",
			type:"get",
			data:{
				"date":$('#select-date').val(),
				"no":$('#select-game').val()
				},
			success:function(data){
				$('#select-team').html(data);
			},
			error:function(){}
		});
	}
	
	// 해당 일자의 경기 일정 받아서 경기목록 option 부여
	function selectByGameDate(){
		$.ajax({
			url:"${path}/gameDate.select",
			type:"get",
			data:{"date":$('#select-date').val()},
			success:function(data){
				$('#select-game').html(data);
			},
			error:function(){}
		});
	}
	
	// 모든 경기 일정 받아서 경기일정 option 부여
	function selectAllGameDate(){
		$.ajax({
			url:"${path}/allGameDate.select",
			type:"get",
			success:function(data){
				$('#select-date').html(data);
			},
			error:function(){}
		});
	}
</script>
</body>
</html>