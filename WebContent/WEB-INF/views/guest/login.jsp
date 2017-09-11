<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style.css" type="text/css" rel="stylesheet" />
<link href="../css/style-login.css"  type="text/css" rel="stylesheet"/>
<title>guest_login</title>
</head>
<body>
<!-- header 부분 -->
<jsp:include page="../inc/header.jsp"></jsp:include>
<!-- main 부분 -->
<main class = "main">

<h1>LOGIN</h1>
<div>
	<div  class="login">
		<form action="$"  method = "post"><!-- url주소!!!작성해줘!!!! -->
		<label>ID</label><input type = "text" name = "id"/><br>
		<label>PW</label><input type = "text" name = "pw"/><br>
		<input type="submit" name="login" />
		</form>
	</div>
	<div>
		<a class="btn btn-default" href="">회원가입</a> 
         <a class="btn btn-img btn-cancel" href="">아이디/비밀번호 찾기</a> 
	</div>
</div>


</main>

</body>
</html> 