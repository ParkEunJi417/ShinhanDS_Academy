<%@page import="com.firstzone.emp.EmpDTO"%>
<%@page import="com.firstzone.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String str_empid = "";
String result = "";

if(request.getParameter("empid").equals("")){
	return;
}
str_empid = request.getParameter("empid");
int i_empid = Integer.parseInt(str_empid);
EmpService eService = new EmpService();
EmpDTO emp = eService.selectByIdService(i_empid);

result="사용가능한 직원번호입니다.";
if(emp != null){
	result="사용불가한 직원번호입니다.";
}
%>
<%=result%>