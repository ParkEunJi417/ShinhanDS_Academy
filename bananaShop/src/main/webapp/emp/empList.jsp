<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 자바 → JSP에서 자바코드를 쓰는 것은 권장사항 아님
%>
<%!
// 선언 → instance field, instance method 권장사항 아님
%>
<%-- jsp주석은 jsp → java로 변환시 무시, jsp ▶ java로 변환 ▶ class 컴파일 ▶ 실행 --%>
<%-- 출력 : <%= %> --%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../jsp/header2.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<!-- include 디렉티브 태그는 jsp를 합쳐서 컴파일함 -->
		<%@ include file="../jsp/header.jsp"%>
		<!-- 각각의 jsp를 따로 컴파일함 -->
		<jsp:include page="../jsp/common.jsp"></jsp:include>
		<div class="input-group mb-3">
			<span class="input-group-text">부서</span>
			<select class="form-control"name="department_id">
				<option value="-1">선택안함</option>
				<c:forEach items="${deptlist}" var="dept">
					<option value="${dept.department_id}">
						${dept.department_name}(${dept.department_id})</option>
				</c:forEach>
			</select>
			<span class="input-group-text">직책</span>
			<select required="required" class="form-control" name="job_id">
				<option value="-1">선택안함</option>
				<c:forEach items="${joblist}" var="job">
					<option ${job.job_id=='IT_PROG'?'selected':''}
						value="${job.job_id}">${job.job_id}/${job.job_title}</option>
				</c:forEach>
			</select>
			<span class="input-group-text">급여(이상)</span>
			<input type="number" class="form-control" placeholder="숫자 입력" name="salary" value="0">
			<span class="input-group-text">입사일(이후)</span>
			<input type="date" class="form-control" name="hire_date">
			<div class="input-group-text">
				<input type="checkbox" class="form-check-input mt-0" name="chkDate" value="1">모든일자
			</div>
			<button id="btn_condition" class="btn btn-success">조건조회</button>
		</div>
		<hr>
		<h1>직원List</h1>
		<div id="table_here">
		</div>
	</div>
<script>
$(function(){
	let today = new Date();
	today.setFullYear(today.getFullYear() - 20);
	$('[name="hire_date"]').val(today.toISOString().split('T')[0]);
	$("#btn_condition").on("click", f_ajax);
	$("#btn_condition").trigger("click"); // 이벤트 호출
});

function f_ajax(){
	$.ajax({
		url:"${path}/emp/emplist2.do",
		type:"get",
		data:{
			"deptid":$('[name="department_id"]').val(),
			"jobid":$('[name="job_id"]').val(),
			"salary":$('[name="salary"]').val(),
			"hdate":$('[name="hire_date"]').val(),
			"chk":$('[name="chkDate"]').prop("checked")
			},
		success:function(responseData){
			// 2.data를 받아서 HTML만들까? NO
			// 3.JSP를 받아서 현재화면에 대치(replace)
			$("#table_here").html(responseData);
		},
		error:function(err){
			alert(err);
		}
	});
}
</script>	
</body>
</html>