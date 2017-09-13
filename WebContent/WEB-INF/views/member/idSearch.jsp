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
					<li>아이디 찾기</li>
				</ol>
			</div>
			<form method="post">
				<fieldset>
					<legend>아이디 찾기</legend>
					<div>
					가입할 때 입력하신 이름과 이메일를 통해서 찾을 수 있습니다.
					<table>
						<tbody>
							<tr>
								<th><label>이름</label></th>
								<td><input name="name" value="" /></td>
							</tr>
							<tr>
								<th><label>이메일</label>(입력예:aaa@naver.com)</th>
								<td><input name="email" /></td>
							</tr>
							<tr>
								<td><input type="submit" name="btn" value="다음" /></td>
							</tr>
						</tbody>
					</table>
					</div>
				</fieldset>
			</form>
			비밀번호를 분실한 경우는 <a href=pwdSearch>여기</a>를 클릭하세요
			</main>
		</div>
	</div>

	<!-- footer부분 -->
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>