<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>직원등록</title>
  <meta charset="utf-8">
  <style>
  [required] { border: 2px solid skyblue; }
  </style>
  <script>
  window.onload = function(){
	  var d =new Date().toISOString().split("T")[0];
	  document.querySelector("input[name='hire_date']").value = d;
  };
  </script>
</head>
<body>
<div class="container mt-3">
  <!-- include 디렉티브 태그는 jsp를 합쳐서 컴파일함 -->
  <%@ include file="../jsp/header.jsp" %>
  
  <h2>신규 직원 등록</h2>  
  <form action="insert.do" method="post">
    <div class="input-group mb-3">
      <span class="input-group-text">아이디</span>
      <input type="number" required="required" class="form-control" placeholder="숫자 입력" name="employee_id">
    </div>    
    <div class="input-group mb-3">
      <span class="input-group-text">first_name</span>
      <input type="text" class="form-control" placeholder="문자 입력" name="first_name">
    </div>    
    <div class="input-group mb-3">
      <span class="input-group-text">last_name</span>
      <input type="text" required="required" class="form-control" placeholder="문자 입력" name="last_name">
    </div>    
    <div class="input-group mb-3">
      <span class="input-group-text">이메일</span>
      <input type="text" required="required" class="form-control" placeholder="문자 입력" name="email">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">핸드폰</span>
      <input type="tel" class="form-control" name="phone_number">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">입사일</span>
      <input type="date" required="required" class="form-control" name="hire_date">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">job_id</span>
      <select required="required" class="form-control" name="job_id">
      	<c:forEach items="${joblist}" var="job">
      		<option ${job.job_id=='IT_PROG'?'selected':''} value="${job.job_id}">${job.job_id}/${job.job_title}</option>
      	</c:forEach>
      </select>     
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">급여</span>
      <input type="number" class="form-control" placeholder="숫자 입력" name="salary">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">commission_pct(1미만, 소수점 2자리까지)</span>
      <input type="number" pattern="[0]\.[0-9]{1,2}" class="form-control" name="commission_pct">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">매니저 사번</span>
      <select class="form-control" name="manager_id">
        <option value="-1">매니저없음</option>
      	<c:forEach items="${managerlist}" var="emp">
      		<option value="${emp.employee_id}">
      		${emp.first_name}/${emp.last_name}(${emp.employee_id})</option>
      	</c:forEach>
      </select>  
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">부서</span>
      <select class="form-control" name="department_id">
        <option value="-1">부서없음</option>
      	<c:forEach items="${deptlist}" var="dept">
      		<option value="${dept.department_id}">
      		${dept.department_name}(${dept.department_id})</option>
      	</c:forEach>
      </select> 
    </div>   
    <button type="submit" class="btn btn-primary">신규직원 등록</button>
  </form>
</div>

</body>
</html>