<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>학생 정보 등록</title>

<style>
* {
	box-sizing: border-box;
}

.container {
	width: 350px;
	margin: auto;
	border: 1px solid black;
}

.row {
	display: flex;
	height: 50px;
	border-bottom: 1px solid black;
}

.label {
	width: 35%;
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: #f8f8f8;
}

.input {
	width: 65%;
	display: flex;
	align-items: center;
	padding: 5px;
}

.input input {
	width: 100%;
	height: 30px;
}

.buttons {
	height: 50px;
	display: flex;
	justify-content: center;
	align-items: center;
}

button {
	margin: 3px;
}
</style>

</head>

<body>

	<h2 align="center">학생 정보 등록</h2>
	<hr>

	<form action="/students/add">
		<div class="container">
			<div class="row">
				<div class="label">이름</div>
				<div class="input">
					<input type="text" name="name" placeholder="예: 홍길동">
				</div>
			</div>
			<div class="row">
				<div class="label">국어 점수</div>
				<div class="input">
					<input type="text" name="kor" placeholder="0~100">
				</div>
			</div>
			<div class="row">
				<div class="label">영어 점수</div>
				<div class="input">
					<input type="text" name="eng" placeholder="0~100">
				</div>
			</div>
			<div class="row">
				<div class="label">수학 점수</div>
				<div class="input">
					<input type="text" name="math" placeholder="0~100">
				</div>
			</div>
			<div class="buttons">
				<button type="submit">등록하기</button>
				<button type="button" id="home">메인으로</button>
			</div>
		</div>
	</form>

	<script>
		document.getElementById("home").onclick = function() {
			location.href = "/";
		}
	</script>

</body>
</html>