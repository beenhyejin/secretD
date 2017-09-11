package com.secretd.web.entity;

public class Hospital {
	private String Department;
	private String name;
	private String addr;
	private String phone;
	private String time;
	private String homepage;
	private String details;
	private String grade;
	private String map;
	private int key;
	
	public Hospital() {
	}
	
	public Hospital(String department, String name, String addr, String phone, String time, String homepage,
			String details, String grade, String map,  int key) {
		Department = department;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		this.time = time;
		this.homepage = homepage;
		this.details = details;
		this.grade = grade;
		this.map = map;
		this.key = key;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
}