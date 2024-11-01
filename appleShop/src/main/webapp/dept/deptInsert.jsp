<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
  <input type="submit" value="부서입력">
</form>
</body>
</html>