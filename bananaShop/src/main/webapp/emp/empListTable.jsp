<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../jsp/header.jsp"%>
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
</body>
</html>