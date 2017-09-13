<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- 헤더부분 -->
	<jsp:include page="../inc/header.jsp" />


	<!--   비주얼부분 -->
	<jsp:include page="inc/visual.jsp" />

	<div id="body" class="clearfix">
		<div class="content-container">

			<!-- aside부분 -->
			<jsp:include page="inc/aside.jsp" />

			<main id="main">
			<h2>아이디 찾기</h2>
			<div>
				<ol>
					<li>home</li>
					<li>아이디 찾기완료</li>
				</ol>
			</div>
			<form method="post">
				<fieldset>
					<legend>회원정보</legend>
					<div>
					<label>아이디</label>${param.id	}
					</div>
					<a href=login>로그인</a>
					비밀번호를 분실한 경우는 <a href=pwdSearch>여기</a>를 클릭하세요
				</fieldset>
			</form>
			</main>
		</div>
	</div>

	<!-- footer부분 -->
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>