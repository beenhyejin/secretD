package com.secretd.web.controller.guest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


@WebServlet("/guest/counseling-list")



public class CounselingListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest  request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		CounselingDao counselingDao = new JdbcCounselingDao();
		 request.setAttribute("list",counselingDao.getList());
		   

	/*-----------------------------------------------------   */  
	     
	     
	     
	     String _page = request.getParameter("p");
	     String _category=request.getParameter("category");
	     String _category2=request.getParameter("category2");
	     String _content = request.getParameter("content");
	     String _name = request.getParameter("sub");

	 	String category="";
		String name="";
		String category2="";
		String content="";

		int page=1; //전달이 안됐을 때 기본값

		int a=0;
		
	
		if(_page!=null && !_page.equals(""))
			page = Integer.parseInt(_page);
		
		if( _category != null  && ! _category.equals("") )
			category =  _category;
		
		if( _category2 != null  && ! _category2.equals("") )
			category2 =  _category2;
		
		if( _name != null  && ! _name.equals("") )
			name =  _name;

		if( _content != null  && ! _content.equals("") )
			content=  _content;
		
		

		if(name.equals("검색")) {
		   request.setAttribute("a", 1);
		   request.setAttribute("list3",counselingDao.getList2(category2,content));
		   request.setAttribute("count",counselingDao.getCount2(category2));
		}
		else {	
			request.setAttribute("a", 0);
			request.setAttribute("list2",counselingDao.getList(category,page));
			request.setAttribute("count",counselingDao.getCount2(category));
		}
	
	     /*----------------댓글 숫자-------------------------------------   */

		request.getRequestDispatcher("/WEB-INF/views/guest/counseling/list.jsp").forward(request, response); //이어서 출발
		
		
		
	}
	

	
}
