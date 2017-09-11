package com.secretd.javaweb.dao;

public interface MemberDao {
	
	int insert(String id, String pwd, String name, String email, String nickname);

}
