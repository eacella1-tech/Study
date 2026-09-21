<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
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
	width: 600px;
	margin: 50px auto;
	padding: 35px;
	background-color: white;
	border: 1px solid #ddd;
	border-radius: 10px;
}

h2 {
	margin: 0 0 30px;
	text-align: center;
	font-size: 24px;
}

fieldset {
	margin: 0 0 20px;
	padding: 20px;
	border: 1px solid #ddd;
	border-radius: 7px;
}

legend {
	padding: 0 8px;
	font-size: 14px;
	font-weight: bold;
	color: #333;
}

.item {
	display: inline-block;
	width: 49%;
	margin-bottom: 15px;
	vertical-align: top;
}

.item label {
	display: block;
	margin-bottom: 7px;
	font-size: 13px;
	font-weight: bold;
	color: #555;
}

.item input {
	width: 100%;
	height: 38px;
	padding: 0 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #f8f8f8;
	font-size: 13px;
	color: #555;
}

.item input:focus {
	outline: none;
	border-color: #555;
	background-color: white;
}

.address .item:nth-child(1) {
	width: 100%;
}

.address .item:nth-child(2) {
	width: 50%;
}

.address .item:nth-child(3) {
	width: 100%;
}

.button-wrap {
	display: flex;
	justify-content: center;
	gap: 10px;
	margin-top: 25px;
}

.button-wrap button {
	width: 120px;
	height: 42px;
	border: none;
	border-radius: 5px;
	font-size: 14px;
	cursor: pointer;
}

.button-wrap button:first-child {
	background-color: #333;
	color: white;
}

.button-wrap button:first-child:hover {
	background-color: #222;
}

.button-wrap button:last-child {
	background-color: #eee;
	color: #444;
}

.button-wrap button:last-child:hover {
	background-color: #ddd;
}
#edit,
#update {
    background-color: #333;
    color: white;
}

#edit:hover,
#update:hover {
    background-color: #222;
}
.zipcode-wrap {
	display: flex;
	align-items: center;
	gap: 8px;
}

.zipcode-wrap input {
	flex: none;
	width: 100%;
}

#addressSearch {
	width: 100px;
	height: 38px;
	flex-shrink: 0;
	border: none;
	border-radius: 5px;
	background-color: #333;
	color: white;
	font-size: 12px;
	cursor: pointer;
	white-space: nowrap;
}

#addressSearch:hover {
	background-color: #222;
}


</style>
</head>

<body>

	<div class="container">
        <h2>마이페이지</h2>
        <form action="${pageContext.request.contextPath}/members/update" method="post">
	        <fieldset>
	            <legend>기본 계정 정보</legend>
	
	            <div class="item">
	                <label>아이디</label>
	                <input type="text" id="id" readonly>
	            </div>
	
	            <div class="item">
	                <label>이름</label>
	                <input type="text" name="name" id="name" readonly readonly class="editable">
	            </div>
	
	            <div class="item">
	                <label>연락처</label>
	                <input type="text" name="phone" id="phone" readonly readonly class="editable">
	            </div>
	
	            <div class="item">
	                <label>이메일</label>
	                <input type="text" name="email" id="email" readonly readonly class="editable">
	            </div>
	
	            <div class="item">
	                <label>비밀번호</label>
	                <input type="password" value="*******" readonly>
	            </div>
	
	            <div class="item">
	                <label>가입일자</label>
	                <input type="text" value="<fmt:formatDate value='${dto.regdate}' 
	                	pattern='yyyy-MM-dd HH:mm:ss'/>" readonly>
	            </div>
	
	        </fieldset>
	
	        <fieldset class="address">
	            <legend>주소 정보</legend>

				<div class="item">
					<label>우편 번호</label>
					<div class="zipcode-wrap">
						<input type="text" name="zipcode" id="zipcode" readonly>
						<button type="button" id="addressSearch" style="display: none;">우편번호 찾기</button>
					</div>
				</div>

				<div class="item">
	                <label>기본주소</label>
	                <input type="text" name="address1" id="address1" readonly>
	            </div>
	
	            <div class="item">
	                <label>상세주소</label>
	                <input type="text" name="address2" id="address2" readonly class="editable"> 
	            </div>
	
	        </fieldset>
	
	        <div class="button-wrap">
			    <button type="button" id="edit">수정</button>
			    <button type="sumbit" id="update" style="display:none;">수정완료</button>
			
			    <button type="button" id="home">홈으로</button>
			    <button type="button" id="cancel" style="display:none;">취소</button>
			</div>
	</form>
    </div>	
    <script>
    $(document).ready(function() {

        $.ajax({
            url: "/members/mypageData",
            dataType: "json"
        }).done(function(resp) {

            $("#id").val(resp.id);
            $("#name").val(resp.name);
            $("#phone").val(resp.phone);
            $("#email").val(resp.email);

            $("#zipcode").val(resp.zipcode);
            $("#address1").val(resp.address1);
            $("#address2").val(resp.address2);

        }).fail(function() {
            alert("회원정보를 불러오는 중 오류가 발생했습니다.");
        });

    });
    let originalValues = {};
    
    
	    $("#edit").click(function() {
	    	
	    	$(".editable").each(function() {
	            originalValues[$(this).attr("name")] = $(this).val();
	        });
	    	$("#cancel").show();
	        $("#update").show();
	        
	        $("#addressSearch").show();
	        
	        $("#edit").hide();
	        $("#home").hide();
	        
	        
	        $(".editable").prop("readonly", false)
    	});	
	    
	    $("#cancel").click(function() {
	    	
	    	$(".editable").each(function() {
	            $(this).val(originalValues[$(this).attr("name")]);
	        });
	    	
	    	 $(".editable").prop("readonly", true);
	    	
	        $("#update").hide();
	        $("#cancel").hide();

	        $("#addressSearch").hide();
	        
	        $("#edit").show();
	        $("#home").show();
	    });
	    
	    $("#update").click(function() {
	    	$("#edit").show();
	    	$("#home").show();
	    	
	    	$("#update").hide();
	    	$("#cancel").hide();
	    });
	    
	    $("#addressSearch").click(function() {
	    	new kakao.Postcode({
	    		oncomplete: function(data) {
	    			$("input[name='zipcode']").val(data.zonecode);
	    			$("input[name='address1']").val(data.roadAddress);
	    			$("input[name='address2']").focus();
	    		}
	    	}).open();
	    });
	    
	    document.getElementById("home").onclick = function() {
	    	location.href = "/";
	    }
    </script>
</body>


</html>