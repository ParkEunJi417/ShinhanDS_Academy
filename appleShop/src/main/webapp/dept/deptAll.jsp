<%@page import="com.firstzone.dept.DeptDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.firstzone.dept.DeptService"%>
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
 thead {background-color: hotpink;}
 caption {font-size: 35px;}
 caption {color:blue;}
 #cups {margin: 0 auto;
 		border:1px solid gray;
 		width:50%;}
</style>
</head>
<body>
	<div id="cups">
		<!-- HTML주석(HTML해석기가 해석을 하지 않음)  
		상대경로 : 나의 문서를 기준
		절대경로 : http://localhost:9090이후 작성, /부터 시작
				 /appleShop의 위치는 webapp폴더임
		-->
		
		<img alt="무지개컵이미지" src="../resources/image/cup-4.jpg" width="200" height="100">
		<img alt="땡땡이컵이미지" src="/appleShop/resources/image/cup-3.jpg" width="200" height="100">
	</div>
	
	<table border="1">
		<caption>부서목록
			<a href="deptInsert.jsp">부서등록</a>
		</caption>
		<thead>
		<tr>
			<th>department_id</th>
			<th>department_name</th>
			<th>location_id</th>
			<th>manager_id</th>
		</tr>
		</thead>
		<tbody>
		<%
		DeptService dService = new DeptService();
		List<DeptDTO> deptlist = dService.selectAllService();
		for(DeptDTO dept:deptlist){%>
			<tr>
				<td><%=dept.getDepartment_id() %></td>
				<td><%=dept.getDepartment_name() %></td>
				<td><%=dept.getLocation_id() %></td>
				<td><%=dept.getManager_id() %></td>
			</tr>
		<%}
		%>
		</tbody>
	</table>
</body>
</html>