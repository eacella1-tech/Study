<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script
	src="//t1.kakaocdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
	width: 400px;
	margin: 60px auto;
	padding: 35px 30px;
	background-color: white;
	border: 1px solid #ddd;
	border-radius: 10px;
}

h2 {
	margin: 0 0 30px;
	text-align: center;
}

.container>div {
	border: none;
}

fieldset {
	margin: 0 0 20px;
	padding: 20px 15px;
	border: 1px solid #ddd;
	border-radius: 7px;
}

legend {
	padding: 0 8px;
	font-size: 14px;
	font-weight: bold;
	color: #333;
}

label {
	display: inline-block;
	margin-bottom: 7px;
	font-size: 13px;
	font-weight: bold;
	color: #444;
}

input {
	width: 100%;
	height: 40px;
	margin-bottom: 15px;
	padding: 0 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 13px;
}

input:focus {
	outline: none;
	border-color: #555;
}

input::placeholder {
	color: #aaa;
}

.id-wrap {
	display: flex;
	gap: 8px;
}

.id-wrap input {
	flex: 1;
	width: auto;
}

.id-wrap button {
	width: 80px;
	height: 40px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #f8f8f8;
	color: #444;
	font-size: 12px;
	cursor: pointer;
}

.id-wrap button:hover {
	background-color: #eee;
}

.footer input {
	width: 55%;
}

.footer button {
	width: 40%;
	height: 40px;
	margin-left: 3%;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #f8f8f8;
	color: #444;
	font-size: 12px;
	cursor: pointer;
}

.footer button:hover {
	background-color: #eee;
}

.footer input:nth-of-type(2), .footer input:nth-of-type(3) {
	width: 100%;
}

.btn {
	display: flex;
	gap: 10px;
	height: auto;
	margin-top: 5px;
}

.btn button {
	flex: 1;
	height: 45px;
	border: none;
	border-radius: 5px;
	font-size: 14px;
	cursor: pointer;
}

.btn button:first-child {
	background-color: #333;
	color: white;
}

.btn button:first-child:hover {
	background-color: #222;
}

.btn button:last-child {
	background-color: #eee;
	color: #444;
}

.btn button:last-child:hover {
	background-color: #ddd;
}
#idResult {
	display: block;
	margin-top: -8px;
	margin-bottom: 15px;
	font-size: 12px;
}
</style>
</head>
<body>
	<div class="container">
		<h2>회원가입</h2>
		<form action="/members/register" method="post" id="frm">
			<div class="header">
				<fieldset>
					<legend>계정 정보</legend>
					<label for="id">아이디</label><br>
					<div class="id-wrap">
						<input type="text" id="id" name="id" placeholder="아이디 입력(최대 30자)">
						<button type="button" id="checkId">중복검사</button>
					</div>
					<span id="idResult"></span> 
					<label for="password">비밀번호</label><br> 
					<input type="password" id="password" name="pw" placeholder="비밀번호 입력"><br> 
					<label for="password1">비밀번호 확인</label><br> 
					<input type="password" id="password1" placeholder="비밀번호 재입력">
				</fieldset>
			</div>

			<div class="middle">
				<fieldset>
					<legend>개인 정보</legend>
					<label for="name">이름</label><br> 
					<input type="text" id="name" name="name" placeholder="이름 입력"><br> 
					<label for="phone">연락처</label><br> 
					<input type="text" id="phone" name="phone" placeholder="'-' 제외 숫자만 입력 (최대 11자리)"><br>
					<label for="email">이메일</label><br> 
					<input type="text" id="email" name="email" placeholder="example@domain.com"><br>
				</fieldset>
			</div>

			<div class="footer">
				<fieldset>
					<legend>주소 정보</legend>
					<label for="zipcode">우편 번호</label><br> 
					<input type="text" id="zipcode" name="zipcode" readonly placeholder="우편번호 (5자리)">
					<button id="search" type="button">우편번호 찾기</button>
					<br> 
					<label for="address1">주소1</label><br> 
					<input type="text" id="address1" name="address1" readonly placeholder="기본 주소" ><br>
					<label for="address2">주소2</label><br> 
					<input type="text" id="address2" name="address2" placeholder="상세 주소"><br>
				</fieldset>
			</div>

			<div class="btn">
				<button type="submit" id="accession">가입완료</button>
				<button type="button" id="cancel">취소</button>
			</div>
		</form>
	</div>

	<script>
		document.getElementById("cancel").onclick = function() {
			location.href = "/";
		};

		let id = document.getElementById("id");
		let password = document.getElementById("password");
		let password1 = document.getElementById("password1");

		let name = document.getElementById("name");
		let phone = document.getElementById("phone");
		let email = document.getElementById("email");

		let zipcode = document.getElementById("zipcode");
		let address = document.getElementById("address1");
		let address1 = document.getElementById("address2");
		let form = document.getElementById("frm");

		let idRegex = /^[a-z0-9_]{1,30}$/;
		let passUpperRegex = /[A-Z]/;
		let passLowRegex = /[a-z]/;
		let passNumberRegex = /\d/;
		let passSpecialRegex = /[!@#$%^&*]/;
		let passLengthRegex = /^.{8,}$/;
		let nameRegex = /^[가-힣]{2,5}$/;
		let phoneRegex = /^010-?\d{4}-?\d{4}$/;
		let emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

		$("#checkId").on("click", function() {

		    let idValue = id.value;

		    if (!idRegex.test(idValue)) {
		        alert("아이디가 형식에 맞지 않습니다.");
		        id.focus();
		        return;
		    }

		    $.ajax({
		        url: "/members/idcheck",
		        data: {id: idValue},
		        dataType: "json"
		    }).done(function(resp) {

		        if (resp) {
		            $("#idResult").html("사용 가능한 아이디입니다.");
		            id.setAttribute("check", "true");
		        } else {
		            $("#idResult").html("이미 사용 중인 아이디입니다.");
		            id.setAttribute("check", "false");
		        }

		    }).fail(function() {
		        alert("중복검사 중 오류가 발생했습니다.");
		    });
		});

		$("#id").on("input", function() {
		    id.setAttribute("check", "false");
		    $("#idResult").html("");
		});
//			window.open("/members/idcheck?id=" + idValue, "", "width=400,height=300");

		form.onsubmit = function(e) {

			if (!idRegex.test(id.value)) {
				e.preventDefault();
				alert("아이디가 형식에 맞지 않습니다.");
				id.focus();
				return;
			}

			if (!passUpperRegex.test(password.value)) {
				e.preventDefault();
				alert("비밀번호에 대문자를 하나 이상 포함해주세요.");
				password.focus();
				return;
			}

			if (!passLowRegex.test(password.value)) {
				e.preventDefault();
				alert("비밀번호에 소문자를 하나 이상 포함해주세요.");
				password.focus();
				return;
			}

			if (!passNumberRegex.test(password.value)) {
				e.preventDefault();
				alert("비밀번호에 숫자를 하나 이상 포함해주세요.");
				password.focus();
				return;
			}

			if (!passSpecialRegex.test(password.value)) {
				e.preventDefault();
				alert("비밀번호에 특수문자를 하나 이상 포함해주세요.");
				password.focus();
				return;
			}

			if (!passLengthRegex.test(password.value)) {
				e.preventDefault();
				alert("비밀번호는 8자 이상이어야 합니다.");
				password.focus();
				return;
			}

			if (password.value !== password1.value) {
				e.preventDefault();
				alert("비밀번호가 일치하지 않습니다.");
				password1.focus();
				return;
			}

			if (!nameRegex.test(name.value)) {
				e.preventDefault();
				alert("이름은 한글로 2~5자로 입력해주세요.");
				name.focus();
				return;
			}

			if (!phoneRegex.test(phone.value)) {
				e.preventDefault();
				alert("올바른 전화번호 형식이 아닙니다.");
				phone.focus();
				return;
			}

			if (!emailRegex.test(email.value)) {
				e.preventDefault();
				alert("올바른 이메일 형식이 아닙니다.");
				email.focus();
				return;
			}

			if (zipcode.value === "" || address.value === "" || address1.value === "") {
				e.preventDefault();
				alert("주소를 모두 입력해주세요.");
				address1.focus();
				return;
			}
			
			if (id.getAttribute("check") != "true") {
			    e.preventDefault();
			    alert("아이디 중복검사를 해주세요.");
			    id.focus();
			    return;
			}
		}

		document.getElementById("search").onclick = function() {
			new kakao.Postcode({
				oncomplete : function(data) {
					zipcode.value = data.zonecode;
					address.value = data.jibunAddress;
				}
			}).open();
		};
	</script>
</body>
</html>