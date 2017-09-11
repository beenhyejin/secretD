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

        <div class="comment">
        	<table class="table-commentw">
        		<form action="comment_reg" method="post">
        			<h2 class = "main title">COMMENTS</h2>
        		<tr>
	        		<td>
	        		${m.nickname}	
	        		</td>
        		</tr>
        		<tr>
	        		<td>
	        			<div>
	        				 <textarea name="content" rows="5" cols="90"></textarea>	
	        			</div>
	        		</td>
	        		
	        		<td style ="float : right;">
	        		
 				<li><a href="">등록</a></li>
	        			
	        		
	        		</td>
                </tr>   

        		</form> 
        			</table>

        	    	
		
		
<!-- 목록창 -->



   

        </div>












</body>
</html>