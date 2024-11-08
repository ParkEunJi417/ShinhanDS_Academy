<%@page import="com.firstzone.emp.JobDTO"%>
<%@page import="com.firstzone.emp.EmpDTO"%>
<%@page import="com.firstzone.emp.EmpService"%>
<%@page import="com.firstzone.dept.DeptDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.firstzone.dept.DeptService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
DeptService dService = new DeptService();
List<DeptDTO> deptlist = dService.selectAllService();

EmpService eService = new EmpService();
List<EmpDTO> emplist = eService.selectAllService();

List<JobDTO> joblist = eService.selectAllJobService();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
  label {
      background-color: teal;
      color: white;
      text-align:center;
      padding: 5px;
      margin-bottom:5px;
      display:inline-block;
	  width: 100px; /* width속성은 inline에서 사용불가, block요소에서만 가능*/
  }
  #container{
     width: 70%;
     border: 1px dotted gray;
     margin: 0 auto;
  }
  input, select {
     width: 200px;
     box-sizing: border-box;
     padding: 5px;
      margin-bottom:5px;
  }
  
  /*
  .required {
     border: 3px dotted red;
  }*/
  
  input[class="required"], select[class="required"]{
   border: 3px dotted blue;
  }
  input[type="submit"]{
     background-color: orange;
  }
  
  
</style>
<script>
//고전 이벤트 모델 → 객체.이벤트 속성 = 이벤트 핸들러
  window.onload = function(){
	
	  // onsubmit는 default event, 이미 이벤트 핸들러가 만들어져있음
	  // submit 버튼을 누르면 form의 input들이 서버에 전송됨
	  // 개발자가 이벤트 핸들러를 넣으면 먼저 수행하고 default 이벤트 핸들러도 수행됨
	  document.querySelector("#myfrm").onsubmit = function(){
		  var empid = document.querySelector('input[name="employee_id"]').value;
		  
		  if(empid == null || empid.trim() == ""){
			  alert('직원번호는 필수컬럼입니다.');
			  return false;
		  }
		  
	  };
  };
</script>
</head>
<body>
<!--  JSP(Java Server Page) :
		동적HTML 생성함
		HTML + JAVA 가능
 -->
<div id="container">
<a href="empAll.jsp">직원조회</a>
<h1>직원등록</h1>
<form id="myfrm" action="empRegister.jsp" method="post">
	<label>직원번호:</label><input class="required" type="number" name="employee_id"><br>
	<label>부서번호:</label>
	
	<select name="department_id">
		<%
		for(DeptDTO dept:deptlist){
		%>
			<option value="<%=dept.getDepartment_id() %>">
				<%=dept.getDepartment_name() %>
			</option>
		<%} %>
	</select><br>
	<label>상사번호:</label>
	<select name="manager_id">
		<%
		for(EmpDTO emp:emplist){
		%>
			<option value="<%=emp.getEmployee_id() %>">
			 <%=emp.getFirst_name() %> <%=emp.getLast_name() %>
			</option>
		<%} %>
	</select><br>
	<label>급여:</label><input type="number" name="salary"><br>
	<label>커미션:</label><input type="text" name="commission_pct"><br>
	<label>이메일:</label><input class="required" type="text" name="email"><br>
	<label>fname:</label><input type="text" name="first_name"><br>
	<label>lname:</label><input class="required" type="text" name="last_name"><br>
	<label>job:</label>
	<select class="required" name="job_id">
		<%
		for(JobDTO job:joblist){
		%>
			<option value="<%=job.getJob_id() %>">
			 <%=job.getJob_title() %>
			</option>
		<%} %>
	</select><br>
	<label>phone:</label><input type="text" name="phone_number"><br>
	<label>입사일:</label><input class="required" type="date" name="hire_date"><br>
	<input type="submit" value="직원저장" id="save">
</form>
</div>
</body>
</html>