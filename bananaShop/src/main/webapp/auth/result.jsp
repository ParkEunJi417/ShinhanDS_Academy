<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="2;url=../emp/emplist.do">
<title>Insert title here</title>
<style>
	.orange {
		background-color: orange;
		color: purple;
		border: 5px dotted blue;
	}
</style>
</head>
<body>
	<h1 class="orange">${result}</h1>
	<%
		Cookie[] arr = request.getCookies();
		for(Cookie cc:arr){
			String val = cc.getValue();
			if(cc.getName().equals("loginName")){
				val = URLDecoder.decode(val,"utf-8");
			}
			out.print("<p>" + cc.getName() + ":" + val + "</p>");
		}
	%>
</body>
</html>