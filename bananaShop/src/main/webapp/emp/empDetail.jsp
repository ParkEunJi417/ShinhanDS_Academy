<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../jsp/header2.jsp"%>
  <title>직원수정</title>
  <meta charset="utf-8">
  <style>
  [required] { border: 2px solid blue; }
  h2 { background: skyblue; }
  </style>
</head>
<body>
<div class="container mt-3">
  <%@ include file="../jsp/header.jsp"%>
  <h2>직원정보 수정</h2>  
  <form action="detail.do" method="post">
    <div class="input-group mb-3">
      <span class="input-group-text">아이디</span>
      <input disabled type="number" required="required" class="form-control" name="employee_id" value="${empInfo.employee_id}">
    </div>    
    <div class="input-group mb-3">
      <span class="input-group-text">first_name</span>
      <input type="text" class="form-control" name="first_name" value="${empInfo.first_name}">
    </div>    
    <div class="input-group mb-3">
      <span class="input-group-text">last_name</span>
      <input type="text" required="required" class="form-control" name="last_name" value="${empInfo.last_name}">
    </div>    
    <div class="input-group mb-3">
      <span class="input-group-text">이메일</span>
      <input type="text" required="required" class="form-control" name="email" value="${empInfo.email}">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">핸드폰</span>
      <input type="tel" class="form-control" name="phone_number" value="${empInfo.phone_number}">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">입사일</span>
      <input type="date" required="required" class="form-control" name="hire_date" value="${empInfo.hire_date}">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">job_id</span>
      <select required="required" class="form-control" name="job_id">
      	<c:forEach items="${joblist}" var="job">
      		<option ${job.job_id==empInfo.job_id?'selected':''} value="${job.job_id}">${job.job_id}/${job.job_title}</option>
      	</c:forEach>
      </select>     
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">급여</span>
      <input type="number" class="form-control" name="salary" value="${empInfo.salary}">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">commission_pct(1미만, 소수점 2자리까지)</span>
      <input type="number" pattern="[0]\.[0-9]{1,2}" class="form-control" name="commission_pct" value="${empInfo.commission_pct}">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">매니저 사번</span>
      <select class="form-control" name="manager_id">
        <option value="-1">매니저없음</option>
      	<c:forEach items="${managerlist}" var="emp">
      		<option ${emp.employee_id==empInfo.manager_id?'selected':''} value="${emp.employee_id}">
      		${emp.first_name}/${emp.last_name}(${emp.employee_id})</option>
      	</c:forEach>
      </select>  
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">부서</span>
      <select class="form-control" name="department_id">
        <option value="-1">부서없음</option>
      	<c:forEach items="${deptlist}" var="dept">
      		<option ${dept.department_id==empInfo.department_id?'selected':''} value="${dept.department_id}">
      		${dept.department_name}(${dept.department_id})</option>
      	</c:forEach>
      </select> 
    </div>   
    <button type="submit" class="btn btn-primary">직원정보수정</button>
  </form>
</div>

</body>
</html>