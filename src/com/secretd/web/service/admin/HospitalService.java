package com.secretd.web.service.admin;

import java.util.List;

import com.secretd.web.entity.Hospital;

public class HospitalService {
	// 기본 리스트 불러오기
	public List<Hospital> getHospitalList() {
		return getHospitalList(1);
	}
	
	public List<Hospital> getHospitalList(int page) {
		List<Hospital> list = null;
		return list;
	}
	
	// 검색 키워드 해당 리스트 불러오기
	public List<Hospital> getHospitalList(String name) {
		return getHospitalList(1,name);
	}
	
	// 페이지 넘김
	public List<Hospital> getHospitalList(int page, String name) {
		List<Hospital> list = null;
		return list;
	}
	
	// 병원 정보
	public Hospital getHospitalDetail(int key) {
		Hospital hos = null;
		return hos;
	}
}
