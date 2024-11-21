<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL(Expression Test)연습</h1>
<pre>
1.산술연산자 ▶ ${1+2}
2.비교연산자 ▶ ${10>20}
<%-- 3.문자+숫자(불가) ▶ ${"문자"}10 --%>
4.null(무시) ▶ ${null+10}
4.null(무시) ▶ ${null+"10"}
5.empty ▶ ${empty "hello"}
5.empty ▶ ${empty 10}
5.empty ▶ ${empty null}
<jsp:useBean id="member" class="com.firstzone.member.MemberDTO"></jsp:useBean>
<jsp:setProperty property="member_id" name="member" value="zz"/>
<jsp:useBean id="member2" class="java.util.ArrayList"></jsp:useBean>
5.empty ▶ ${empty member}
5.값확인 ▶ ${member.member_id}

5.empty ▶ ${empty member2}
<%
// jsp 내장객체를 이용해서 값을 저장
pageContext.setAttribute("score", 100);
request.setAttribute("score", 200);
session.setAttribute("score", 300);
application.setAttribute("score", 400);
%>
6.pageContext ▶ ${score}
6.request ▶ ${request.score}
${session.score}
6.application ▶ ${application.score}
<!-- ?myname=aaa&myname2=bbb -->
7.param읽기 ▶ ${param.myname}
7.param읽기 ▶ ${param.myname2}
</pre>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$("h1").css("background-color","skyblue");
var contextPath = '${pageContext.request.servletContext.contextPath}';
// var contextPath = /bananaShop 으로 오기 때문에 양쪽에 코테이션 필요
var str = `현재 어플리케이션의 path는 ▶ \${contextPath}`; //\$는 톰캣이 해석하지 않고 Browser가 함
console.log(str);
</script>
</body>
</html>