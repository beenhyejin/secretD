<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 
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
	<h2 class = "main title">HOT 게시글</h2>
	
		<table class="table table-hot">
		<tr>
			<th class="w80">순번</th>
			<th class="w100 text-left">제목</th>
			<th class="w80">조회수</th>
		</tr>
		
		<c:forEach var="n" items="${list}">
					<tr>
						<td>${n.number}</td>
						<td class="title text-left text-indent"><a href="counseling-detail?number=${n.number}">${n.title}[  ${n.count}  ]</td>
						<td>${n.hit}</td>
						
					</tr>
				</c:forEach>
		
		
		</table>

	
	<div class="search-list">
			<h1 class="hidden">선택</h1>
            <ul>
               <li><a href="counseling-list">전체</a></li>
               <li><a href="counseling-list?category=산부인과">산부인과</a></li>
               <li><a href="counseling-list?category=비뇨기과">비뇨기과</a></li>
               <li><a href="counseling-list?category=항외과">항외과</a></li>
               <li><a href="counseling-list?category=기타">기타</a></li>
            </ul>
		</div>



	<div class="se">
		 <section id="search-form" >
            <h1 class = "hidden">검색!!</h1>
            <form method="get">
               <!-- <label>과정검색</label> -->
               <select name="category2">
         	  <option value = "">전체</option>
               	<option value ="산부인과">산부인과</option>
               	<option value ="비뇨기과">비뇨기과</option>
               	<option value ="항외과">항외과</option>
               	<option value ="기타">기타</option>
               </select>
     

               <h1 class="hidden">분야검색폼</h1>
             
                  <!-- <label>분야검색</label> -->
                   <input type="text" name="content" /> 
                   <input class="btn-img btn btn-search" type="submit" name="sub" value="검색" />
               </form>
            </section>
    
   </div>


   
   <!-- <h2 class = "main title">전체 목록</h2> -->
          	<table class= "table table-list">
		<tr>
			<th class="w80">순번</th>
			<th class="w100">제목</th>
			<th class="w80">조회수</th>
		</tr>
		
		<c:if test="${a == 1}">
		<c:forEach var="n" items="${list3}">
					<tr>
						<td>${n.number}</td>
						<td class="title text-left text-indent"><a href="counseling-detail?number=${n.number}">${n.title}[  ${n.count}  ]</td>
						<td>${n.hit}</td>
						
					</tr>
		</c:forEach>
		</c:if>
	
	<c:if test="${a == 0}">
			<c:forEach var="n" items="${list2}">
					<tr>
						<td>${n.number}</td>
						<td class="title text-left text-indent"><a href="counseling-detail?number=${n.number}">${n.title}[  ${n.count}  ]</td>
						<td>${n.hit}</td>
						
					</tr>
		</c:forEach>
		
</c:if>
	</table>

<c:set var="page" value="${param.p}"/>
<c:set var="startNum" value="${page-((page-1)%5) }"/>
<c:set var="lastNum" value="${fn:substringBefore((count%10 == 0 ? count/10 : count/10 +1),'.')}"/>
 
 <div class="num">
				<div><a href="?p=1">이전</a></div>
					<ul>
					<c:forEach var="i" begin="0" end="4">
					
					<c:set var="strong" value=""/>
					<c:if test="${page == startNum+i }">
						<c:set var="strong" value="text-strong"/>
						</c:if>
						
						<c:if test="${startNum+i <= lastNum}">
						<li><a class="${strong}" href="?p=${startNum+i}">${startNum+i}</a></li>
						</c:if>
					
					
					<!-- 	목록이 더이상 없으면 하이퍼링크 지움 -->
						<c:if test="${startNum+i > lastNum}">	
							<li>${startNum+i}</li>
						</c:if>
					</c:forEach>
					</ul>
				<div>
					<c:if test="${lastNum >= startNum+5 }">
					<a href="?p=${startNum+5}">다음</a>
					<!-- 게시물 목록이 다 끝나면 다음이 안보임  -->
					</c:if>
				</div>
 
 
    
       <!--   <a class="btn btn-default" href="counseling-reg">글쓰기</a>  -->
         </div>
	
		<!-- footer부분 -->
<jsp:include page="../../inc/footer.jsp"/>	

	</div>	
</main>



</body>
</html>