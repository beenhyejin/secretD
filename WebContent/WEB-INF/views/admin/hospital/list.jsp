<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Notice List</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style-notice.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- header 부분 -->
	<jsp:include page="../../inc/header.jsp" />

	<div id="body" class="clearfix">
		<div class="content-container">
			<!-- aside부분 -->
			<jsp:include page="../inc/aside.jsp" />
			<main class="main">
			<h2 class="main title">공지사항</h2>
			<div>
				<h3>경로</h3>
				<ol>
					<li><a href="">home</a></li>
					<li><a href="">병원관리목록</a></li>
				</ol>
			</div>
			<div>
				<h3>병원 검색 폼</h3>
				<form method="get">
					<label>병원명</label> <input type="text" name="name" /> <input
						type="submit" />
				</form>
			</div>
			<form method="post">
				<table class="table table-list">
					<tr>
						<th>진료과목</th>
						<th>병원명</th>
						<th>주소</th>
						<th>전화번호</th>
						<th><input type="submit" name=del value="삭제"></th>

					</tr>
					<c:forEach var="h" items="${list}">
						<tr>
							<td>${ h.subject }</td>
							<td class="title text-left"><a href="edit?h_id=${h.id}">${h.name}</a></td>
							<td>${h.address}</td>
							<td>${ h.phone_number }</td>
							<td><input type="checkbox" name="check" value=${h.id}>
						</tr>
					</c:forEach>
				</table>
			</form>
			<div>
				<c:set var="page" value="${param.p}" />
				<c:set var="startNum" value="${page-(page-1)%5}" />
				<c:set var="lastNum"
					value="${fn:substringBefore((count/10)==0? count/10: count/10+1,'.')}" />
				<div>
					<a href="?p=1">이전</a>
				</div>
				<ul>
					<c:forEach var="i" begin="0" end="4">
						<c:set var="strong" />
						<c:if test="${page==(startNum+i)}">
							<c:set var="strong" value="text-strong" />
						</c:if>
						<c:if test="${startNum+i<=lastNum}">
							<li><a class="${strong}" href="?p=${startNum+i}">${startNum+i}</a></li>
						</c:if>
						<c:if test="${startNum+i>lastNum}">
							<li>${startNum+i}</li>
						</c:if>
					</c:forEach>
				</ul>
				<div>
					<c:if test="${lastNum>= startNum+5}">
						<a href="?p=${startNum+5}">다음</a>
					</c:if>
				</div>
			</div>
			<a class="btn btn-default" href="reg">병원추가</a> </main>
		</div>
	</div>
	<!-- footer부분 -->
	<jsp:include page="../../inc/footer.jsp" />
</body>
</html>