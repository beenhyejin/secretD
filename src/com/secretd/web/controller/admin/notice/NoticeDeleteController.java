package com.secretd.web.controller.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secretd.javaweb.dao.NoticeDao;
import com.secretd.javaweb.dao.jdbc.JdbcNoticeDao;

@WebServlet("/admin/notice/delete")
public class NoticeDeleteController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result =0;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		//Model
		NoticeDao dao = new JdbcNoticeDao();
		result = dao.delete(id);
		//등록 
		if(result>0)
			response.sendRedirect("list");
		else
			out.write("<script>alert('죄송합니다. 삭제을 실패하였습니다.\n다시 시도해주세요ㅠㅠ');location.href='../admin/notice/detail?id="+id+"';</script>");
			
	}
}
