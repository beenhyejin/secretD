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

@WebServlet("/member/join")
public class joinController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = "";
		String pwd = "";
		String name = "";
		String email = "";
		String nickname = "";

		String _id = request.getParameter("id");
		String[] _pwds = request.getParameterValues("pwds");
		String _name = request.getParameter("name");
		String _email = request.getParameter("email");
		String _nickname = request.getParameter("nickname");
		System.out.println("id : " + _id);
		System.out.println("_pwds[0] : " + _pwds[0]);
		System.out.println("_pwds[1]: " + _pwds[1]);
		System.out.println("name : " + _name);
		System.out.println("email : " + _email);
		System.out.println("nickname : " + _nickname);

		if (_id != null && !_id.equals(""))
			id = _id;
		if (_name != null && !_name.equals(""))
			name = _name;
		if (_email != null && !_email.equals(""))
			email = _email;
		if (_nickname != null && !_nickname.equals(""))
			nickname = _nickname;

		if (id.equals("") || _pwds[0].equals("") || _pwds[1].equals("") || name.equals("") || email.equals("")
				|| nickname.equals("")) {
			System.out.println("회원정보모두입력해줘");
			out.println("<script language='javascript'>");
			out.println("alert('회원정보를 모두 입력해주세요.'); history.go(-1);");
			out.println("</script>");
			out.flush();
		}

		// 비밀번호 재확인
		if (_pwds[0].equals(_pwds[1]) && !_pwds[0].equals("")) {
			pwd = _pwds[0];
			System.out.println("MemberDao에 들어왔어~");
			// -------------------DB(dao)-----------------------------------
			MemberDao memberDao = new JdbcMemberDao();
			int result = memberDao.insert(id, pwd, name, email, nickname);
			System.out.println("result" + result);
			if (result == 1)
				response.sendRedirect("login");//회원가입 성공했어@@@
			else{
				request.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(request, response);
				
			}
		}
		else if (!_pwds[0].equals(_pwds[1])&& !_pwds[0].equals("")&& !_pwds[1].equals("")) {
			System.out.println("비밀번호가 일치하는지 확인해줘");
			out.println("<script language='javascript'>");
			out.println("alert('비밀번호가 일치하는지 확인해주세요!'); history.go(-1);");
			out.println("</script>");
			out.flush();
		}
		

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(request, response);
	}

}
