<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	background-color: #f5f6f8;
	font-family: Arial, sans-serif;
}

.container {
	width: 700px;
	height: 600px;
	margin: 50px auto;
	background-color: white;
	border: 1px solid #ddd;
	border-radius: 10px;
	overflow: hidden;
}

.box {
	width: 100%;
}

#box1 {
	height: 15%;
	display: flex;
	justify-content: center;
	align-items: center;
}

#box1 h2 {
	margin: 0;
	font-size: 24px;
	color: #333;
}

#box2 {
	height: 70%;
	padding: 30px 40px;
}

#box2 label {
	display: inline-block;
	margin-bottom: 7px;
	font-size: 14px;
	font-weight: bold;
	color: #444;
}

#box2 input, #box2 textarea {
	width: 100%;
	margin-bottom: 20px;
	padding: 10px 12px;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 14px;
	outline: none;
}

#box2 input {
	height: 40px;
}

#box2 textarea {
	height: 180px;
	resize: none;
}

#box2 input:focus, #box2 textarea:focus {
	border-color: #888;
}

#box3 {
	height: 15%;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 0 40px;
}

#box3 button {
	width: 100px;
	height: 40px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: white;
	font-size: 14px;
	cursor: pointer;
}

#box3 button:hover {
	background-color: #f1f1f1;
}

#box3 button:last-child {
	background-color: #333;
	color: white;
	border-color: #333;
}

#box3 button:last-child:hover {
	background-color: #555;
}
</style>
</head>

<body>
	<form action="/boards/update" method="post">
		<div class="container">
			
				<div class="box" id="box1">
					<h2>게시글 수정</h2>
				</div>
		
				<div class="box" id="box2">
					<input type="hidden" name="seq" value="${dto.seq}">
					<label>작성자</label> 
					<input type="text" name="writer" value="${loginId}" readonly> 
					<label>제목</label> 
					<input type="text" name="title" value="${dto.title}"> 
					<label>내용</label>
					<textarea name="contents" >${dto.contents}</textarea>
				</div>
				
				<div class="box" id="box3">
					<button id="cancel">취소</button>
					<button>수정완료</button>
				</div>
			
		</div>
	</form>
	<script>
	document.getElementById("cancel").onclick = function () {
		location.href = "/boards/board";
	}
	</script>
</body>


</html>