package com.secretd.web.controller.admin.notice;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secretd.javaweb.dao.NoticeDao;
import com.secretd.javaweb.dao.jdbc.JdbcNoticeDao;
import com.secretd.web.entity.Notice;

@WebServlet("/admin/notice/edit")
public class NoticeEditController extends HttpServlet{
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
	   String  _id = request.getParameter("id"); 
	   String id = ""; // 기본값	
		if(_id != null && !_id.equals(""))
			id=_id;
		//------------------출력-----------------
		Notice n= null;
		//-------------DB(dao)------------------
		NoticeDao noticeDao = new JdbcNoticeDao();
		n=noticeDao.get(id);	
		request.setAttribute("detail",n);
        request.getRequestDispatcher("/WEB-INF/views/admin/notice/edit.jsp").forward(request, response);
   }
   //----------------------------------------------------------------------------------------------------------------------------------------------------
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("UTF-8");
	   String id = request.getParameter("id");
	   String title = request.getParameter("title");
	   String content = request.getParameter("content"); 
	   //-------------------DB(dao)-----------------------------------
	   NoticeDao noticeDao = new JdbcNoticeDao();
	   noticeDao.edit(id,title,content);
	   response.sendRedirect("detail?id="+id);
	}
}
