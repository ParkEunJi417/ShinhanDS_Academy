<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>beanTest2 페이지</h1>
<jsp:useBean id="member2" class="com.firstzone.member.MemberDTO" scope="request"/>
<p>id:<jsp:getProperty property="member_id" name="member2"/> </p>
<p>name:<jsp:getProperty property="member_name" name="member2"/> </p>
<p>email:<jsp:getProperty property="member_email" name="member2"/> </p>
<p>pass:<jsp:getProperty property="member_pass" name="member2"/> </p>
</body>
</html>