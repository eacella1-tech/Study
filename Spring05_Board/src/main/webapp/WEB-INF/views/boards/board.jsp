<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
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
    margin: 60px auto;
    width: 700px;
    min-height: 400px;
    background-color: white;
    border: 1px solid #ddd;
    border-radius: 10px;
    padding: 30px;
}

h2 {
	margin: 0 0 30px 0;
	color: #333;
}

table {
	width: 100%;
	border-collapse: collapse;
	text-align: center;
	font-size: 14px;
	border-top: 2px solid #333;
}

table td {
	padding: 12px 8px;
	border-bottom: 1px solid #ddd;
}

table tr:first-child {
	background-color: #f7f7f7;
	font-weight: bold;
	color: #444;
}

table td:nth-child(1) {
	width: 10%;
}

table td:nth-child(2) {
	width: 50%;
}

table td:nth-child(3) {
	width: 15%;
}

table td:nth-child(4) {
	width: 15%;
}

table td:nth-child(5) {
	width: 10%;
}

.empty {
	height: 150px;
	color: #999;
	vertical-align: middle;
}

.btn {
    margin-top: 20px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

button {
	padding: 9px 18px;
	border: 1px solid #ccc;
	border-radius: 6px;
	background-color: white;
	color: #444;
	cursor: pointer;
	font-size: 14px;
}

button:hover {
	background-color: #f1f1f1;
}

.btn button:last-child {
	background-color: #333;
	color: white;
	border-color: #333;
}

.btn button:last-child:hover {
	background-color: #555;
}
a {
    color: #333;
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}
</style>
</head>

<body>

	<div class="container">

		<h2 align="center">게시판</h2>

		<table align="center">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
			<c:choose>
				<c:when test="${list ==null}">
					<tr> 
						<td colspan="5" class="empty"> 작성된 내용이 없습니다. </td> 
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="dto" items="${list}">
						<tr>
							<td>${dto.seq}</td>
							<td><a href="/boards/detail?seq=${dto.seq}">${dto.title}</td>
							<td>${dto.writer}</td>
							<td><fmt:formatDate value="${dto.write_date}" pattern="yyyy-MM-dd"/></td>
							<td>${dto.view_count}</td>
						</tr>
					</c:forEach>
				</c:otherwise>	
				</c:choose>
		</table>
					123456789
		<div class="btn">
			<button id="home">홈으로</button>
			<form action="/boards/write">
				<button>글쓰기</button>
			</form>
		</div>

	</div>
	<script>
		document.getElementById("home").onclick = function () {
			location.href = "/";
		}
	</script>
</body>
</html>