<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>학생 관리 시스템</title>

<style>
* {
	box-sizing: border-box;
}

.container {
	width: 500px;
	margin: 30px auto;
	display: flex;
	border: 1px solid black;
}

.box {
	width: 50%;
	height: 100px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.box+.box {
	border-left: 1px solid black;
}

button {
	padding: 8px 15px;
	cursor: pointer;
}
</style>

</head>

<body>

	<h2 align="center">학생 관리 시스템</h2>

	<hr>

	<div class="container">

		<div class="box">
			<a href="/students/addform">
				<button>신규 등록</button>
			</a>
		</div>

		<div class="box">
			<a href="/students/list">
				<button>목록 출력</button>
			</a>
		</div>

	</div>

</body>
</html>
