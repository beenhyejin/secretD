package com.secretd.web.service.admin;

import java.util.List;

import com.secretd.web.entity.Doctor;

public class DoctorService {
	// 기본 리스트 불러오기 
	public List<Doctor> getDoctorList() {
		return getDoctorList(1);
	}
	
	public List<Doctor> getDoctorList(int page) {
		List<Doctor> list = null;
		return list;
	}
	
	// 검색 키워드 해당 리스트 불러오기
	public List<Doctor> getDoctorList(String id) {
		return getDoctorList(1,id);
	}
	
	// 페이지 넘김
	public List<Doctor> getDoctorList(int page, String id) {
		List<Doctor> list = null;
		return list;
	}
}
