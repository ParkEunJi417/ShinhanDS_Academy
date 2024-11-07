/**
 * 
 */
function f2() {
	alert("외부JS")
	var arr = [100, "문자", true, {name:"홍길동",age:20},
		function() {
			var a=100; alert(a);
		}, undefined];
	
	//var element = document.getElementById("here");	
	var element = document.querySelector("#here");	
		
	for(var i=0;i<arr.length;i++){
		if(typeof(arr[i])=="function"){
			arr[i](); // function 실행
		}
		
		element.innerHTML += "<p>" + arr[i] + "→" + typeof(arr[i]) +"</p>";
	}
}

function f3() {
	// id가 myButtons의 자식 button 찾기
	var arr = document.querySelectorAll("#myButtons button");
	var output = "<ul>";
	
	for(var i=0;i<arr.length;i++) {
		output += "<li>" + arr[i].innerHTML +"</li>"
	}

	document.querySelector("#here").innerHTML = output + "</ul>";
}