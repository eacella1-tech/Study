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

#editbtn, #update, #cancel, .delete-btn {
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

.container1 {
	width: 700px;
	min-height: 250px;
	margin: 30px auto 50px;
	padding: 25px 24px;
	background-color: white;
	border: 1px solid #ddd;
	border-radius: 8px;
}

.container1>h2 {
	margin: 0 0 20px 5px;
	font-size: 18px;
	color: #333;
}

.container1>.comment {
	width: 100%;
	height: auto;
	margin: 0;
	padding: 15px;
	background-color: #fafafa;
	border: 1px solid #ddd;
	border-radius: 7px;
}

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

#contentsbox:focus {
	outline: none;
	border-color: #999;
}

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

.reply-list {
	width: 100%;
	margin-top: 20px;
	display: flex;
	flex-direction: column;
	gap: 30px;
}

.reply {
	width: 100%;
	padding: 16px 18px;
	background-color: #fafafa;
	border: 1px solid #e1e1e1;
	border-radius: 7px;
}

.reply-info {
    display: flex;
    align-items: center;
    gap: 8px;
    margin-bottom: 10px;
}

.reply-infobtn {
    display: flex;
    gap: 10px;
    margin-left: auto;
}

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

.reply-info span:first-child {
	font-size: 14px;
	font-weight: bold;
	color: #444;
}

.reply-info span:nth-child(2) {
	font-size: 12px;
	color: #aaa;
}

.reply-info span:last-child::before {
	content: "·";
	margin-right: 8px;
	color: #bbb;
}

.reply-contents {
	font-size: 14px;
	color: #555;
	line-height: 1.5;
	text-align: left;
	margin-top: 15px;
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
			<input type="hidden" name="cpage" value="1">
			<c:if test="${loginId == dto.writer}">

				<div class="owner-buttons">
					<input type="hidden" name="seq" value="${dto.seq}"> 
					<input type="hidden" name="cpage" value="1">
					<form action="/boards/edit" method="get">
						<input type="hidden" name="seq" value="${dto.seq}">
						<button type="submit" class="edit-btn">수정</button>
					</form>
					<form action="/boards/delete" method="post"
						onsubmit="return confirm('게시글을 삭제하시겠습니까?');">
						<input type="hidden" name="seq" value="${dto.seq}"> 
						<input type="hidden" name="cpage" value="1">
						<button class="delete-btn" id="deletebtn">삭제</button>
					</form>
				</div>
			</c:if>
		</div>

	</div>
	<div class="container1">

    <div class="comment-write">
        <h2>댓글 작성</h2>

        <form action="/replys/comment" method="post">
            <input type="hidden" name="seq" value="${dto.seq}">

            <textarea name="contents" id="contentsbox" placeholder="댓글을 입력하세요..."></textarea>

            <div class="comment-info">
                <span>작성자 : ${loginId}</span>
                <button type="submit">댓글 등록</button>
            </div>
        </form>
    </div>

    <div class="comment-list">
        <h2>댓글 ${replyList.size()}</h2>

        <div class="reply-list">
            <c:forEach var="reply" items="${replyList}">
                <div class="reply">
                    <div class="reply-info">
                        <span>${reply.writer}</span>
                        <span>
                            <fmt:formatDate value="${reply.write_date}" pattern="yyyy-MM-dd HH:mm"/>
                        </span>
                        
                        <div class="reply-infobtn">
                        	<c:if test="${loginId == reply.writer}">
                            	<button>수정</button>
								<form action="/replys/delete" method="post"
									onsubmit="return confirm('댓글을 삭제하시겠습니까?');">
									<input type="hidden" name="seq" value="${reply.seq}"> 
									<input type="hidden" name="parent_seq" value="${reply.parent_seq}">
									<button type="submit">삭제</button>
								</form>
							</c:if>
						</div>
                    </div>

                    <div class="reply-contents">
                        ${reply.contents}
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

</div>

	<script>
		document.getElementById("backlist").onclick = function() {
			history.back();
		}
	</script>

</body>

</html>