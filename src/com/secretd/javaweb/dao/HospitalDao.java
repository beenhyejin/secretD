package com.secretd.javaweb.dao;

import java.util.List;

import com.secretd.web.entity.Hospital;

public interface HospitalDao {

	List<Hospital> getList(int page, String query);

	int getCount();

	Hospital get(String id);

	int edit(String id, String subject, String name, String address, String phone_number);

	int delete(String h_id);

	int insert(String subject, String name, String address, String phone_number);

}
