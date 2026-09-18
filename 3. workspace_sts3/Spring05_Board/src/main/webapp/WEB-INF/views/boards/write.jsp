<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>

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
	min-height: 625px;
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
	min-height: 80px;
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
	padding: 20px 40px;
}

#box2 label {
	display: block;
	margin-bottom: 7px;
	font-size: 14px;
	font-weight: bold;
	color: #444;
}

#box2 input, #box2 textarea {
	width: 100%;
	padding: 10px 12px;
	margin-bottom: 20px;
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
	margin-bottom: 0;
}

#box2 input:focus, #box2 textarea:focus {
	border-color: #888;
}

#box3 {
	padding: 0 40px 20px;
	display: flex;
	justify-content: space-between;
	align-items: center;
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

#box4 {
	padding: 0 40px 20px;
}

#fileLimit {
	font-size: 13px;
	color: #777;
	margin-bottom: 10px;
}

#box4 input[type="file"]::file-selector-button {
	height: 32px;
	margin-right: 10px;
	padding: 0 14px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: white;
	color: #333;
	font-size: 13px;
	cursor: pointer;
}

#box4 input[type="file"]::file-selector-button:hover {
	background-color: #f1f1f1;
}

#box5 {
	padding: 0 40px 10px;
	display: flex;
	justify-content: flex-end;
}

#fileaddbtn {
	width: 100px;
	height: 32px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: white;
	color: #555;
	font-size: 13px;
	cursor: pointer;
}

#fileaddbtn:hover {
	background-color: #f1f1f1;
}

.file-row {
	display: flex;
	align-items: center;
	margin-bottom: 10px;
}

.file-row input[type="file"] {
	flex: 1;
	min-width: 0;
	margin: 0;
	font-size: 14px;
	color: #555;
}

.delete-file {
	flex-shrink: 0;
	width: 60px;
	height: 32px;
	margin-left: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: white;
	color: #555;
	font-size: 13px;
	cursor: pointer;
}

.delete-file:hover {
	background-color: #f1f1f1;
}
</style>
</head>

<body>

	<form action="/boards/complete" method="post"
		enctype="multipart/form-data" id="writeForm">

		<div class="container">

			<div class="box" id="box1">
				<h2>게시글 작성</h2>
			</div>

			<div class="box" id="box2">

				<label>작성자</label> 
				<input type="text" name="writer" value="${loginId}" readonly> 
				<label>제목</label> 
				<input type="text" name="title" placeholder="제목을 입력하세요.(최대 300바이트)">

				<label>내용</label>
				<textarea name="contents" placeholder="내용을 입력하세요.(최대 4000바이트)"></textarea>

			</div>

			<div class="box" id="box5">
				<button type="button" id="fileaddbtn">파일추가</button>
			</div>

			<div class="box" id="box4">

				<div id="fileLimit">최대 3개까지 첨부할 수 있습니다.</div>

				<div class="file-row">
					<input type="file" name="files">
				</div>

			</div>

			<div class="box" id="box3">
				<button type="button" id="cancel">취소</button>

				<input type="hidden" name="cpage" value="1">

				<button type="submit">작성완료</button>
			</div>

		</div>

	</form>

	<script>
		document.getElementById("writeForm").onsubmit = function() {

			let title = document.querySelector("input[name='title']").value
					.trim();
			let contents = document.querySelector("textarea[name='contents']").value
					.trim();

			if (title == "") {
				alert("제목을 입력해주세요.");
				return false;
			}

			if (contents == "") {
				alert("내용을 입력해주세요.");
				return false;
			}

			return true;
		};

		let fileCount = 1;

		document.getElementById("fileaddbtn").onclick = function() {

			if (fileCount >= 3) {
				alert("파일은 최대 3개까지 첨부할 수 있습니다.");
				return;
			}

			let row = document.createElement("div");
			row.className = "file-row";

			let input = document.createElement("input");
			input.type = "file";
			input.name = "files";

			let deleteBtn = document.createElement("button");
			deleteBtn.type = "button";
			deleteBtn.className = "delete-file";
			deleteBtn.innerText = "삭제";

			deleteBtn.onclick = function() {
				row.remove();
				fileCount--;
			};

			row.appendChild(input);
			row.appendChild(deleteBtn);

			document.getElementById("box4").appendChild(row);

			fileCount++;
		};

		document.getElementById("cancel").onclick = function() {
			location.href = "/boards/board?cpage=1";
		};
	</script>

</body>
</html>
