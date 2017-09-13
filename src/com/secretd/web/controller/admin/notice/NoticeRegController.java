package com.secretd.web.controller.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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

@WebServlet("/admin/notice/reg")
public class NoticeRegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("reg-get에 들어옴");
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
		
		String path = "/upload";//url기반의 경로 -> 물리적인 경로

		ServletContext context = request.getServletContext();
		path = context.getRealPath(path);
		System.out.println("path : "+path);
		MultipartRequest req = new MultipartRequest(request, path, 1024*10124*1000,"UTF-8",new DefaultFileRenamePolicy());//lib -> cos.jar
		
		
		System.out.println("regpost에 들어옴");
		request.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		System.out.println("Notice title: "+title);
		String content = req.getParameter("content");
		/*
		String fname;
		Enumeration en = req.getFileNames();	
		while(en.hasMoreElements())
			fname= req.getFilesystemName((String)en.nextElement());	
	*/
		String fileName = req.getFilesystemName("file");//(String)req.getFileNames().nextElement();
		System.out.println("filename : "+fileName);
		
		//String fileName = req.getParameter("file");
		//Model
		NoticeDao dao = new JdbcNoticeDao();
		int result =dao.insert(title, content,fileName);
		if(result == 1)
			response.sendRedirect("list");
		//else
			
	}
}
