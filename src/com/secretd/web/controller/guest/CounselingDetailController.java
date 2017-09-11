package com.secretd.web.controller.guest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.secretd.web.dao.CounselingDao;

import com.secretd.web.dao.jdbc.JdbcCounselingDao;
import com.secretd.web.entity.Comment;
import com.secretd.web.entity.Counseling;
import com.secretd.web.entity.Member;


@WebServlet("/guest/counseling-detail")



public class CounselingDetailController extends HttpServlet {

	@Override
	 protected void doGet(  HttpServletRequest request, 
	         HttpServletResponse response) throws ServletException, IOException{
		
		
		/*------------------첫 목록 보여주기-----------------------------   */   

		String _number = request.getParameter("number");
		String number="";
		if( _number != null  && ! _number.equals("") )
			number =  _number;
		String hit = request.getParameter("hit");
		CounselingDao counselingdao = new JdbcCounselingDao();
		request.setAttribute("detail",counselingdao.get(number));
	
		
		/*---------------------댓글목록 보여주기--------------------------------   */  

		
	request.setAttribute("list",counselingdao.getComment(number));

	     /*---------------------댓글달때 닉네임 찾아줌--------------------------------   */  
	request.setAttribute("m",counselingdao.getNickname(number));
	int result2=counselingdao.updateHit(number);
	System.out.println("결과"+result2);
	request.getRequestDispatcher("/WEB-INF/views/guest/counseling/detail.jsp").forward(request, response); //이어서 출발

	}
	
	

	protected void doPost(
         HttpServletRequest request, 
         HttpServletResponse response) throws ServletException, IOException {
	   
		request.setCharacterEncoding("UTF-8");
		
		String number = request.getParameter("number");
		String content = request.getParameter("content");
		String nickname= request.getParameter("nickname");
	
		
		System.out.println(number);
		System.out.println(content);
		System.out.println(nickname);
		
		CounselingDao counselingdao = new JdbcCounselingDao();
		int result=counselingdao.updateComment(number,content,nickname);
	
	      response.sendRedirect("counseling-detail?number="+number);
	  /*    sendRedirect그냥 딴페이지로 가는 거. 목록을 보여줘야되니까*/
		
	 /*  super.doPost(request, response);*/
	   
   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
