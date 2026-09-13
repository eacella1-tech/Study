<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>학생 성적 목록</title>

<style>
* {
	box-sizing: border-box;
}

.container {
	width: 700px;
	margin: auto;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 8px;
	text-align: center;
}

.search {
	text-align: center;
	margin-bottom: 20px;
}

/* 학생 이름 검색창 */
.search input {
	width: 120px;
	height: 30px;
	padding: 3px 5px;
}

.search button {
	height: 30px;
	margin: 0 2px;
}

.box {
	width: 350px;
	margin: 30px auto;
}

.box table {
	width: 100%;
}

.box input {
	width: 100%;
	height: 30px;
}

button {
	margin: 0 3px;
}
</style>

</head>

<body>

	<h1 align="center">학생 성적 목록</h1>

	<hr>

	<div class="container">
		<div class="search">
			<form action="/students/search">
				<input type="text" name="param" placeholder="학생 이름">
				<button>검색</button>
				<button type="button" onclick="location.href='/students/list'">전체보기</button>
			</form>
		</div>
		<table border="1">
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
			</tr>
			<c:forEach var="i" items="${list}">
				<tr>
					<td>${i.id}</td>
					<td>${i.name}</td>
					<td>${i.kor}</td>
					<td>${i.eng}</td>
					<td>${i.math}</td>
					<td>${i.kor + i.eng + i.math}</td>
					<td><fmt:formatNumber value="${(i.kor + i.eng + i.math) / 3}" pattern="0.0" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<hr>
	<div class="box">
		<form action="/students/update">
			<table border="1">
				<tr>
					<th colspan="2">학생 정보 수정</th>
				</tr>
				<tr>
					<td>학번</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>국어</td>
					<td><input type="text" name="kor"></td>
				</tr>
				<tr>
					<td>영어</td>
					<td><input type="text" name="eng"></td>
				</tr>
				<tr>
					<td>수학</td>
					<td><input type="text" name="math"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button>수정하기</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<hr>
	<div class="box">
		<form action="/students/delete">
			<table border="1">
				<tr>
					<th colspan="2">학생 정보 삭제</th>
				</tr>
				<tr>
					<td>삭제할 학번</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button>삭제하기</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<hr>
	<div align="center">
		<button type="button" onclick="location.href='/'">메인 홈</button>
	</div>
</body>
</html>