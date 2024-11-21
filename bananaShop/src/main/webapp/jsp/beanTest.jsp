<%@page import="com.firstzone.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>beanTest 페이지</h1>
<!--  JSP에서 자바 작성코드 (권장안함) -->
<h2>JSP에서 자바 작성 코드</h2>
<%
MemberDTO member = new MemberDTO();
member.setMember_id("park");
member.setMember_name("박은지");
member.setMember_email("eun@naver.com");
member.setMember_pass("1234");
%>
<p>id:<%=member.getMember_id() %></p>
<p>name:<%=member.getMember_name() %></p>
<p>email:<%=member.getMember_email() %></p>
<p>pass:<%=member.getMember_pass() %></p>
<hr>
<!-- JSP에서 자바빈스 사용(action tag) -->
<h2>JSP에서 자바빈스 사용(action tag)</h2>
<jsp:useBean id="member2" class="com.firstzone.member.MemberDTO" scope="request"/>
<jsp:setProperty property="member_id" name="member2" value="park2"/>
<jsp:setProperty property="member_name" name="member2" value="박은지2"/>
<jsp:setProperty property="member_email" name="member2" value="eun2@naver.com"/>
<jsp:setProperty property="member_pass" name="member2" value="12345"/>

<p>id:<jsp:getProperty property="member_id" name="member2"/> </p>
<p>name:<jsp:getProperty property="member_name" name="member2"/> </p>
<p>email:<jsp:getProperty property="member_email" name="member2"/> </p>
<p>pass:<jsp:getProperty property="member_pass" name="member2"/> </p>

<%-- <jsp:forward page="beanTest2.jsp"></jsp:forward> --%>
<hr><jsp:include page="beanTest2.jsp"></jsp:include>
</body>
</html>