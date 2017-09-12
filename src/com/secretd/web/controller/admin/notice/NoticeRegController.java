package com.secretd.web.controller.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.secretd.javaweb.dao.NoticeDao;
import com.secretd.javaweb.dao.jdbc.JdbcNoticeDao;

@WebServlet("/admin/notice/reg")
public class NoticeRegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int count =0;
		String id = null;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		id = (String)session.getAttribute("id");

		System.out.println("id: "+id);
		
		if(session.getAttribute("id")==null) {
			out.write("<script>alert('로그인 필요');location.href='../../member/login?returnURL=../admin/notice/reg';</script>");
			System.out.println("로그인 필요해");
		}
		else
			request.getRequestDispatcher("/WEB-INF/views/admin/notice/reg.jsp").forward(request, response);
	}
	// ----------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//Model
		NoticeDao dao = new JdbcNoticeDao();
		dao.insert(title, content);
		response.sendRedirect("list");
	}
}
