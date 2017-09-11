<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path"  value="${pageContext.request.contextPath }"/>
    
<link href="../../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../../css/style-header.css" type="text/css" rel="stylesheet" />    
    
    
<header class="header">
	<div class="content-container">
		<h1>
			<a href="../../index.html"><img id="logo" src="${pageContext.request.contextPath }/images/logo.png"
				alt="SecretD logo" /></a>
		</h1>
		<div id="notice-header">
			<h2 class="hidden">머릿말</h2>
			<div id="head-menu" class="hr-list head-menu">
				<!-- <h3 class="hidden">사용자메뉴</h3> -->
				<ul>
					<li><a id="home" href="../../index.html">Home</a></li>
					<li><a href="../login.html">Login</a></li>
					<li><a href="../join.html">Join</a></li>
					<li><a href="../letter/list.html">Contact Us</a></li>
				</ul>
			</div>

			<div id="head-main-menu" class="hr-list head-main-menu">
				<!-- <h3 class="hidden">메인선택메뉴</h3> -->
				<ul>
					<li><a id="select-survey" href="../survey/start.html">자가진단</a></li>
					<li><a id="select-disease" href="../search/list.html">질병검색</a></li>
					<li><a id="select-counseling" href="../../member/counseling/list.html">고민상담</a></li>
					<li><a id="select-notice" href="../notice/list.html">공지사항</a></li>
				</ul>
			</div>
		</div>
	</div>
</header><%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value ="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style.css" type="text/css" rel="stylesheet" />
</head>

<body>

<header id="main-header" class="header">
	<div class="content-container">
		<h1>
			<a href="${path}/index.html"><img src="${path}/images/logo-resize.png" alt="SecretD logo" /></a>
			<a id="logo-txt"><img src="${path}/images/text-logo.png" alt="SecretD txt logo" /></a>
		</h1>
		<div id="main-head-menu" class="hr-list main-head-menu">
			<h2 class="hidden">머릿말</h2>
			<div>
				<h3 class="hidden">사용자메뉴</h3>
				<ul>
					<li><a id="home" href="${path}/index.html">Home</a></li>
					<li><a href="${path}/login.html">Login</a></li>
					<li><a href="${path}/join.html">Join</a></li>
					<li><a href="${path}/letter/list.html">Contact Uss</a></li>
				</ul>
			</div>                 
			

			<div>
				<h3 class="hidden">메인선택메뉴</h3>
				<ul>
					<li><a href="${path}/survey/start.html">자가진단</a></li>
					<li><a href="${path}/search/list.html">질병검색</a></li>
					<li><a href="../../member/counseling/list.html">고민상담</a></li>
					<li><a href="../notice/list.html">공지사항</a></li>
				</ul>
			</div>
		</div>
	</div>
</header>
</body>
</html> --%>