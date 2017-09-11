<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style-counseling.css" type="text/css" rel="stylesheet" />
</head>
<body>



<%--  <c:if test="">  댓글 리스트가 있으면 --%>

        	<c:forEach var="co" items="${comment_list}"> 
        		<table class="table-commentL">
        		<form id="CommentForm">
					<tr>
						<td>${co.nickname}  :   </td>
						<td>${co.content}</td> <!-- 댓글내용 -->
					<!-- 	<td><a  href=""  >          [ 답변  ]</a></td> -->
					</tr>	
					<%-- <tr>
					
					<td style="padding-left:20px"> └ ${detail.email}</td> 
					
					</tr> --%>
					</form>
				 </c:forEach> 
        	</table>
        	

   
<%--  <jsp:include page="../counseling/comment_reg.jsp"/>		
		<jsp:param name="number" value="${detail.number}"/>
    </jsp:include> 
   --%>

	

 








</body>
</html>