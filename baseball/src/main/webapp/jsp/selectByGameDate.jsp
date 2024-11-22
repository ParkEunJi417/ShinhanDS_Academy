<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<option value="" selected disabled>경기선택</option>
<c:forEach items="${gamelist}" var="game">
	<option value="${game.game_no}">${game}</option>
</c:forEach>