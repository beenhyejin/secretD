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

@WebServlet("/member/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberDao memberDao = new JdbcMemberDao();
		Member member = memberDao.get(id);

		if (member == null) {
			response.sendRedirect("login?error=1");
		} else if (!member.getPwd().equals(pwd))
			response.sendRedirect("login?error=2");
		else {
			request.getSession().setAttribute("id", id);
			String url = request.getParameter("returnURL");
			if (url != null)
				response.sendRedirect(url);
			else
				response.sendRedirect("../index");// returnURl이 없을때
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
/*		PrintWriter out = response.getWriter();
		String error = "";
		String _error = request.getParameter("error");*/

		/*if (error.equals("") || error.equals(null)) {//nullpointException오류
*/			request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);

	/*	} else {
			out.write("<script>alert('아이디 또는 비밀번호를 다시 확인하세요.\r\n"
					+ "secretD에 등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.');history.go(-1);</script>");
		}*/

	}

}