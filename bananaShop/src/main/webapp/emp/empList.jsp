<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- prefix : c로 시작하면 taglib쓴다는 의미 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, td, th { border:1px solid black; }
</style>
</head>
<body>
<%-- 	<p>로그인한 Member정보 request▶${loginMember1}</p> --%>
	<p>로그인한 Member정보 session▶${loginMember2}</p>
<%-- 	<p>로그인한 Member정보 context▶${loginMember3}</p> --%>
	<hr>
	<h1>직원List</h1>
	<table>
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
			<td>
				<a href="detail.do?empid=${emp.employee_id}">${emp.employee_id}</a>	
			</td>
			<td>
				<a href="detail.do?empid=${emp.employee_id}">${emp.first_name}</a>	
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
			<td><button onclick="location.href='delete.do?empid=${emp.employee_id}'">삭제</button></td>
			<td>
				<form action="delete.do" method="post">
					<input type="hidden" value="${emp.employee_id}" name="empid">
					<button>삭제</button>
				</form>
			</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>