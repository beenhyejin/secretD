package com.secretd.web.controller.guest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/guest/counseling-reg")



public class CounselingRegController extends HttpServlet {
/*
	protected void doPost(
         HttpServletRequest request, 
         HttpServletResponse response) throws ServletException, IOException {
	   
		request.setCharacterEncoding("UTF-8");
		
		String id =request.getParameter("id");
		String title=request.getParameter("title");
		String content = request.getParameter("content");
		
		  String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	      String sql = "insert into Notice (id, title,content,writerId) values ((select IFNULL(MAX(CAST(id as unsigned)),0)+1 from Notice as b) ,?,?,?)";
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url, "sist", "cclass");
	         // Statement st = conn.createStatement();
	         PreparedStatement st = conn.prepareStatement(sql);
	         st.setString(1, title);
	         st.setString(2, content);
	         st.setString(3, "newlec");

	         int result = st.executeUpdate();
	        업데이트 된 row갯수를 알려줌. st.executeUpdate

	         st.close();
	         conn.close();

	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      response.sendRedirect("list");
	      sendRedirect그냥 딴페이지로 가는 거. 목록을 보여줘야되니까
		
	   super.doPost(request, response);
	   
   }*/

      protected void doGet(  HttpServletRequest request, 
         HttpServletResponse response) throws ServletException, IOException{

     
      request.getRequestDispatcher("/WEB-INF/views/guest/counseling/reg.jsp").forward(request, response);
   }
	
	
	
	
	
	
	

}
