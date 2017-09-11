package com.secretd.web.service.admin;

import java.util.List;

import com.secretd.web.entity.Disease;

public class DiseaseService {
	// 기본 리스트 불러오기
	public List<Disease> getDiseaseList() {
		return getDiseaseList(1);
	}
	
	public List<Disease> getDiseaseList(int page) {
		List<Disease> list = null;
		return list;
	}
	
	// 검색 키워드 해당 리스트 불러오기
	public List<Disease> getDiseaseList(String name) {
		return getDiseaseList(1,name);
	}
	
	// 페이지 넘김
	public List<Disease> getDiseaseList(int page, String name) {
		List<Disease> list = null;
		return list;
	}
}
