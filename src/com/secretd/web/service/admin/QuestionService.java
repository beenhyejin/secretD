package com.secretd.web.service.admin;

import java.util.List;

import com.secretd.web.entity.Question;

public class QuestionService {
	// 기본 리스트 불러오기
	public List<Question> getQuestionList() {
		return getQuestionList(1);
	}
	
	public List<Question> getQuestionList(int page) {
		List<Question> list = null;
		return list;
	}
	
}
