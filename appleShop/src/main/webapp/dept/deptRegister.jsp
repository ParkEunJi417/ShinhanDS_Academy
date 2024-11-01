<%@page import="com.firstzone.dept.DeptDTO"%>
<%@page import="com.firstzone.dept.DeptService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>부서등록중</h1>
<%
	String deptid=request.getParameter("department_id");
	String deptname=request.getParameter("department_name");
	String locid=request.getParameter("location_id");
	String mid=request.getParameter("manager_id");
	
	int i_deptid = Integer.parseInt(deptid);
	int i_locid = Integer.parseInt(locid);
	int i_mid = Integer.parseInt(mid);
	
	DeptService dService = new DeptService();
	DeptDTO dept = new DeptDTO(i_deptid,deptname,i_mid,i_locid);
	int result = dService.insertService(dept);

%>
<h2><%=result %>건 입력됨</h2>
<p><a href="deptAll.jsp">부서목록 가기</a>
</body>
</html>