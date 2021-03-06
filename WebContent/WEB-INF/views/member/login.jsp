<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
			<h2>회원가입</h2>
			<div>
				<ol>
					<li>home</li>
					<li>회원정보</li>
					<li>login</li>
				</ol>
			</div>
			
			<form method="post">
				<fieldset>
					<legend>회원정보</legend>
					<table>
						<tbody>
							<tr>
								<th><label>아이디</label></th>
								<td><input name="id" value="" /></td>
							</tr>
							<tr>
								<th><label>비밀번호</label></th>
								<td><input name="pwd" /></td>
							</tr>

							<tr>
								<td><input type="submit" name="btn" value="로그인" /></td>
							</tr>
						</tbody>
					</table>
				</fieldset>
			</form>
			<div>
			아이디 또는 비밀번호를 분실하셨나요? <a href=idSearch>ID/PW 찾기</a>
			</div>
			<div>
			아이디가 없으신 분은 회원가입을 해주세요 <a href=join>회원가입</a>
			</div>
			</main>
		</div>
	</div>

	<!-- footer부분 -->
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>