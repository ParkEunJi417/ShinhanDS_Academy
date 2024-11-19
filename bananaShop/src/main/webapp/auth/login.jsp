<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${param.message}</p>
<h1>Sign In</h1>
 <%-- HTML, JSP : http://localhost:9090
	상대경로 : login.do 
	절대경로 : http://localhost:9090/bananaShop/auto/login.do
	${pageContext.request.servletContext.contextPath}
 --%>

<c:set var="path" value="${pageContext.request.servletContext.contextPath}"></c:set>

<form action="${path}/auth/login.do" method="post" enctype="application/x-www-form-urlencoded">
  <label>사용자번호</label>
  <input type="text" name="userid" value="eunji"><br>
  <label>비밀번호</label>
  <input type="password" name="userpass" value="1234">
  <input type="submit" value="로그인">
  <hr>
  
  <h1>Parameter 연습</h1>
  <input type="radio" name= "food" value="감자탕">감자탕
  <input type="radio" name= "food" value="김밥">김밥
  <input type="radio" name= "food" value="피자">피자
  <div>
  	<input type="checkbox" name="food2" value="메뉴1">메뉴1
  	<input type="checkbox" name="food2" value="메뉴2">메뉴2
  	<input type="checkbox" name="food2" value="메뉴3">메뉴3
  	<input type="checkbox" name="food2" value="메뉴4">메뉴4
  </div>
</form>
</body>
</html>