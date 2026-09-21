<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Files</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
	<fieldset>
		<legend>File Upload</legend>
		<form action="/files/upload" method="post" enctype="multipart/form-data">
			<input type="text" name="text" placeholder="아무 메세지"><br>
			<input type="file" name="files"><br>
			<input type="file" name="files"><br>
			<input type="file" name="files"><br>
			<button>업로드</button>
		</form>
	</fieldset>
	<fieldset>
		<legend>
			File List
		</legend>
		<div>
			<c:forEach var="i" items="${files}">
				<a href="/files/download?sysname=${i.sysname}&oriname= ${i.oriname}">${i.oriname}</a><br>
			</c:forEach>
		</div>
	</fieldset>
</body>

</html>