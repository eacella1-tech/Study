<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>

<!-- jQuery 사용을 위한 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<style>

/* ============================= */
/* 전체 페이지 기본 설정 */
/* ============================= */

* {
	box-sizing: border-box;
}

body {
	margin: 0;
	background-color: #f5f6f8;
	font-family: Arial, sans-serif;
	color: #333;
}


/* ============================= */
/* 게시글 전체 영역 */
/* ============================= */

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


/* ============================= */
/* 게시글 상단 - 제목, 작성자, 날짜, 조회수 */
/* ============================= */

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


/* ============================= */
/* 게시글 본문 */
/* ============================= */

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


/* ============================= */
/* 게시글 하단 - 목록 / 수정 / 삭제 버튼 */
/* ============================= */

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


/* 목록으로 버튼 */

#backlist {
	background-color: #777;
}

#backlist:hover {
	background-color: #333;
}


/* 작성자용 수정 / 삭제 버튼 영역 */

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


/* 수정 / 삭제 버튼 정렬 */

.owner-buttons {
	display: flex;
	align-items: center;
	gap: 8px;
	margin-left: auto;
}

.owner-buttons form {
	margin: 0;
}


/* 게시글 수정 / 삭제 버튼 공통 스타일 */

#editbtn, #update, #cancel, .delete-btn {
	padding: 10px 18px;
	border: none;
	border-radius: 5px;
	font-size: 14px;
	color: white;
	cursor: pointer;
	transition: background-color 0.2s;
}


/* 게시글 수정 버튼 */

#editbtn {
	background-color: #555;
}

#editbtn:hover {
	background-color: #333;
}


/* 게시글 수정완료 버튼 */

#update {
	background-color: #4f7cac;
}

#update:hover {
	background-color: #3d6388;
}


/* 게시글 수정 취소 버튼 */

#cancel {
	background-color: #999;
}

#cancel:hover {
	background-color: #777;
}


/* 게시글 삭제 버튼 */

.delete-btn {
	background-color: #b85c5c;
}

.delete-btn:hover {
	background-color: #963f3f;
}


/* ============================= */
/* 댓글 전체 영역 */
/* ============================= */

.container1 {
	width: 700px;
	min-height: 250px;
	margin: 30px auto 50px;
	padding: 25px 24px;
	background-color: white;
	border: 1px solid #ddd;
	border-radius: 8px;
}


/* 댓글 영역 제목 */

.container1>h2 {
	margin: 0 0 20px 5px;
	font-size: 18px;
	color: #333;
}


/* ============================= */
/* 댓글 작성 영역 */
/* ============================= */

.container1>.comment {
	width: 100%;
	height: auto;
	margin: 0;
	padding: 15px;
	background-color: #fafafa;
	border: 1px solid #ddd;
	border-radius: 7px;
}


/* 댓글 입력창 */

#contentsbox {
	width: 100%;
	height: 100px;
	margin: 0;
	padding: 12px;
	border: 1px solid #ddd;
	border-radius: 5px;
	resize: none;
	font-size: 14px;
	font-family: Arial, sans-serif;
	display: block;
	background-color: white;
}


/* 댓글 입력창에 커서가 들어왔을 때 */

#contentsbox:focus {
	outline: none;
	border-color: #999;
}


/* 댓글 작성자 / 등록 버튼 영역 */

.comment-info {
	width: 100%;
	margin: 12px auto 0;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.comment-info span {
	font-size: 13px;
	color: #777;
}

.comment-info button {
	padding: 9px 16px;
	border: none;
	border-radius: 5px;
	background-color: #555;
	color: white;
	font-size: 13px;
	cursor: pointer;
}

.comment-info button:hover {
	background-color: #333;
}


/* ============================= */
/* 댓글 목록 전체 영역 */
/* ============================= */

.reply-list {
	width: 100%;
	margin-top: 20px;
	display: flex;
	flex-direction: column;
	gap: 30px;
}


/* 댓글 하나하나의 박스 */

.reply {
	width: 100%;
	padding: 16px 18px;
	background-color: #fafafa;
	border: 1px solid #e1e1e1;
	border-radius: 7px;
}


/* ============================= */
/* 댓글 작성자 / 작성일 / 수정 / 삭제 영역 */
/* ============================= */

.reply-info {
	display: flex;
	align-items: center;
	gap: 8px;
	margin-bottom: 10px;
}


/* 댓글 수정 / 삭제 버튼 영역 */

.reply-infobtn {
	display: flex;
	gap: 10px;
	margin-left: auto;
}


/* 댓글 수정 / 삭제 버튼 */

.reply-infobtn button {
	padding: 0;
	border: none;
	background: none;
	color: #999;
	font-size: 12px;
	cursor: pointer;
}

.reply-infobtn button:hover {
	color: #555;
	text-decoration: underline;
}


/* 댓글 작성자 */

.reply-info span:first-child {
	font-size: 14px;
	font-weight: bold;
	color: #444;
}


/* 댓글 작성일 */

.reply-info span:nth-child(2) {
	font-size: 12px;
	color: #aaa;
}


/* 작성자와 날짜 사이의 점 */

.reply-info span:last-child::before {
	content: "·";
	margin-right: 8px;
	color: #bbb;
}


/* ============================= */
/* 댓글 내용 */
/* ============================= */

.reply-contents {
	font-size: 14px;
	color: #555;
	line-height: 1.5;
	text-align: left;
	margin-top: 15px;
}


/* ============================= */
/* 댓글 수정 영역 */
/* ============================= */

/* 처음에는 수정창을 숨김 */

.reply-edit-form {
	display: none;
	margin-top: 15px;
}


/* 댓글 수정 입력창 */

.reply-edit-contents {
	width: 100%;
	height: 80px;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 5px;
	resize: none;
	font-size: 14px;
	font-family: Arial, sans-serif;
}


/* 댓글 수정완료 / 취소 버튼 영역 */

.reply-edit-buttons {
	display: flex;
	justify-content: flex-end;
	gap: 8px;
	margin-top: 8px;
}


/* 댓글 수정 버튼 공통 */

.update-reply-btn,
.cancel-reply-btn {
	padding: 7px 12px;
	border: none;
	border-radius: 5px;
	color: white;
	font-size: 12px;
	cursor: pointer;
}


/* 댓글 수정완료 버튼 */

.update-reply-btn {
	background-color: #4f7cac;
}


/* 댓글 수정 취소 버튼 */

.cancel-reply-btn {
	background-color: #999;
}

</style>

</head>

<body>

	<!-- ================================= -->
	<!-- 게시글 상세보기 전체 영역 -->
	<!-- ================================= -->

	<div class="container">

		<!-- 게시글 제목 / 작성자 / 날짜 / 조회수 -->
		<div class="box" id="box1">

			<!-- 게시글 제목 -->
			<h2>${dto.title}</h2>

			<!-- 게시글 기본 정보 -->
			<div class="info">

				<!-- 게시글 번호 -->
				<p>번호: ${dto.seq}</p>

				<!-- 게시글 작성자 -->
				<p>작성자: ${dto.writer}</p>

				<!-- 게시글 작성일 -->
				<p>
					작성일:
					<fmt:formatDate value="${dto.write_date}"
						pattern="yyyy-MM-dd HH:mm" />
				</p>

				<!-- 게시글 조회수 -->
				<p>조회수: ${dto.view_count}</p>

			</div>
		</div>


		<!-- ================================= -->
		<!-- 게시글 본문 -->
		<!-- ================================= -->

		<div class="box" id="box2">${dto.contents}</div>


		<!-- ================================= -->
		<!-- 게시글 하단 버튼 영역 -->
		<!-- ================================= -->

		<div class="box" id="box3">

			<!-- 게시글 목록으로 이동 -->
			<button id="backlist">목록으로</button>

			<!-- 게시글 페이지 번호 -->
			<input type="hidden" name="cpage" value="1">

			<!-- 게시글 작성자에게만 수정 / 삭제 버튼 표시 -->
			<c:if test="${loginId == dto.writer}">

				<div class="owner-buttons">

					<!-- 게시글 번호 전달 -->
					<input type="hidden" name="seq" value="${dto.seq}">

					<!-- 현재 페이지 번호 전달 -->
					<input type="hidden" name="cpage" value="1">


					<!-- 게시글 수정 -->
					<form action="/boards/edit" method="get">

						<!-- 수정할 게시글 번호 전달 -->
						<input type="hidden" name="seq" value="${dto.seq}">

						<button type="submit" class="edit-btn">수정</button>

					</form>


					<!-- 게시글 삭제 -->
					<form action="/boards/delete" method="post"
						onsubmit="return confirm('게시글을 삭제하시겠습니까?');">

						<!-- 삭제할 게시글 번호 전달 -->
						<input type="hidden" name="seq" value="${dto.seq}">

						<!-- 게시판 페이지 번호 전달 -->
						<input type="hidden" name="cpage" value="1">

						<button class="delete-btn" id="deletebtn">삭제</button>

					</form>

				</div>

			</c:if>

		</div>

	</div>


	<!-- ================================= -->
	<!-- 댓글 전체 영역 -->
	<!-- ================================= -->

	<div class="container1">

		<!-- 댓글 작성 영역 -->
		<div class="comment-write">

			<!-- 댓글 작성 제목 -->
			<h2>댓글 작성</h2>


			<!-- 댓글 등록 폼 -->
			<form action="/replys/comment" method="post">

				<!-- 어느 게시글의 댓글인지 게시글 번호 전달 -->
				<input type="hidden" name="seq" value="${dto.seq}">

				<!-- 댓글 내용 입력 -->
				<textarea name="contents" id="contentsbox"
					placeholder="댓글을 입력하세요..."></textarea>


				<!-- 댓글 작성자 / 댓글 등록 버튼 -->
				<div class="comment-info">

					<!-- 현재 로그인한 사용자 -->
					<span>작성자 : ${loginId}</span>

					<!-- 댓글 등록 -->
					<button type="submit">댓글 등록</button>

				</div>

			</form>

		</div>


		<!-- ================================= -->
		<!-- 댓글 목록 -->
		<!-- ================================= -->

		<div class="comment-list">

			<!-- 댓글 개수 -->
			<h2>댓글 ${replyList.size()}</h2>


			<!-- 댓글 하나씩 출력 -->
			<div class="reply-list">

				<c:forEach var="reply" items="${replyList}">

					<!-- 댓글 하나 -->
					<div class="reply">


						<!-- 댓글 작성자 / 작성일 / 수정 / 삭제 -->
						<div class="reply-info">

							<!-- 댓글 작성자 -->
							<span>${reply.writer}</span>


							<!-- 댓글 작성일 -->
							<span>
								<fmt:formatDate value="${reply.write_date}"
									pattern="yyyy-MM-dd HH:mm" />
							</span>


							<!-- 수정 / 삭제 버튼 -->
							<div class="reply-infobtn">

								<!-- 댓글 작성자 본인에게만 수정 / 삭제 버튼 표시 -->
								<c:if test="${loginId == reply.writer}">

									<!-- 댓글 수정 버튼 -->
									<button type="button" class="edit-reply-btn">수정</button>


									<!-- 댓글 삭제 -->
									<form action="/replys/delete" method="post"
										onsubmit="return confirm('댓글을 삭제하시겠습니까?');">

										<!-- 삭제할 댓글 번호 -->
										<input type="hidden" name="seq" value="${reply.seq}">

										<!-- 부모 게시글 번호 -->
										<input type="hidden" name="parent_seq"
											value="${reply.parent_seq}">

										<button type="submit">삭제</button>

									</form>

								</c:if>

							</div>

						</div>


						<!-- ================================= -->
						<!-- 기존 댓글 내용 -->
						<!-- ================================= -->

						<div class="reply-contents">${reply.contents}</div>


						<!-- ================================= -->
						<!-- 댓글 수정 폼 -->
						<!-- 처음에는 CSS display:none으로 숨겨져 있음 -->
						<!-- ================================= -->

						<form action="/replys/update" method="post"
							class="reply-edit-form">

							<!-- 수정할 댓글 번호 -->
							<input type="hidden" name="seq" value="${reply.seq}">

							<!-- 부모 게시글 번호 -->
							<input type="hidden" name="parent_seq"
								value="${reply.parent_seq}">


							<!-- 수정할 댓글 내용 -->
							<textarea name="contents"
								class="reply-edit-contents">${reply.contents}</textarea>


							<!-- 수정완료 / 취소 버튼 -->
							<div class="reply-edit-buttons">

								<!-- 댓글 수정 요청 -->
								<button type="submit" class="update-reply-btn">
									수정완료
								</button>

								<!-- 수정 취소 -->
								<button type="button" class="cancel-reply-btn">
									취소
								</button>

							</div>

						</form>

					</div>

				</c:forEach>

			</div>

		</div>

	</div>


	<!-- ================================= -->
	<!-- JavaScript / jQuery -->
	<!-- ================================= -->

	<script>

	$(document).ready(function() {


		// =================================
		// 댓글 수정 버튼
		// =================================

		$(".edit-reply-btn").click(function() {

			// 클릭한 수정 버튼
			let clickButton = $(this);

			// 클릭한 버튼이 들어있는 댓글 전체 영역
			let replyBox = clickButton.closest(".reply");

			// 기존 댓글 내용
			let replyContents = replyBox.find(".reply-contents");

			// 댓글 수정 폼
			let editForm = replyBox.find(".reply-edit-form");

			// 수정 버튼
			let editButton = replyBox.find(".edit-reply-btn");

			// 삭제 폼
			let deleteForm = replyBox.find(".reply-infobtn form");


			// 기존 댓글 내용을 숨김
			replyContents.hide();

			// 수정 폼을 보여줌
			editForm.show();

			// 수정 / 삭제 버튼 숨김
			editButton.hide();
			deleteForm.hide();

		});


		// =================================
		// 댓글 수정 취소 버튼
		// =================================

		$(".cancel-reply-btn").click(function() {

			// 클릭한 취소 버튼
			let clickButton = $(this);

			// 클릭한 버튼이 들어있는 댓글 전체 영역
			let replyBox = clickButton.closest(".reply");

			// 기존 댓글 내용
			let replyContents = replyBox.find(".reply-contents");

			// 댓글 수정 폼
			let editForm = replyBox.find(".reply-edit-form");

			// 수정 버튼
			let editButton = replyBox.find(".edit-reply-btn");

			// 삭제 폼
			let deleteForm = replyBox.find(".reply-infobtn form");

			// 수정 입력창
			let editContents = replyBox.find(".reply-edit-contents");


			// 기존 댓글 내용을 다시 입력창에 넣음
			editContents.val(replyContents.text());


			// 기존 댓글 내용을 보여줌
			replyContents.show();

			// 수정 폼을 숨김
			editForm.hide();

			// 수정 / 삭제 버튼을 다시 보여줌
			editButton.show();
			deleteForm.show();

		});

	});


	// =================================
	// 댓글 등록 전 빈 내용 검사
	// =================================

	$("form[action='/replys/comment']").submit(function(e) {

		// 댓글 입력값 가져오기
		let contents = $("#contentsbox").val().trim();


		// 댓글 내용이 비어 있는지 확인
		if (contents == "") {

			// 입력 내용이 없으면 경고창 표시
			alert("입력된 내용이 없습니다.");

			// 폼 제출을 막음
			e.preventDefault();
		}

	});


	// =================================
	// 목록으로 버튼
	// =================================

	document.getElementById("backlist").onclick = function() {

		// 게시판 목록 페이지로 이동
		location.href = "/boards/board?cpage=1";

	}

	</script>

</body>

</html>
