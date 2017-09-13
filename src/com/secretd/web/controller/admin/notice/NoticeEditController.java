package com.secretd.web.controller.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.secretd.javaweb.dao.NoticeDao;
import com.secretd.javaweb.dao.jdbc.JdbcNoticeDao;
import com.secretd.web.entity.Notice;

@WebServlet("/admin/notice/edit")
public class NoticeEditController extends HttpServlet{
	 String id = ""; 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
	   String  _id = request.getParameter("id"); 
		if(_id != null && !_id.equals(""))
			id=_id;
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
	   response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("id") == null)
			out.write("<script>alert('로그인 필요');location.href='../../member/login?returnURL=../admin/notice/edit?id="+id+"';</script>");
		else {		
			String path = "/upload";//url기반의 경로 -> 물리적인 경로
			ServletContext context = request.getServletContext();
			path = context.getRealPath(path);
			MultipartRequest req = new MultipartRequest(request, path, 1024*10124*1000,"UTF-8",new DefaultFileRenamePolicy());//lib -> cos.jar
		  
		   request.setCharacterEncoding("UTF-8");
		   String id = req.getParameter("id");
		   String title = req.getParameter("title");
		   String content = req.getParameter("content"); 
		   String fileName = req.getFilesystemName("file");

		   //-------------------DB(dao)-----------------------------------
		   NoticeDao noticeDao = new JdbcNoticeDao();
		   int result = noticeDao.edit(id,title,content,fileName);
		   if(result>0)
			   response.sendRedirect("detail?id="+id);
		   else {
			   out.write("<script>alert('죄송합니다. 수정을 실패하였습니다.\n다시 시도해주세용!');location.href='../admin/notice/edit?id="+id+"';</script>");
		   }
		}
	}
}
