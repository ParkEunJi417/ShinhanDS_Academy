<%@page import="entity.CustomerDTO"%>
<%@page import="customer.CustomerRepository"%>
<%@page import="customer.CustomerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>고객 상세보기</h1>
 	<%
 	CustomerRepository repo = new CustomerRepository();
 	CustomerService service = new CustomerService(repo);
 	CustomerDTO customer = service.selectByEmail("customer@naver.com");	
 	%>
 	
 	<table border="1">
 		<tr>
 			<th>고객이메일</th>
 			<td><%= customer.getEmail() %>
 		</tr>
 		<tr>
 			<th>고객이름</th>
 			<td><%= customer.getName() %>
 		</tr>
 		<tr>
 			<th>고객닉네임</th>
 			<td><%= customer.getName() %>
 		</tr>
 		<tr>
 			<th>고객Location</th>
 			<td><%= customer.getLocation() %>
 		</tr>
 	</table>
 	
</body>
</html>