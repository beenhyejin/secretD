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

@WebServlet("/member/pwdSearch_ok")
public class PwdSearch_okController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		int result=0; //����й�ȣ�� ������Ʈ�� �����
		
		String pwd= "";
		String newpwd = "";
		String email = "";
		

		String _pwd = request.getParameter("pwd");
		String[] _newPwds = request.getParameterValues("newPwd");
		String pwd_check = request.getParameter("pwd_check");
		String id = request.getParameter("id_check");
/*		System.out.println("id_check : "+id_check);
		System.out.println("pwd_check : "+pwd_check);
		System.out.println(pwd);
		System.out.println(_newPwd[0]);
		System.out.println(_newPwd[1]);*/
		
		if (_pwd != null && !_pwd.equals(""))
			pwd= _pwd;


		if (pwd.equals("") || _newPwds[0].equals("") || _newPwds[1].equals("")) {
			out.println("<script language='javascript'>");
			out.println("alert('������ ��� �Է����ּ���~!'); history.go(-1);");
			out.println("</script>");
			out.flush();
		}
		else if(!_newPwds[0].equals(_newPwds[1]) && !_newPwds[0].equals("")) {
			out.println("<script language='javascript'>");
			out.println("alert('����й�ȣ�� ����й�ȣ Ȯ���� ��ġ���� �ʽ��ϴ�~'); history.go(-1);");
			out.println("</script>");
			out.flush();
		}
		else if(!pwd.equals(pwd_check)) {
			out.println("<script language='javascript'>");
			out.println("alert('���� ��й�ȣ�� ���� �ʽ��ϴ�.'); history.go(-1);");
			out.println("</script>");
			out.flush();
		}
		else {
			MemberDao memberDao = new JdbcMemberDao();
			result = memberDao.edit(id,_newPwds[0]);
			if(result==1)
				response.sendRedirect("login");//��й�ȣ ���������� home���� �Ѱ��� ������~
			else{
				out.println("<script language='javascript'>");
				out.println("alert('�˼��մϴ�. ��й�ȣ ������ ������ ������ϴ�.\n �ٽ� �õ����ּ���.'); history.go(-1);");
				out.println("</script>");
				out.flush();
			}

		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/pwdSearch_ok.jsp").forward(request, response);
	}
}
