<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<option value="" selected disabled>일정선택</option>
<c:forEach items="${datelist}" var="date">
	<option value="${date}">${date}</option>
</c:forEach>