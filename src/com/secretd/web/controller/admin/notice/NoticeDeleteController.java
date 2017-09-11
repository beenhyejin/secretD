package com.secretd.web.controller.admin.notice;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secretd.javaweb.dao.NoticeDao;
import com.secretd.javaweb.dao.jdbc.JdbcNoticeDao;

@WebServlet("/admin/notice/delete")
public class NoticeDeleteController extends HttpServlet {
/*	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/admin/notice/delete.jsp").forward(request, response);
	}
	// ----------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		//Model
		NoticeDao dao = new JdbcNoticeDao();
		dao.delete(id);
		//등록 
		response.sendRedirect("list");
	}*/
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		//Model
		NoticeDao dao = new JdbcNoticeDao();
		dao.delete(id);
		//등록 
		response.sendRedirect("list");
	}
}
