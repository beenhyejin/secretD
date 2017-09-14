<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 글등록</title>
<link href="../../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../../css/style-notice.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- header 부분 -->
	<jsp:include page="../../inc/header.jsp" />

	<div id="body" class="clearfix">
		<div class="content-container">
			<!-- aside부분 -->
			<jsp:include page="../inc/aside.jsp" />
			<main id="main">
			<h2>공지사항</h2>
			<div>
				<h3>경로</h3>
				<ol>
					<li><a href="">home</a></li>
					<li><a href="">병원관리목록</a></li>
				</ol>
			</div>
			<form method="post" enctype="multipart/form-data">
				<table class="table">
					<tr>
						<th>진료과목</th>
						<th>병원명</th>
						<th>주소</th>
						<th>전화번호</th>
							
							
					</tr>
					<tr>
						<td><input name="subject" ></td>
						<td class="title text-left"><input name="name"></td>
						<td><input name="address"></td> 
						<td><input name="phone-number"></td> 
					</tr>
				</table>
				<div>
					<input type="submit" class="btn btn-default" value="등록" /> <a
						href="list" class="btn btn-default">취소</a>
				</div>
			</form>
			</main>
		</div>
	</div>
	<footer id="footer">
		<div class="content-container"></div>
	</footer>

</body>
</html>