<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<!-- include 디렉티브 태그는 jsp를 합쳐서 컴파일함 -->
		<%@ include file="../jsp/header.jsp"%>
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
		<table class="table table-striped-columns table-hover">
			<tr>
				<th>직원번호</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>dept</th>
				<th>email</th>
				<th>phone</th>
				<th>job_id</th>
				<th>comm</th>
				<th>salary</th>
				<th>hiredate</th>
				<th>manager</th>
				<th>Get</th>
				<th>Post</th>
			</tr>

			<%-- ${} : getAttribute()라는 의미 --%>
			<c:forEach items="${empDatas}" var="emp">
				<tr>
					<td><a href="${path}/emp/detail.do?empid=${emp.employee_id}">${emp.employee_id}</a>
					</td>
					<td><a href="${path}/emp/detail.do?empid=${emp.employee_id}">${emp.first_name}</a>
					</td>
					<td>${emp.last_name}</td>
					<td>${emp.department_id}</td>
					<td>${emp.email}</td>
					<td>${emp.phone_number}</td>
					<td>${emp.job_id}</td>
					<td>${emp.commission_pct}</td>
					<td>${emp.salary}</td>
					<td>${emp.hire_date}</td>
					<td>${emp.manager_id}</td>
					<td><button
							onclick="location.href='${path}/emp/delete.do?empid=${emp.employee_id}'">삭제</button></td>
					<td>
						<form action="${path}/emp/delete.do" method="post">
							<input type="hidden" value="${emp.employee_id}" name="empid">
							<button>삭제</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>
<script>
$(function(){
	let today = new Date();
	today.setFullYear(today.getFullYear() - 20);
	$('[name="hire_date"]').val(today.toISOString().split('T')[0]);
	$("#btn_condition").on("click", f_ajax);
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