<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.servletContext.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>⚾야구 직관🥎</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>
@font-face {
	font-family: 'KBO_light';
	src: url('${path}/fonts/KBO_light.ttf') format('truetype');
}

@font-face {
	font-family: 'KBO_bold';
	src: url('${path}/fonts/KBO_bold.ttf') format('truetype');
}

@font-face {
	font-family: 'KBO_medium';
	src: url('${path}/fonts/KBO_medium.ttf') format('truetype');
}

body {
	font-family: "KBO_light", sans-serif;
	color: #002561;
}

h2 {
	font-family: "KBO_medium", sans-serif;
}
</style>