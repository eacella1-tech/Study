<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복검사</title>

<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	background-color: #f5f6f8;
	font-family: Arial, sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	width: 300px;
	padding: 25px 20px;
	background-color: white;
	text-align: center;
}

h3 {
	margin: 0 0 20px;
	font-size: 18px;
	color: #333;
}

.id {
	margin-bottom: 15px;
	font-size: 14px;
	color: #555;
}

.message {
	margin-bottom: 20px;
	font-size: 13px;
}

.available {
	color: #2e7d32;
}

.unavailable {
	color: #d32f2f;
}

.question {
	margin-bottom: 20px;
	font-size: 13px;
	color: #444;
}

button {
	width: 100px;
	height: 35px;
	border: none;
	border-radius: 5px;
	font-size: 13px;
	cursor: pointer;
}

.confirm {
	background-color: #333;
	color: white;
}

.confirm:hover {
	background-color: #222;
}

.cancel {
	background-color: #eee;
	color: #444;
}

.cancel:hover {
	background-color: #ddd;
}
</style>

</head>

<body>

	<div class="container">
		<h3>아이디 중복검사</h3>
		<div class="id">
			아이디 : <strong>${id}</strong>
		</div>

		<c:choose>
			<c:when test="${result}">
				<div class="message unavailable">이미 사용 중인 ID입니다.</div>
				<button type="button" id="ok" class="cancel">확인</button>

				<script>
					document.getElementById("ok").onclick = function() {
						window.opener.document.getElementById("id").setAttribute("check", false);
						window.opener.document.getElementById("id").value = "";
						window.close();
					}
				</script>
			</c:when>
			<c:otherwise>
				<div class="message available">사용 가능한 ID입니다.</div>
				<div class="question">이 ID를 사용하시겠습니까?</div>
				<button type="button" id="use" class="confirm">사용</button>
				<button type="button" id="cancel" class="cancel">취소</button>

				<script>
					document.getElementById("use").onclick = function() {
						window.opener.document.getElementById("id").setAttribute("check", true);
						window.close();
					}
					document.getElementById("cancel").onclick = function() {
						window.opener.document.getElementById("id").setAttribute("check", false);
						window.opener.document.getElementById("id").value = "";
						window.close();
					}
				</script>
			</c:otherwise>
		</c:choose>
	</div>

</body>

</html>