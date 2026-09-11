<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	background-color: #f5f6f8;
	font-family: Arial, sans-serif;
	color: #333;
}

.container {
	width: 700px;
	height: 600px;
	margin: 50px auto;
	background-color: white;
	border: 1px solid #ddd;
	border-radius: 8px;
	overflow: hidden;
}

.box {
	width: 100%;
}

#box1 {
	height: 20%;
	padding: 30px 47px;
	border-bottom: 1px solid #eee;
}

#box1 h2 {
	margin: 0 0 15px 0;
	font-size: 22px;
	color: #222;
}

.info {
	display: flex;
	align-items: center;
	gap: 15px;
}

.info p {
	margin: 0;
	font-size: 14px;
	color: #777;
}

#box2 {
	height: 65%;
	padding: 30px 47px;
	border-bottom: 1px solid #eee;
	white-space: pre-wrap;
	overflow-wrap: anywhere;
	line-height: 1.7;
	font-size: 15px;
	color: #444;
	overflow-y: auto;
}

#box3 {
	height: 15%;
	padding: 25px 47px;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

#box3 button {
	padding: 10px 18px;
	border: none;
	border-radius: 5px;
	color: white;
	font-size: 14px;
	cursor: pointer;
}

#backlist {
	background-color: #777;
}

#backlist:hover {
	background-color: #333;
}

.owner-buttons {
	display: flex;
	gap: 8px;
}

.edit-btn {
	background-color: #555;
}

.edit-btn:hover {
	background-color: #333;
}

.delete-btn {
	background-color: #555;
}

.delete-btn:hover {
	background-color: #333;
}
.owner-buttons {
	display: flex;
	align-items: center;
	gap: 8px;
	margin-left: auto;
}

.owner-buttons form {
	margin: 0;
}

#editbtn,
#update,
#cancel,
.delete-btn {
	padding: 10px 18px;
	border: none;
	border-radius: 5px;
	font-size: 14px;
	color: white;
	cursor: pointer;
	transition: background-color 0.2s;
}

#editbtn {
	background-color: #555;
}

#editbtn:hover {
	background-color: #333;
}

#update {
	background-color: #4f7cac;
}

#update:hover {
	background-color: #3d6388;
}

#cancel {
	background-color: #999;
}

#cancel:hover {
	background-color: #777;
}

.delete-btn {
	background-color: #b85c5c;
}

.delete-btn:hover {
	background-color: #963f3f;
}
</style>

</head>

<body>

	<div class="container">
		<div class="box" id="box1">
			<h2>${dto.title}</h2>
			<div class="info">
				<p>번호: ${dto.seq}</p>
				<p>작성자: ${dto.writer}</p>
				<p>
					작성일:
					<fmt:formatDate value="${dto.write_date}"
						pattern="yyyy-MM-dd HH:mm" />
				</p>
				<p>조회수: ${dto.view_count}</p>
			</div>
		</div>
		<div class="box" id="box2">${dto.contents}</div>

		<div class="box" id="box3">
			<button id="backlist">목록으로</button>
			<c:if test="${loginId == dto.writer}">
			
				<div class="owner-buttons">
						<input type="hidden" name="seq" value="${dto.seq}">
					<form action="/boards/edit" method="get">
						<input type="hidden" name="seq" value="${dto.seq}">
						<button type="submit" class="edit-btn">수정</button>
					</form>
					<form action="/boards/delete" method="post"
						onsubmit="return confirm('게시글을 삭제하시겠습니까?');">
						<input type="hidden" name="seq" value="${dto.seq}">
						<button class="delete-btn" id="deletebtn">삭제</button>
					</form>
				
				</div>
			</c:if>

		</div>

	</div>

	<script>
		document.getElementById("backlist").onclick = function() {
			location.href = "/boards/board";
		}
	</script>

</body>

</html>