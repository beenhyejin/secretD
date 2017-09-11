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



@WebServlet("/admin/notice/detail")
public class NoticeDetailController extends HttpServlet{
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     	   
	   request.setCharacterEncoding("UTF-8");
		String  _id = request.getParameter("id"); 
		String id = "";	
		if(_id != null && !_id.equals(""))
			id=_id;  
	   //Model
	   NoticeDao dao = new JdbcNoticeDao();
	   Notice n = dao.get(id);	
		request.setAttribute("detail",n);
        request.getRequestDispatcher("/WEB-INF/views/admin/notice/detail.jsp").forward(request, response);
   }
}
