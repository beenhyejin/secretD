package com.secretd.javaweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.secretd.javaweb.dao.MemberDao;
import com.secretd.web.entity.Member;

public class JdbcMemberDao implements MemberDao {

	@Override
	public int insert(String id, String pwd, String name, String email, String nickname) {
		int result = 0;
		String sql = "INSERT INTO Member(id,pwd, name, email,nickname) VALUES(?,?,?,?,?)";
		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "soonface", "2014");
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

	@Override
	 public Member get(String id) {
	      Member member = null;
	      
	      String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	      String sql = "SELECT * FROM Member WHERE id=?";
	      
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection con = DriverManager.getConnection(url, "soonface", "2014");
	         PreparedStatement st = con.prepareStatement(sql);
	         st.setString(1, id);
	         ResultSet rs = st.executeQuery();
	         if(rs.next()) {
	        	 member = new Member(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
							rs.getString("email"), rs.getString("nickname"));
	         }
	         rs.close();
	         st.close();
	         con.close();
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }      
	      return member;
	   }

	@Override
	public String get(String name, String email) {
		String id = null;
		String sql = "SELECT * FROM Member WHERE name = ? && email=?";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, email);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				id = rs.getString("id");
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public String get(String id, String name, String email) {
		String pwd = null;
		String sql = "SELECT * FROM Member WHERE id=? && name = ? && email=? ";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, name);
			st.setString(3, email);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				pwd = rs.getString("pwd");
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pwd;
	}

	@Override
	public int edit(String id, String pwd) {
		int result = 0;
		String sql = "UPDATE Member SET pwd= ? WHERE id = ?";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, pwd);
			st.setString(2, id);
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
