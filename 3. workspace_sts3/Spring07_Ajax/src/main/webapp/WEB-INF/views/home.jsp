<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
	<!-- 
		AJAX : Asynchronous Javascript ANd XML
				비동기 통신 기법
		
		순한 맛 : 페이지 전환 없이 request 밑 response 를 수행하는 문법
		매운 맛 : 기존 스레드와 별개로 통신을 담당하는 스레드를 처리하는 멀티쓰레딩 기법
		
		 -->
		 
		 * 클라이언트가 서버로 request를 전송하는 방법<br>
		 - anchor 태그 , form + submit , locatin.href<br>
		 - 위 request를 전송하는 방식은 모두 response를 받을 경우 <br>
		 	페이지 전환이 발생함<br>
		 	
		 * 페이지 전환 없이 request를 전송하는 방법<br>
		 - websocket, AJAX<br>
		 - 위 두가지 방식은 페이지 전환 없이 데이터 통신을 수행 함.<br>
		 
		 <fieldset>
		 	<legend>Exam01. 기본통신</legend>
		 	<button id="exam01">Event</button>
		 	<script>
		 		$("#exam01").on("click", function(){
		 			
		 			$.ajax({
		 				url:"/ajax/exam01"
		 			});
		 			
		 		})
		 	</script>
		 </fieldset>
		 
		  <fieldset>
		 	<legend>Exam02. 파라미터 전송</legend>
		 	<button id="exam02">Event</button>
		 	<script>
		 		$("#exam02").on("click", function(){
		 			
		 			$.ajax({
		 				url:"/ajax/exam02",
		 				data:{
		 					writer : "tester",
		 					message: "Hello ajax"
		 				}
		 			});
		 			
		 		})
		 	</script>
		 </fieldset>
		 
		 <fieldset>
		 	<legend>Exam03. 단순 String 응답 받아보기</legend>
		 	<button id="exam03">Event</button>
		 	<script>
		 		$("#exam03").on("click", function(){
		 			
		 			$.ajax({
		 				url:"/ajax/exam03"
		 			}).done(function (resp){
		 				console.log(resp);
		 			});
		 			
		 		})
		 	</script>
		 </fieldset>
		 
		 <fieldset>
		 	<legend>Exam04. 객체 응답 받아보기</legend>
		 	<button id="exam04">Event</button>
		 	<div id="list">
		 	</div>
		 	<script>
		 		$("#exam04").on("click", function(){
		 			
		 			$.ajax({
		 				url:"/ajax/exam04",
		 				dataType:"json"
		 			}).done(function (resp){
		 				// resp = JSON.parse(resp); // 역직렬화 함수
		 				// console.log(resp);
		 				for(let i of resp) {
		 					let contact = $("<div>");
		 					contact.html(i.id + " : " + i.name + " : " + i.contact);
		 					$("#list").append(contact);
		 				}
		 			});
		 			
		 		})
		 	</script>
		 </fieldset>
		 
		 
		 

		 
</body>
</html>