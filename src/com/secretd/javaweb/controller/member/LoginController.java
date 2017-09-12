package com.secretd.javaweb.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secretd.javaweb.dao.MemberDao;
import com.secretd.javaweb.dao.jdbc.JdbcMemberDao;
import com.secretd.web.entity.Member;



@WebServlet("/member/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDao memberDao = new JdbcMemberDao();

		Member member = memberDao.get(id);

		if (member == null)
			response.sendRedirect("login?error=1");
		else if (!member.getPwd().equals(pwd))
			response.sendRedirect("login?error=2");
		else {
			request.getSession().setAttribute("id", id);
			String url = request.getParameter("returnURL");
			if(url != null)			
				response.sendRedirect(url);
			else
				response.sendRedirect("../index");//로그인 성공했을때 이동페이지
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
	}

}