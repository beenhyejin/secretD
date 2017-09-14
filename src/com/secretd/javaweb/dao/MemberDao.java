package com.secretd.javaweb.dao;

import com.secretd.web.entity.Member;

public interface MemberDao {
	
	int insert(String id, String pwd, String name, String email, String nickname);
	
	Member get(String id);

	String get(String name, String email);

	String get(String id, String name, String email);

	int edit(String id, String string);

	boolean duplicateIdCheck(String id);

}
