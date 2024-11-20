<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}"></c:set>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>
	#loginInfo{
		background-color: beige;
	}
</style>
<div id="loginInfo">
	<p>
		${loginMember2.member_name==null?"손님":loginMember2.member_name}님 환영합니다.
		<a href="${path}/auth/logout.do">로그아웃</a>
	</p>
</div>
<hr>
<!-- request영역 → session영역 → application영역 -->
<!-- EL(Ecpression Language)의 내장객체 -->
<%-- 1. ${company}<br>
2. ${requestScope.company}<br>
3. ${sessionScope.company}<br>
4. ${applicationScope.company}<br>

<!-- JSP내장객체이용 Expression -->
2. <%=request.getAttribute("company") %><br>
3. <%=session.getAttribute("company") %><br>
4. <%=application.getAttribute("company") %> --%>