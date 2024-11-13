<%@page import="com.firstzone.emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.firstzone.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gaegu&family=Jua&display=swap" rel="stylesheet">
<style>
	table, th, td {
			 		border: 1px solid black;
			 		border-collapse: collapse;
	}
	th, td { padding: 5px; }
	th { background-color: orange; }
	/* tag 이름 사이의 공백은 자손을 의미 */
	/* tbody tr:nth-child(2n) { 
		nth-child(2n) → 짝수번째 
		background-color: lightgray;
	}
	tbody tr:nth-child(2n+1) { 
		nth-child(2n+1) → 홀수번째 
		background-color: lightblue;
	} */
	tbody tr:nth-child(even) {
		background-color: lightgray;
	}
	/* email 칼럼에 대해 글씨색 변경 */
	tbody td:nth-of-type(5) {
		color: blue;
	}
	/* first_name이 'S'로 시작하는 직원들 선택 style 적용 */
	tbody td:nth-child(2)[data-fname ^= 'S'] {
		color: purple;
	}
	tbody td:nth-child(3)[data-lname $= 'n'] {
		color: purple;
	}
	tbody td:nth-child(7)[data-job='IT_PROG'] {
		color: yellow;
	}
	h1, caption {
		font-family: "Gaegu", sans-serif;
		font-weight: 400;
		font-style: normal;
		font-size: 2em;
	}
	span {
		color: red;
	}
	a.new {
		display: block;
		padding: 10px;
	}
	.red {
		color:red;
	}
	.it_prog {
		background-color: blue;
	}
</style>
<script>
window.onload=function(){
	var obj = document.querySelector("#btn_search");
	var obj2 = document.querySelector("#btn_search_job");
	
	obj.onclick = f_salary; // 이벤트 속성에 이벤트 핸들러 연결
	obj2.onclick = f_job;
};

function f_salary(){
	var sal = parseInt(document.querySelector("#input_sal").value);
	var tds = document.querySelectorAll("td:nth-child(9)");
	
	for(let i=0;i<tds.length;i++){
		var sal2 = parseInt(tds[i].innerText);
		if(sal <= sal2){
			tds[i].setAttribute("class","red");
		} else {
			tds[i].removeAttribute("class");
		}
	}
}

function f_job(){
	var job = document.querySelector("#input_job").value;
	var tds = document.querySelectorAll("td:nth-child(7)");
	
	for(let i=0;i<tds.length;i++){
		var job2 = tds[i].innerText;
		if(job == job2){
			tds[i].setAttribute("class","it_prog");
		} else {
			tds[i].removeAttribute("class");
		}
	}
}
</script>
</head>
<body>
	<div id="container">
	<header>
		<h1>다음의 목록은 <span>직원정보</span>입니다.</h1>
	</header>
	<main>
		<section>
		<div>
		<a class="new" href="empInsert.jsp">신규직원등록</a>
		<a class="new" href="../dept/deptInsert.jsp">신규부서등록</a>
		<button id="btn_search" class="btn btn-success">금액으로 찾기</button>
		<input type="number" id="input_sal" value="10000">
		<button id="btn_search_job" class="btn btn-success">부서로 찾기</button>
		<input type="text" id="input_job" value="IT_PROG">
		<table>
			<caption>직원목록</caption>
			<thead>
			<tr>
				<th>직원번호</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>dept</th>
				<th>email</th>
				<th>phone</th>
				<th>job_id</th>
				<th>comm</th>
				<th>salary</th>
				<th>hiredate</th>
				<th>manager</th>
			</tr>
			</thead>
			<tbody>
			<%
			EmpService eService = new EmpService();
			List<EmpDTO> emplist = eService.selectAllService();
			for(EmpDTO emp:emplist){ %>
				<tr>
					<td>
						<a href="empDetail.jsp?empid=<%=emp.getEmployee_id() %>">
						<%=emp.getEmployee_id() %></a>
					</td>
					<td data-fname="<%=emp.getFirst_name() %>"><%=emp.getFirst_name() %></td>
					<td data-lname="<%=emp.getLast_name() %>"><%=emp.getLast_name() %></td>
					<td><%=emp.getDepartment_id() %></td>
					<td><%=emp.getEmail() %></td>
					<td><%=emp.getPhone_number() %></td>
					<td data-job="<%=emp.getJob_id() %>"><%=emp.getJob_id() %></td>
					<td><%=emp.getCommission_pct() %></td>
					<td><%=emp.getSalary() %></td>
					<td><%=emp.getHire_date() %></td>
					<td><%=emp.getManager_id() %></td>
				</tr>
			<%}
			%>
		</tbody>
		</table>
		</div>
		</section>
	</main>
	</div>
</body>
</html>