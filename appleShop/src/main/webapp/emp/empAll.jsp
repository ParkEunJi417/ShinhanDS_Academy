<%@page import="com.firstzone.emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.firstzone.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 table {margin: 0 auto;}
 table, td {border-collapse: collapse;}
 caption {font-size: 35px;}
</style>
</head>
<body>
	<h1>직원목록</h1>
	<table border="1">
		<thead>
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
		</tr>
		</thead>
		<tbody>
		<%
		EmpService eService = new EmpService();
		List<EmpDTO> emplist = eService.selectAllService();
		for(EmpDTO emp:emplist){ %>
			<tr>
				<td><%=emp.getEmployee_id() %></td>
				<td><%=emp.getFirst_name() %></td>
				<td><%=emp.getLast_name() %></td>
				<td><%=emp.getDepartment_id() %></td>
				<td><%=emp.getEmail() %></td>
				<td><%=emp.getPhone_number() %></td>
				<td><%=emp.getJob_id() %></td>
				<td><%=emp.getCommission_pct() %></td>
				<td><%=emp.getSalary() %></td>
				<td><%=emp.getHire_date() %></td>
				<td><%=emp.getManager_id() %></td>
			</tr>
		<%}
		%>
	</tbody>
	</table>
</body>
</html>