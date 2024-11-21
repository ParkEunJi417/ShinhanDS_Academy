<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../jsp/header2.jsp"%>
<fmt:setLocale value="en_US"/>
<title>Insert title here</title>
</head>
<body>

<table class="table table-striped table-hover">
			<tr>
				<th>No</th>
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
			<c:forEach items="${empDatas}" var="emp" varStatus="status">
				<tr>
					<td>
						${status.count}
						<c:if test="${status.first}">첫번째</c:if>
						<c:if test="${status.last}">마지막</c:if>
						<c:if test="${status.count mod 2 == 0}">짝수</c:if>
					</td>
					<td><a href="${path}/emp/detail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td>
					<td><a href="${path}/emp/detail.do?empid=${emp.employee_id}">${emp.first_name}</a></td>
					<td>${emp.last_name}</td>
					<td>${emp.department_id}</td>
					<td>${fn:toLowerCase(emp.email)}</td>
					<td>${fn:replace(emp.phone_number,".","-")}</td>
					<td>${emp.job_id}</td>
					<td>${emp.commission_pct}</td>
					<td>
						<fmt:formatNumber type="currency" value="${emp.salary}"/>
					</td>
					<td>
						<fmt:formatDate type="date" dateStyle="full" value="${emp.hire_date}"/> 
					</td>
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