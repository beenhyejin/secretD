package com.secretd.web.service.admin;

import java.util.List;

import com.secretd.web.entity.Member;

public class MemberService {
	// 기본 리스트 불러오기 
	public List<Member> getMemberList() {
		return getMemberList(1);
	}
	
	public List<Member> getMemberList(int page) {
		List<Member> list = null;
		return list;
	}
	
	// 검색 키워드 해당 리스트 불러오기
	public List<Member> getMemberList(String id) {
		return getMemberList(1,id);
	}
	
	// 페이지 넘김
	public List<Member> getMemberList(int page, String id) {
		List<Member> list = null;
		return list;
	}
}
