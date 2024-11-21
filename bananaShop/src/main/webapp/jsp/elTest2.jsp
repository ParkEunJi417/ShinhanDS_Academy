<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.firstzone.emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.firstzone.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
EmpService eService = new EmpService();
List<EmpDTO> emplist = eService.selectAllService();
pageContext.setAttribute("empDatas", emplist);

Map<String, List<EmpDTO>> map = new HashMap<>();
map.put("empMap",emplist);
pageContext.setAttribute("mymap", map);
Date d1 = new Date();
request.setAttribute("today", d1);
request.setAttribute("salary", 1234567890);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>

</script>
<title>Insert title here</title>
</head>
<body>
1. 스크립트릿의 expression 이용 : <%=emplist.get(0).getFirst_name() %><br>
2. EL이용하기 : ${empDatas[0].first_name}<br>
2. EL이용하기 : <br>
	<fmt:setLocale value="en_US"/>
	<h3>입사일:<fmt:formatDate value="${empDatas[0].hire_date}" pattern="yyyy/MM/dd hh:mm:ss"/></h3>
	<h3>오늘:<fmt:formatDate value="${today}" type="both" dateStyle="full" timeStyle="full"/></h3>
	<h3>급여:<fmt:formatNumber value="${salary}" type="currency" groupingUsed="true" currencySymbol="\\"/></h3>
3. EL이용하기(map) : ${mymap.empMap[0].first_name}
<hr>
<!-- JSTL(JSP Standard Tag Library) -->
1. setAttribute(값 저장)<br>
<c:set var="major" value="컴퓨터공학과" scope="page"/>
<c:set var="path2" value="${pageContext.servletContext.contextPath}"/>
2. getAttribute<br>
major : ${major}<br>
path2 : ${path2}<br>
<%-- <%@ include file="header2.jsp" %> --%>
path : ${path}
<hr>
3. 조건문
<c:if test="${loginMember==null}">
	<ul>
		<li><a href="${path}/dept/select.do">부서조회</a></li>
		<li><a href="${path}/dept/insert.do">부서입력</a></li>
	</ul>
</c:if>
<c:if test="${loginMember!=null}">
	<ul>
		<li><a href="${path}/emp/emplist.do">직원조회</a></li>
		<li><a href="${path}/emp/insert.do">직원입력</a></li>
		<li><a href="${path}/dept/select.do">부서조회</a></li>
		<li><a href="${path}/dept/insert.do">부서입력</a></li>
	</ul>
</c:if>
<hr>
4. choose : 
<%
request.setAttribute("score", 75);
%>
<c:choose>
	<c:when test="${score >= 90}">
		<p>A학점</p>
	</c:when>
	<c:when test="${score >= 80}">
		<p>B학점</p>
	</c:when>
	<c:when test="${score < 80}">
		<p>노력요함</p>
	</c:when>
</c:choose>
<hr>
5.반복(forEach) : 
<c:set var="total" value="0"/>
<c:forEach begin="1" end="5" step="1" var="i">
	<p>foreach로 반복중 ▶ ${i}</p>
	<c:set var="total" value="${total+i}"/>
</c:forEach>
<p>1~5까지 합계 ▶ ${total}</p>
<hr>
<ul>
	<li>loopStatus.index/loopStatus.count/loopStatus.first/emp.first_name
	<c:forEach items="${empDatas}" var="emp" varStatus="loopStatus">
		<li>${loopStatus.index}/${loopStatus.count}/${loopStatus.first}/${emp.first_name}</li>
	</c:forEach>
</ul>
<hr>
6.url만들기 : JSTL의 url태그는 default로 contextPath를 사용함 ▶ /bananaShop<br>
<c:url var="empDetail" value="/emp/detail.do">
<c:param name="empid" value="100"></c:param>
</c:url>
<a href="${empDetail}">100번 직원 상세보기</a>
<hr>
7. 이미지 출력하기
<c:forEach begin="1" end="10" var="i">
	<img src="${path}/images/img${i}.jpg"/>
</c:forEach>
</body>
</html>