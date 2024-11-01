<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String uid = request.getParameter("userid");
String uname = request.getParameter("username");
%>

<p>당신의 id는 "<%=uid %>" 입니다 </p>
<p>당신의 이름은 "<%=uname %>" 입니다 </p>
</body>
</html>