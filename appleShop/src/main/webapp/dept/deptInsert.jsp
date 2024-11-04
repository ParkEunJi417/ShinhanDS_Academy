<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  label {
  	width: 100px;
  	display:inline-block;
  	background-color: green;
  	color: white;
  	padding: 5px;
  	margin: 5px;
  }
  #container {
  	width: 30%;
  	/* border: 1px solid gray; */
  	margin: 0 auto;
  }
  #submitButton, h1 {
  	/* border: 1px dotted gray; 
  	width: 100%; */
  	text-align: center;
  	width: 70%;
  }
  input {
  	padding: 5px;
  }
</style>
</head>
<body>
<div id="container">
	<h1>부서등록</h1>
	<form action="deptRegister.jsp">
	  <label>부서번호</label>
	  <input type="number" name="department_id"><br>
	  <label>부서이름</label>
	  <input type="text" name="department_name"><br>
	  <label>location_id</label>
	  <input type="number" name="location_id" value="2000"><br>
	  <label>manager_id</label>
	  <input type="number" name="manager_id" value="100"><br>
	  <div id="submitButton">
	  	<input type="submit" value="부서입력">
	  </div>
	</form>
</div>
</body>
</html>