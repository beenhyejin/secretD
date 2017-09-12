package com.secretd.javaweb.dao;

import java.util.List;

import com.secretd.web.entity.Notice;
import com.secretd.web.entity.NoticeView;


public interface NoticeDao {
	List<NoticeView> getList(int page,String query);
	int getCount();
	Notice get(String id);
	void edit(String id, String title, String content);
	void insert(String title, String content);
	void delete(String id);
	void getHitsCountup(int hits,String id);
}
