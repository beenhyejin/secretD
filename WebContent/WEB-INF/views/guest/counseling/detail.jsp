<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style-counseling.css" type="text/css" rel="stylesheet" />

</head>
<body>
<!-- 헤더부분 -->
<!-- jsp action tag -->
<jsp:include page="../../inc/header.jsp"/>

   <div id="body" class="clearfix">
      <div class="content-container">

	<h2 class = "main title">고민상담</h2>

<!-- aside부분 -->
<jsp:include page="../inc/aside.jsp"/>	
      

         <main id="main">
       
         <table class="table">
         
         <tr>
        	<th>분류</th>
        	<td colspan="2">${detail.category}</td>
         </tr>
        
         <tr>
          	<th>제목</th>
          	<td colspan="3">${detail.title}</td>
          	
          	<th>작성자</th>
            <td>${detail.writer_id}</td>
            
            <th>날짜</th>
          	<td>${detail.date}</td>
         </tr>
         
          <tr>
          	<th>첨부파일</th>
         	<td colspan="3"></td>
         </tr>
            
           <tr >
          	<td colspan="8" style="text-align:left">${detail.content}

          	</td>
         </tr>
         
        	</table>
<!--    
   댓글입력폼 -->
        <div class="comment">
        	<table class="table-commentw">
        		<form method="post">
        			<h2 class = "main title">COMMENTS</h2>
        		<tr>
	        		<td>
	        		${m}	
	        		</td>
        		</tr>
        		<tr>
	        		<td>
	        			<div>
	        				 <textarea name="content" rows="5" cols="90"></textarea>	
	        			</div>
	        		</td>
	        		
	        		<td style ="float : right;">
	        	<%-- 	
 				<li><a href="?nickname=${m.nickname}">등록</a></li>
	        			 --%>
	        		 
       <div>
        <input type="hidden" name="number" value="${detail.number}"/>
        <input type="hidden" name="nickname" value="${m}"/>
        <input type="submit" class="btn btn-default">저장</a>
	      </div>  		
	        		
	        		</td>
                </tr>   

        		</form> 
        			</table>


   
<!-- 	댓글 목록 -->
        	<c:forEach var="co" items="${list}"> 
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
        	

        
    <!-- comment부분 -->
 <!-- list로 먼저감.. -->
 <%--     <jsp:include page="../counseling/comment_list.jsp">	
		<jsp:param name="number" value="${detail.number}"/>
    </jsp:include> 
  
 --%>
  
         <span class="btn btn-default" href="">글쓰기</span> 
         <a class="btn btn-img btn-cancel" href="">취소</a> 
         </main>
         
       
         
         
         
      </div>
   </div>
<!-- footer부분
 -->
<jsp:include page="../../inc/footer.jsp"/>

</body>
</html>