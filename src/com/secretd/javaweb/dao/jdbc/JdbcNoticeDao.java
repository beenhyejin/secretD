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
import com.secretd.web.entity.NoticeView;

public class JdbcNoticeDao implements NoticeDao {

	public List<NoticeView> getList(int page, String query) {
		List<NoticeView> list = null;
		String sql = "SELECT * FROM NoticeView WHERE title like ? order by regDate DESC limit ?,10";
		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		int offset = (page - 1) * 10;
		// JDBC �뱶�씪�씠踰� 濡쒕뱶
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// �뿰寃� / �씤利�
			Connection con = DriverManager.getConnection(url, "soonface", "2014");

			// �떎�뻾
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, offset);

			// 寃곌낵 媛��졇�삤湲�
			ResultSet rs = st.executeQuery();

			// Model
			list = new ArrayList<>();

			// 寃곌낵 �궗�슜�븯湲�
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

		// JDBC �뱶�씪�씠踰� 濡쒕뱶
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// �뿰寃� / �씤利�
			Connection con = DriverManager.getConnection(url, "sist", "cclass");

			// �떎�뻾
			Statement stCount = con.createStatement();

			// 寃곌낵 媛��졇�삤湲�
			ResultSet rsCount = stCount.executeQuery(sqlCount);

			rsCount.next();

			// Model
			count = rsCount.getInt("count");

			// 寃곌낵 �궗�슜�븯湲�

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
	public NoticeView get(String id) {

		// ------------------異쒕젰-----------------
		NoticeView n = null;
		String sql = "SELECT * FROM NoticeView WHERE id = ?";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC �뱶�씪�씠踰� 濡쒕뱶
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// �뿰寃� / �씤利�
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			// �떎�뻾
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			// 寃곌낵 媛��졇�삤湲�
			ResultSet rs = st.executeQuery();
			// 寃곌낵 �궗�슜�븯湲�
			if (rs.next()) {
				n = new NoticeView();
				n.setId(rs.getString("ID"));
				n.setTitle(rs.getString("TITLE"));
				n.setHit(rs.getInt("HIT"));
				n.setContent(rs.getString("CONTENT"));
				n.setRegDate(rs.getDate("REGDATE"));
				n.setWriterId(rs.getString("WRITERID"));
				n.setWriterName(rs.getString("WRITERNAME"));
				n.setCountCmt(rs.getInt("COUNTCMT"));
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
	public void edit(String id, String title, String content) {
		String sql = "UPDATE Notice SET title= ?,content = ? WHERE id = ?";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		// JDBC �뱶�씪�씠踰� 濡쒕뱶
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// �뿰寃� / �씤利�
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, content);
			st.setString(3, id);
			int result = st.executeUpdate();
			if (result == 1)
				System.out.println("�닔�젙�셿猷�");
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(String title, String content) {
		String sql = "INSERT INTO Notice(id,title, content, writerId) VALUES((select ifnull(max(cast(id as signed integer)),0)+1 from Notice as b),?,?,?)";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, content);
			st.setString(3, "robin");// !!!!!濡쒓렇�씤�븳 �븘�씠�뵒濡� 諛붽씀湲�
			int result = st.executeUpdate();
			if(result==1)
				System.out.println("湲��벑濡� �셿猷�");
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM Notice WHERE id = ?";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		// JDBC �뱶�씪�씠踰� 濡쒕뱶
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// �뿰寃� / �씤利�
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			int result = st.executeUpdate();
			if (result == 1)
				System.out.println("�궘�젣�셿猷�");
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
