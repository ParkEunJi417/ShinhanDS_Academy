<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  table, th, tr, td {
  	border: 1px solid gray;
  	border-collapse: collapse;
  	text-align: center;
  	padding: 5px;
  }
  th { background-color: lightgray; }
</style>
</head>
<body>
<%@ include file="../jsp/header.jsp" %>
<h2>부서 등록</h2>  
<table class="table table-striped-columns table-hover">
	<tr>
		<th>부서번호</th>
		<th>부서이름</th>
		<th>부서장</th>
		<th>지역번호</th>
	</tr>

	<c:forEach items="${deptDatas}" var="dept">
		<tr>
			<td><a href="detail.do?deptid=${dept.department_id}">${dept.department_id}</a></td>
			<td>${dept.department_name}</td>
			<td>${dept.manager_id}</td>
			<td>${dept.location_id}</td>
			<td><button onclick="location.href='delete.do?deptid=${dept.department_id}'">삭제</button></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>