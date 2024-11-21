<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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