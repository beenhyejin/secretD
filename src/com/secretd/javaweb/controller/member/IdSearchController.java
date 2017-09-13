package com.secretd.javaweb.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secretd.javaweb.dao.MemberDao;
import com.secretd.javaweb.dao.jdbc.JdbcMemberDao;
import com.secretd.web.entity.Member;

@WebServlet("/member/idSearch")
public class IdSearchController extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = null;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println(name);
		System.out.println(email);

		MemberDao memberDao = new JdbcMemberDao();

		id = memberDao.get(name, email);
		System.out.println(id);


		if (!(id==null))
			response.sendRedirect("idSearch_ok?id="+id);
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write("<script>alert('입력 하신 정보에 일치하는 회원을 찾을 수가 없습니다.');history.go(-1);</script>");
		}

	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/idSearch.jsp").forward(request, response);
	}

}
