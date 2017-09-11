package com.secretd.javaweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.secretd.javaweb.dao.MemberDao;

public class JdbcMemberDao implements MemberDao{

	@Override
	public int insert(String id, String pwd, String name, String email, String nickname) {
		int result =0;
		String sql = "INSERT INTO Notice(id,title, content, writerId) VALUES((select ifnull(max(cast(id as signed integer)),0)+1 from Notice as b),?,?,?)";
		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "soonface", "2014s");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, pwd);
			st.setString(3, name);
			st.setString(4, email);
			st.setString(5, nickname);
			result = st.executeUpdate();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
