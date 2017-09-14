package com.secretd.javaweb.dao;

import java.util.List;

import com.secretd.web.entity.Notice;
import com.secretd.web.entity.NoticeView;


public interface NoticeDao {
	List<Notice> getList(int page,String query);
	int getCount();
	Notice get(String id);
	int edit(String id, String title, String content,String fileName);
	int delete(String id);
	void getHitsCountup(int hits,String id);
	int insert(String title, String content, String fileName, String id);
}
