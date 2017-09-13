package com.secretd.javaweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.secretd.javaweb.dao.NoticeDao;
import com.secretd.web.entity.Notice;
import com.secretd.web.entity.NoticeView;

public class JdbcNoticeDao implements NoticeDao {

	public List<NoticeView> getList(int page, String query) {
		List<NoticeView> list = null;
		String sql = "SELECT * FROM NoticeView WHERE title like ? order by regDate DESC limit ?,10";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		int offset = (page - 1) * 10;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, offset);
			ResultSet rs = st.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				NoticeView n = new NoticeView();
				n.setId(rs.getString("ID"));
				n.setTitle(rs.getString("TITLE"));
				n.setWriterId(rs.getString("WRITERID"));
				n.setWriterName(rs.getString("writerID"));
				n.setHit(rs.getInt("HIT"));
				n.setContent(rs.getString("CONTENT"));
				n.setRegDate(rs.getDate("REGDATE"));
				n.setCountCmt(rs.getInt("countCmt"));
				list.add(n);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public int getCount() {
		int count = 0;
		String sqlCount = "SELECT COUNT(id) as count FROM Notice";

		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			Statement stCount = con.createStatement();
			ResultSet rsCount = stCount.executeQuery(sqlCount);
			rsCount.next();
			count = rsCount.getInt("count");
			rsCount.close();
			stCount.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public Notice get(String id) {

		NoticeView n = null;
		String sql = "SELECT * FROM NoticeView WHERE id = ?";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				n = new NoticeView();
				n.setId(rs.getString("ID"));
				n.setTitle(rs.getString("TITLE"));
				n.setHit(rs.getInt("HIT"));
				n.setContent(rs.getString("CONTENT"));
				n.setRegDate(rs.getDate("REGDATE"));
				n.setWriterId(rs.getString("WRITERID"));
				n.setFileName(rs.getString("fileName"));
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int edit(String id, String title, String content,String fileName) {
		int result=0;
		String sql = "UPDATE Notice SET title= ?,content = ?,fileName=? WHERE id = ?";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, content);
			st.setString(3, fileName);
			st.setString(4, id);
			result = st.executeUpdate();
			System.out.println("edit result="+result);
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
	public int insert(String title, String content, String fileName) {
		int result =0;
		String sql = "INSERT INTO Notice(id,title, content, writerId,fileName) VALUES((select ifnull(max(cast(id as signed integer)),0)+1 from Notice as b),?,?,?,?)";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			System.out.println("db에 들어옴");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, content);
			st.setString(3, "robin");
			st.setString(4, fileName);
			result = st.executeUpdate();
			System.out.println("result : "+result);
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
	public int delete(String id) {
		int result=0;
		String sql = "DELETE FROM Notice WHERE id = ?";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
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
	public void getHitsCountup(int hit,String id) {
		hit++;
		String sql = "UPDATE Notice SET hit= ? where id =?";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, hit);
			st.setString(2, id);
			int result = st.executeUpdate();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
