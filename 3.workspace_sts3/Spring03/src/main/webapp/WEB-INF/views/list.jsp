<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie List</title>
<style>
	button {
		cursor : pointer;
	}
</style>
</head>
<body>

	<!-- EL ( Expression Language) / JSTL ( JSP Standard Tag Library )-->
	
	<table border="1" align="center">
		<tr>
			<th colspan="3">Movie</th>
		</tr>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Genre</th>
		</tr>
		<c:forEach var="i" items="${list}">
			<tr>
				<td>${i.id}</td>
				<td>${i.title}</td>
				<td>${i.genre}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3" align="center">
				<form action="/movies/update">
					<input type="text" name="id" placeholder="수정 할 대상 영화 ID"><br> 
					<input type="text" name="title" placeholder="제목"><br> 
					<input type="text" name="genre" placeholder="장르">
					<button>수정</button>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<form action="/movies/delete">
					<input type="text" name="id" placeholder="삭제할 영화의 ID를 입력">
					<button>삭제</button>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<button type="button" id="home">Home</button>
			</td>
		</tr>
	</table>
	<script>
		document.getElementById("home").onclick = function() {
			location.href = "/"; // 자바스크립트로 페이지 이동하기
		}
	</script>
</body>
</html>