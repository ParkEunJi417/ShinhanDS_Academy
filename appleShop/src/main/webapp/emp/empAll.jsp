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
<link href="https://fonts.googleapis.com/css2?family=Gaegu&family=Jua&display=swap" rel="stylesheet">
<style>
	table, th, td {
			 		border: 1px solid black;
			 		border-collapse: collapse;
	}
	th, td { padding: 5px; }
	th { background-color: orange; }
	/* tag 이름 사이의 공백은 자손을 의미 */
	tbody tr:nth-child(2n) { /* nth-child(2n) → 짝수번째 */
		background-color: lightgray;
	}
	tbody tr:nth-child(2n+1) { /* nth-child(2n+1) → 홀수번째 */
		background-color: lightblue;
	}
	caption {
		font-family: "Gaegu", sans-serif;
		font-weight: 400;
		font-style: normal;
		font-size: 2em;
	}
	span {
		color: red;
	}
	a.new {
		display: block;
		padding: 10px;
	}
</style>
</head>
<body>
	<div id="container">
	<header>
		<h1>다음의 목록은 <span>직원정보</span>입니다.</h1>
	</header>
	<main>
		<section>
		<div>
		<a class="new" href="empInsert.jsp">신규직원등록</a>
		<a class="new" href="../dept/deptInsert.jsp">신규부서등록</a>
		<table>
			<caption>직원목록</caption>
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
		</div>
		</section>
	</main>
	</div>
</body>
</html>