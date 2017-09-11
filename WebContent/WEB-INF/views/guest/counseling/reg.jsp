<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<jsp:include page="../../inc/header.jsp"/>



<div id="body" class="clearfix">
	<div class="content-container">
	
	<h2 class = "main title">고민상담</h2>
	
	
	<!-- aside부분 -->
<jsp:include page="../inc/aside.jsp"/>		
		<!-- 메인부분 -->
	<main id="main">
	<h2 class = "main title">작성</h2>

        <!--  form action=notice-list로 하면 현재 페이지와 같은 url이니까 지워도 상관없음 -->
     <table class="table">
         <form method="post">
        
         <tr>
          	<th>분류</th>
          	<td colspan=""> </td>
         </tr>
  		
  		 <tr>
          	<th>제목</th>
          	<td style="text-align: left; colspan="3"> <input name = "title"/> </td>
         </tr>


          <tr>
          	<th>첨부파일</th>
          	<td style="text-align: left"; colspan="3"><input name = "file"/></td>
         </tr>
         
          <tr>
          	<td colspan="10">
          	 <textarea name="content" rows="10" cols="125"></textarea>	
          	<!-- <textarea name = "content"></textarea> --></td>
         </tr>
</table>
       <div>
        <input type="submit" class="btn btn-default" value = "등록"></a>
    <!--     수정할 내용이 담겨있어야 해 --> <!-- 추가옵션이 필요. 뒤에 ?필요  쿼리스트림이라고 함 (옵션값) --> 
       <!--  <a href="notice-list" class="btn btn-default">취소</a>  -->
       </div>
        
        </form>
       
      
        

          
         </div>
	
		<!-- footer부분 -->
<jsp:include page="../../inc/footer.jsp"/>	

	</div>	
</main>



</body>
</html>