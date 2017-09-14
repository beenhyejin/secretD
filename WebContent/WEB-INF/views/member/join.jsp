<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/reset.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/id/join.css">

<script type="text/javascript">
	//회원가입 화면의입력값을 검사

	function checkValue() {
		//var form = document.userInfo;
		if (document.getElementById("idDuplication").value != "idCheck") {
			alert("아이디 중복체크를 해주세요.");
			history.go(-1);
		}
	}
	// 아이디 중복체크 화면open
	function openIdChk() {
		 var id = document.getElementById("userId").value;
		window.open("check-id?id="+id);
		document.getElementById("idDuplication").value = "idCheck";
	}
	// 아이디 입력창에 값 입력시 hidden에 idUncheck를 세팅한다.
	// 이렇게 하는 이유는 중복체크 후 다시 아이디 창이 새로운 아이디를 입력했을 때
	// 다시 중복체크를 하도록 한다.
	function inputIdChk() {
		document.getElementById("idDuplication").value = "idUncheck";
	}
</script>

</head>
<body>

	<jsp:include page="../inc/header.jsp" />

	<div class="space"></div>

	<main id="body" class="clearfix">
	<div class="content-container">
			<!-- aside부분 -->
			<jsp:include page="inc/aside.jsp" />
	
		<h1 class="join-logo">회원가입</h1>
		<div class="join-form" >
			<form action="join" name="userInfor" method="post">
				<p>아이디</p>
				<input id = "userId" name ="id" type="text" onkeydown="inputIdChk()" />
				<input type="button" value="중복확인" onclick="openIdChk()">    
                <input type="hidden" id="idDuplication" value="idUncheck" >	
				<p>비밀번호</p>
				<input name = "pwds" type="password" />
				<p>비밀번호 재입력</p>
				<input name="pwds" type="password" />
				<p>이름</p>
				<input name="name" type="text" />
				<p>이메일</p>
				<input name="email" type="text" />
				<p>닉네임</p>
				<input name="nickname" type="text" /><br />
			<input type="submit" class="btn btn-default btn-pad" name="btn" value = "확인" onclick="checkValue()"/>
			</form>
		</div>
	</div>
	</main>

	<jsp:include page="../inc/footer.jsp" />
</body>
</html>