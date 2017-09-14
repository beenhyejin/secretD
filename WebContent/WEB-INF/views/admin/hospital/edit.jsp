<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../../css/style-notice.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- header 부분 -->
	<jsp:include page="../../inc/header.jsp" />

	<!-- visual 부분 -->
	<jsp:include page="../inc/visual.jsp" />


	<div id="body" class="clearfix">
		<div class="content-container">
			<!-- aside부분 -->
			<jsp:include page="../inc/aside.jsp" />

			<form method="post" enctype="multipart/form-data">
				<table class="table table-list">
				<tr>
					<th>진료과목</th>
					<th>병원명</th>
					<th>주소</th>
					<th>전화번호</th>
				</tr>
					<tr>
						<td><input name="subject" value=${detail.subject }></td>
						<td class="title text-left"><input name="name"	value=${detail.name}></td>
						<td><input name="address" value=${detail.address}></td> 
						<td><input name="phone-number" value=${detail.phone_number}></td> 
					</tr>
			</table>
 
				<div>
					<input type="hidden" name="id" value=${ detail.id }>
					<!-- 어떠한 값을 업데이트 할지 -->
					<input type="submit" class="btn btn-default" value="저장" />
					<!-- input에 있는 값, key가 있는 값만 전달 -->
					<a href="list" class="btn btn-default">취소</a>

				</div>
			</form>
			</main>
		</div>
	</div>
	<!-- footer부분 -->
	<jsp:include page="../../inc/footer.jsp" />

</body>
</html>