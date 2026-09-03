<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/movies/add">
		<table border="1" align="center">
			<tr>
				<th>Movie Info</th>
			</tr>
			<tr>
				<td>
				<input type="text" name="title" placeholder="input movie name">
				</td>
			</tr>
			<tr>
				<td>
				<input type="text" name="genre" placeholder="input movie genre">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button type="button" id="cancel">취소</button>
					<button>등록</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		document.getElementById("cancel").onclick = function() {
			location.href = "/"; // 자바스크립트로 페이지 이동하기
		}
	</script>
</body>
</html>