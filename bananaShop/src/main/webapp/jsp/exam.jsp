<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div id="page">
  <h1 id="header">목록</h1>
  <h2>구입할 식료품</h2>
  <ul id="list">
    <li id="one" class="hot">
      <em>신선한</em>무화과
    </li>
    <li id="two" class="hot">잣</li>
    <li id="three" class="hot">꿀</li>
    <li id="four">발사믹 식초</li>
  </ul>
</div>
<script>
/* $(function(){
    var firstElement =  $('#one').html();
    //console.log(firstElement);
}); */
/* DOM 트리의 메소드를 이용해 id가 “three”인 element를 가져와 "html태그없이 텍스트" 값을 귤로 바꾸는 jQuery 코드를 작성하시오. 
( 공백없는 문장으로 작성하시오. 마지막 세미콜론은 쓰지말기 ) */
$('#three').text("귤")

/* jQuery를 이용하여 배열에 저장된 데이터를 console에 출력하시오.
(callback함수의 매개변수이름은 값은item, 순서는index를 사용하고 enter이외의 공백은 넣지않기, 문장종료시 ;는 필수) */

var arr = ["사과", "바나나", "수박", "복숭아"];

$.each(arr, function(index, item) {
  console.log("Index: " + index + ", Item: " + item);
});
</script>
</body>
</html>