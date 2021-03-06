package com.secretd.web.controller.admin.hospital;

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
import com.secretd.javaweb.dao.HospitalDao;
import com.secretd.javaweb.dao.NoticeDao;
import com.secretd.javaweb.dao.jdbc.JdbcHospitalDao;
import com.secretd.javaweb.dao.jdbc.JdbcNoticeDao;

@WebServlet("/admin/hospital/reg")
public class HospitalRegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = null;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		id = (String) session.getAttribute("id");
		if (session.getAttribute("id") == null) {
			out.write(
					"<script>alert('로그인 필요');location.href='../../member/login?returnURL=../admin/hospital/reg';</script>");

		} else
			request.getRequestDispatcher("/WEB-INF/views/admin/hospital/reg.jsp").forward(request, response);
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = "/upload";

		ServletContext context = request.getServletContext();
		path = context.getRealPath(path);
		System.out.println("path : " + path);
		MultipartRequest req = new MultipartRequest(request, path, 1024 * 10124 * 1000, "UTF-8",
				new DefaultFileRenamePolicy());// lib -> cos.jar
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		Object _id = session.getAttribute("id");
		String id = "";
		String subject = req.getParameter("subject");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String phone_number = req.getFilesystemName("phone_number");
		
		if (_id != null)
			id = _id.toString();
		String fileName = req.getFilesystemName("file");// (String)req.getFileNames().nextElement();
		HospitalDao dao = new JdbcHospitalDao();
		int result = dao.insert(subject, name,address, phone_number);
		if (result == 1)
			response.sendRedirect("list");
		else {
			response.sendRedirect("reg");
			out.println("<script language='javascript'>");
			out.println("alert('병원추가에 실패하였습니다\n 다시 시도해주세요!'); history.go(-1);");
			out.println("</script>");
			out.flush();
		}
	}
}
