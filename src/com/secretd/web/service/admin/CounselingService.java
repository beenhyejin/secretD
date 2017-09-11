package com.secretd.web.service.admin;

import java.util.List;

import com.secretd.web.entity.Comment;
import com.secretd.web.entity.Counseling;

public class CounselingService {
	// 기본 리스트 불러오기
	public List<Counseling> getCounselingList() {
		return getCounselingList(1);
	}
	
	public List<Counseling> getCounselingList(int page) {
		List<Counseling> list = null;
		return list;
	}
	
	// 해당 글 댓글 리스트 불러오기
	public List<Comment> getCounselingCommentList(int num) {
		List<Comment> list = null;
		return list;
	}
}
