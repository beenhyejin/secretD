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


@WebServlet("/member/check-id")
public class IdCheckController extends HttpServlet{	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String check_id = request.getParameter("id");
		MemberDao dao = new JdbcMemberDao();
		boolean checkIdresult = dao.duplicateIdCheck(check_id);
		if(!checkIdresult)
			out.write("<script>alert('사용가능한 아이디입니다.');history.go(-1);self.close();</script>");
		else
			out.write("<script>alert('아이디가 중복되었습니다');history.go(-1);self.close();</script>");
		
	}

}
