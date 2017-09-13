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

@WebServlet("/member/pwdSearch")
public class pwdSearchController extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String pwd=null;
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		MemberDao memberDao = new JdbcMemberDao();

		pwd = memberDao.get(id,name, email);
		System.out.println(id);


		if (!(pwd==null))
			response.sendRedirect("pwdSearch_ok?id_check="+id+"&pwd_check="+pwd);
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write("<script>alert('입력 하신 정보에 일치하는 회원을 찾을 수가 없습니다.');</script>");
		}

	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/pwdSearch.jsp").forward(request, response);
	}

}
